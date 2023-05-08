

CREATE TABLE IF NOT EXISTS piezas (
    codigo INT auto_increment,
    nombre VARCHAR(100),
    CONSTRAINT PK_piezas PRIMARY KEY (codigo)
);

CREATE TABLE IF NOT EXISTS proveedores (
    id VARCHAR(4)not null,
    nombre VARCHAR(100),
    CONSTRAINT PK_proveedores PRIMARY KEY (id)   
);

CREATE TABLE IF NOT EXISTS suministra (
    id int(11) NOT NULL AUTO_INCREMENT,
    codigo_pieza INT,
    id_proveedor VARCHAR(4),
    precio INT,
    CONSTRAINT PK_suministra PRIMARY KEY (id),
    CONSTRAINT FK_suministra_piezas FOREIGN KEY (codigo_pieza) REFERENCES piezas(codigo),
    CONSTRAINT FK_suministra_proveedores FOREIGN KEY (id_proveedor) REFERENCES proveedores(id)
);

CREATE TABLE users(
	id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(120) NOT NULL,
    username VARCHAR(20) UNIQUE NOT NULL
);

CREATE TABLE roles(
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20) DEFAULT NULL
);

CREATE TABLE user_roles(
	user_id INT(20) NOT NULL,
    role_id INT NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES users(id) ON UPDATE CASCADE ON DELETE CASCADE, 
    FOREIGN KEY (role_id) REFERENCES roles(id) ON UPDATE CASCADE ON DELETE CASCADE
);

insert into piezas (codigo,nombre)values(1,'Pieza1');
insert into piezas (codigo,nombre)values(2,'Pieza2');
insert into proveedores (id,nombre)values('1A','Proveedor1');
insert into proveedores (id,nombre)values('2B','Proveedor2');
insert into suministra (id, codigo_pieza, id_proveedor, precio)values(1,1,'2B',200);
insert into suministra (id, codigo_pieza, id_proveedor, precio)values(2,2,'1A',100);
INSERT INTO users (username, password, role) VALUES ('admin', '$2a$10$XURPShQNCsLjp1ESc2laoObo9QZDhxz73hJPaEv7/cBha4pk0AgP.','admin');

INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');

INSERT INTO users(email, password, username) VALUES ('admin@TA27.com', '$2a$10$mR4MU5esBbUd6JWuwWKTA.tRy.jo4d4XRkgnamcOJfw5pJ8Ao/RDS', 'admin');
INSERT INTO users(email, password, username) VALUES ('user@TA27.com', '$2a$10$mR4MU5esBbUd6JWuwWKTA.tRy.jo4d4XRkgnamcOJfw5pJ8Ao/RDS', 'user');

INSERT INTO user_roles(user_id, role_id) VALUES (1, 1);
INSERT INTO user_roles(user_id, role_id) VALUES (1, 2);
INSERT INTO user_roles(user_id, role_id) VALUES (2, 1);