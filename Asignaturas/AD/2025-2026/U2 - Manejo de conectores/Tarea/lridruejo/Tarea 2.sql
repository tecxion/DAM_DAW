CREATE DATABASE IF NOT EXISTS los_coches_de_tunombre;

CREATE TABLE IF NOT EXISTS los_coches_de_tunombre.coches (
    matricula VARCHAR(15) PRIMARY KEY,
    marca VARCHAR(50) NOT NULL,
    modelo VARCHAR(50) NOT NULL,
    potencia VARCHAR(10) NOT NULL,
    combustible VARCHAR(20) NOT NULL
);