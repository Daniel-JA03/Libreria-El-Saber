CREATE DATABASE BD_libreriaElSaber;
USE BD_libreriaElSaber;

CREATE TABLE autor (
cod_autor BIGINT PRIMARY KEY AUTO_INCREMENT,
nom_autor VARCHAR(100) NOT NULL
);

CREATE TABLE genero (
cod_genero BIGINT PRIMARY KEY AUTO_INCREMENT,
descripcion VARCHAR(100) NOT NULL
);

CREATE TABLE libro (
cod_libro BIGINT PRIMARY KEY AUTO_INCREMENT,
tit_libro VARCHAR(200) NOT NULL,
cod_autor BIGINT NOT NULL,
cod_genero BIGINT NOT NULL,
precio_libro DECIMAL(10,2) NOT NULL,
estado VARCHAR(200) NOT NULL,
FOREIGN KEY (cod_autor) REFERENCES autor(cod_autor),
FOREIGN KEY (cod_genero) REFERENCES genero(cod_genero)
);

INSERT INTO autor (nom_autor) VALUES
('Mario Vargas Llosa'),
('Gabriel García Márquez'),
('Isabel Allende');

SELECT * FROM autor;

INSERT INTO genero (descripcion) VALUES
('Literatura'),
('Ciencia Ficción'),
('Novela Histórica');

SELECT * FROM genero;

INSERT INTO libro (tit_libro, cod_autor, cod_genero, precio_libro, estado) VALUES
('La ciudad y los perros', 1, 1, 45.50, 'ACTIVO'),
('Cien años de soledad', 2, 1, 60.00, 'DESACTIVO'),
('La casa de los espíritus', 3, 3, 55.75, 'ACTIVO');

SELECT * FROM libro;