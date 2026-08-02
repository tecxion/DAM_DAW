CREATE DATABASE IF NOT EXISTS peliculas;
CREATE USER IF NOT EXISTS 'user'@'localhost' IDENTIFIED BY 'P1234';
GRANT ALL PRIVILEGES ON peliculas.* TO 'user'@'localhost';
FLUSH PRIVILEGES;
USE peliculas;
CREATE TABLE IF NOT EXISTS catalogo (
    pelicula_id INT PRIMARY KEY AUTO_INCREMENT,
    Titulo VARCHAR(100),
    director VARCHAR(100),
    Genero VARCHAR(50),
    anio_estreno INT,
    duracion_minutos INT
);


INSERT INTO catalogo (Titulo, director, Genero, anio_estreno, duracion_minutos) VALUES
('Inception', 'Christopher Nolan', 'Ciencia Ficcion', 2010, 148),
('Titanic', 'James Cameron', 'Drama', 1997, 195),
('The Matrix', 'Lana Wachowski', 'Accion', 1999, 136);