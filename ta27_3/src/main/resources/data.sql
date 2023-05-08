DROP table IF EXISTS user_roles;
DROP table IF EXISTS roles;
DROP table IF EXISTS users;

CREATE TABLE IF NOT EXISTS cajeros (
    codigo int  auto_increment,
    nom_apels VARCHAR(255),
    CONSTRAINT PK_cajeros PRIMARY KEY (codigo)
);

CREATE TABLE IF NOT EXISTS productos (
    codigo int auto_increment,
    nombre VARCHAR(100),
    precio int,
    CONSTRAINT PK_productos PRIMARY KEY (codigo)   
);

CREATE TABLE IF NOT EXISTS maquinas_registradoras (
    codigo int auto_increment,
    piso int,
    CONSTRAINT PK_maquinas_registradoras PRIMARY KEY (codigo)   
);

CREATE TABLE IF NOT EXISTS venta (
    id int AUTO_INCREMENT,
    cajero int,
    maquina int,
    producto INT,
    CONSTRAINT PK_venta PRIMARY KEY (id),
    CONSTRAINT FK_venta_cajeros FOREIGN KEY (cajero) REFERENCES cajeros(codigo),
    CONSTRAINT FK_venta_productos FOREIGN KEY (producto) REFERENCES productos(codigo),
    CONSTRAINT FK_venta_maquinas_registradoras FOREIGN KEY (maquina) REFERENCES maquinas_registradoras(codigo)
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

insert into cajeros (codigo,nom_apels)values(1,'Cajero 1');
insert into cajeros (codigo,nom_apels)values(2,'Cajero 2');
insert into cajeros (codigo,nom_apels)values(3,'Cajero 3');
insert into productos (codigo,nombre, precio)values(1,'Producto 1',200);
insert into productos (codigo,nombre, precio)values(2,'Producto 2',300);
insert into productos (codigo,nombre, precio)values(3,'Producto 3',400);
insert into maquinas_registradoras (codigo, piso)values(1,1);
insert into maquinas_registradoras (codigo, piso)values(2,2);
insert into maquinas_registradoras (codigo, piso)values(3,3);
insert into venta (id, cajero, maquina, producto)values(1,3,2,1);
insert into venta (id, cajero, maquina, producto)values(2,2,1,2);
insert into venta (id, cajero, maquina, producto)values(3,1,3,3);

INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');

INSERT INTO users(email, password, username) VALUES ('admin@ta27.com', '$2a$10$mR4MU5esBbUd6JWuwWKTA.tRy.jo4d4XRkgnamcOJfw5pJ8Ao/RDS', 'admin');
INSERT INTO users(email, password, username) VALUES ('user@ta27.com', '$2a$10$mR4MU5esBbUd6JWuwWKTA.tRy.jo4d4XRkgnamcOJfw5pJ8Ao/RDS', 'user');

INSERT INTO user_roles(user_id, role_id) VALUES (1, 1);
INSERT INTO user_roles(user_id, role_id) VALUES (1, 2);
INSERT INTO user_roles(user_id, role_id) VALUES (2, 1);