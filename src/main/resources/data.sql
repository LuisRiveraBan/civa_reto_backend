INSERT INTO marca (marca) VALUES ("MERCEDES-BENZ");
INSERT INTO marca (marca) VALUES ("HYUNDAI");
INSERT INTO marca (marca) VALUES ("VOLVO");

INSERT INTO bus (numero_bus, placa, caracteristicas, activo, marca_id)VALUES (520,"N-123", "BUEN ESTADO", "1", 1);

INSERT INTO rol (descripcion) VALUES ("Admin");

INSERT INTO usuario (rol_id, apellido, correo_electronico, nombre, password, username)
VALUES (1, "turismo", "civa@gmail.com", "civa", "$2a$10$4C5kWhwIneWUfR4LZmsreegpfDLLHU27O.tSwSZ/P.Led8rJ2SxRa", "civaTurismo");


