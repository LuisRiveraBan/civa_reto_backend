package com.example.civaRectoTecnico.security.filters;

import com.example.civaRectoTecnico.models.UsuarioEntity;
import com.example.civaRectoTecnico.security.jwt.JwUtils;
import org.springframework.security.authentication.BadCredentialsException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private JwUtils jwtUtils;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public JwtAuthenticationFilter(JwUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        try {
            UsuarioEntity userEntity = new ObjectMapper().readValue(request.getInputStream(), UsuarioEntity.class);
            String username = userEntity.getUsername();
            String password = userEntity.getPassword();

            if (username == null || password == null) {
                throw new BadCredentialsException("username y password no pueden ser nulos");
            }

            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);

            return getAuthenticationManager().authenticate(authenticationToken);
        } catch (IOException e) {
            throw new BadCredentialsException("Error al leer el cuerpo de la solicitud", e);
        }
    }
    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        User user = (User) authResult.getPrincipal();
        String token = jwtUtils.generateAccessToken(user.getUsername());
        response.addHeader("Authorization", token);
        Map<String, Object> httpResponse = new HashMap<>();
        httpResponse.put("token", token);
        httpResponse.put("message", "Autenticacion Correcta");
        httpResponse.put("Username", user.getUsername());
        httpResponse.put("status", 200);
        response.getWriter().write(objectMapper.writeValueAsString(httpResponse));
        response.setStatus(HttpStatus.OK.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().flush();
        response.getWriter().close();
    }
}