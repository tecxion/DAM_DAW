
	
	
	
	CREATE TABLE producto (
	    id INT AUTO_INCREMENT PRIMARY KEY,
	    nombre VARCHAR(100) NOT NULL UNIQUE,
	    precio DECIMAL(10,2) NOT NULL,
	    tipo ENUM('ALIMENTACION', 'HIGIENE') NOT NULL
	);
	
	CREATE TABLE producto_alimentacion (
	    id_producto INT PRIMARY KEY,
	    caducidad INT NOT NULL,
	    CONSTRAINT fk_alimentacion_producto
	        FOREIGN KEY (id_producto) REFERENCES producto(id)
	        ON DELETE CASCADE
	);
	
	CREATE TABLE producto_higiene (
	    id_producto INT PRIMARY KEY,
	    uso_profesional BOOLEAN NOT NULL,
	    CONSTRAINT fk_higiene_producto
	        FOREIGN KEY (id_producto) REFERENCES producto(id)
	        ON DELETE CASCADE
	);
}



INSERT INTO producto (nombre, precio, tipo) VALUES
('manzana', 0.50, 'ALIMENTACION'),
('leche', 1.20, 'ALIMENTACION'),
('pan', 1.00, 'ALIMENTACION'),
('jabon', 2.50, 'HIGIENE'),
('champu', 3.75, 'HIGIENE'),
('detergente', 5.00, 'HIGIENE');

INSERT INTO producto_alimentacion (id_producto, caducidad)
SELECT id, 2 FROM producto WHERE nombre = 'manzana';

INSERT INTO producto_alimentacion (id_producto, caducidad)
SELECT id, 5 FROM producto WHERE nombre = 'leche';

INSERT INTO producto_alimentacion (id_producto, caducidad)
SELECT id, 1 FROM producto WHERE nombre = 'pan';

INSERT INTO producto_higiene (id_producto, uso_profesional)
SELECT id, false FROM producto WHERE nombre = 'jabon';

INSERT INTO producto_higiene (id_producto, uso_profesional)
SELECT id, false FROM producto WHERE nombre = 'champu';

INSERT INTO producto_higiene (id_producto, uso_profesional)
SELECT id, true FROM producto WHERE nombre = 'detergente';