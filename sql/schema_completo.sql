
CREATE DATABASE IF NOT EXISTS act4_t4_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE act4_t4_db;

DROP TABLE IF EXISTS mascota;
DROP TABLE IF EXISTS especie;
DROP TABLE IF EXISTS usuario;

CREATE TABLE especie (
    id     BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL
);

CREATE TABLE mascota (
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre     VARCHAR(255) NOT NULL,
    edad       INT,
    especie_id BIGINT,
    CONSTRAINT fk_mascota_especie
        FOREIGN KEY (especie_id) REFERENCES especie(id)
);

CREATE TABLE usuario (
    id       BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role     VARCHAR(50)  NOT NULL,
    CONSTRAINT uq_usuario_username UNIQUE (username)
);

INSERT INTO especie (nombre) VALUES
('Perro'),
('Gato'),
('Ave'),
('Conejo');

INSERT INTO mascota (nombre, edad, especie_id) VALUES
('Firulais', 3, 1),
('Michi',    2, 2),
('Piolín',   1, 3),
('Rocky',    5, 1),
('Nube',     4, 4);

