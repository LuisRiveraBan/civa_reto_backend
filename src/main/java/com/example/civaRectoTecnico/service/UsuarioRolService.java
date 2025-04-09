package com.example.civaRectoTecnico.service;

import com.example.civaRectoTecnico.models.UsuarioEntity;
import com.example.civaRectoTecnico.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.Collections;

@Service
public class UsuarioRolService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UsuarioEntity usuarioEntity = usuarioRepository.findByUsernameRol(username)
                .orElseThrow(() -> {
                    return new UsernameNotFoundException("El usuario " + username + " no existe");
                });


        Collection<? extends GrantedAuthority> authorities = Collections.singleton(
                new SimpleGrantedAuthority("ROLE_" + usuarioEntity.getRol().getDescripcion())
        );

        return new User(usuarioEntity.getUsername(), usuarioEntity.getPassword(),
                true, true, true, true, authorities);
    }
}