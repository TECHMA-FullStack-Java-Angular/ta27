
DROP table IF EXISTS user_roles;
DROP table IF EXISTS roles;
DROP table IF EXISTS users;


CREATE TABLE IF NOT EXISTS cientificos (
    dni VARCHAR(8)  not null,
    nom_apels VARCHAR(255),
    CONSTRAINT PK_cientificos PRIMARY KEY (dni)
);

CREATE TABLE IF NOT EXISTS proyecto (
    id VARCHAR(4),
    nombre VARCHAR(255),
    horas int,
    CONSTRAINT PK_proyecto PRIMARY KEY (id)   
);

CREATE TABLE IF NOT EXISTS asignado_a (
    id int NOT NULL AUTO_INCREMENT,
    cientifico VARCHAR(8),
    proyecto VARCHAR(4),
    precio INT,
    CONSTRAINT PK_asignado_a PRIMARY KEY (id),
    CONSTRAINT FK_asignado_a_cientificos FOREIGN KEY (cientifico) REFERENCES cientificos(dni),
    CONSTRAINT FK_asignado_a_proyecto FOREIGN KEY (proyecto) REFERENCES proyecto(id)
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

insert into cientificos (dni,nom_apels)values('1111111A','Cientifico 1');
insert into cientificos (dni,nom_apels)values('2222222B','Cientifico 2');
insert into cientificos (dni,nom_apels)values('3333333C','Cientifico 3');
insert into proyecto (id,nombre, horas)values('1A','Proyecto 1',200);
insert into proyecto (id,nombre, horas)values('2B','Proyecto 2',300);
insert into proyecto (id,nombre, horas)values('3C','Proyecto 3',400);
insert into asignado_a (id, cientifico, proyecto, precio)values(1,'3333333C','2B',20000);
insert into asignado_a (id, cientifico, proyecto, precio)values(2,'1111111A','3C',30000);
insert into asignado_a (id, cientifico, proyecto, precio)values(3,'2222222B','1A',10000);

INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');

INSERT INTO users(email, password, username) VALUES ('admin@TA27.com', '$2a$10$mR4MU5esBbUd6JWuwWKTA.tRy.jo4d4XRkgnamcOJfw5pJ8Ao/RDS', 'admin');
INSERT INTO users(email, password, username) VALUES ('user@TA27.com', '$2a$10$mR4MU5esBbUd6JWuwWKTA.tRy.jo4d4XRkgnamcOJfw5pJ8Ao/RDS', 'user');

INSERT INTO user_roles(user_id, role_id) VALUES (1, 1);
INSERT INTO user_roles(user_id, role_id) VALUES (1, 2);
INSERT INTO user_roles(user_id, role_id) VALUES (2, 1);
