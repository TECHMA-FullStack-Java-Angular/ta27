DROP table IF EXISTS user_roles;
DROP table IF EXISTS roles;
DROP table IF EXISTS users;

CREATE TABLE IF NOT EXISTS facultad (
    codigo int  auto_increment,
    nombre VARCHAR(100),
    CONSTRAINT PK_facultad PRIMARY KEY (codigo)
);

CREATE TABLE IF NOT EXISTS investigadores (
    dni VARCHAR(8) NOT NULL,
    nom_apels VARCHAR(255),
    facultad INT,
    CONSTRAINT PK_investigadores PRIMARY KEY (dni),
    CONSTRAINT FK_investigadores FOREIGN KEY (facultad) REFERENCES facultad(codigo)
);

CREATE TABLE IF NOT EXISTS equipos (
    num_serie VARCHAR(4) NOT NULL,
    nombre VARCHAR(100),
    facultad INT,
    CONSTRAINT PK_equipos PRIMARY KEY (num_serie),
    CONSTRAINT FK_equipos FOREIGN KEY (facultad) REFERENCES facultad(codigo)
);

CREATE TABLE IF NOT EXISTS reserva (
	id INT auto_increment,
    dni VARCHAR(8),
    num_serie VARCHAR(4),
    comienzo datetime,
    fin datetime,
    CONSTRAINT PK_reserva PRIMARY KEY (id),
    CONSTRAINT FK_reserva_investigadores FOREIGN KEY (dni) REFERENCES investigadores(dni),
    CONSTRAINT FK_reserva_equipos FOREIGN KEY (num_serie) REFERENCES equipos(num_serie)
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

insert into facultad  (codigo,nombre)values(1,'Salud Publica');
insert into facultad  (codigo,nombre)values(2,'Derecho');
insert into facultad  (codigo,nombre)values(3,'Ingenieria');
insert into investigadores (dni,nom_apels, facultad)values('1111111A','Investigador 1',3);
insert into investigadores (dni,nom_apels, facultad)values('2222222B','Investigador 2',1);
insert into investigadores (dni,nom_apels, facultad)values('3333333C','Investigador 3',2);
insert into equipos (num_serie, nombre, facultad)values('1A','Equipo 1', 3);
insert into equipos (num_serie, nombre, facultad)values('2B','Equipo 2', 1);
insert into equipos (num_serie, nombre, facultad)values('3C','Equipo 3', 2);
insert into reserva (id, dni, num_serie, comienzo, fin)values(1,'3333333C','1A','2023-01-23 12:34:56','2023-04-23 12:34:56');
insert into reserva (id, dni, num_serie, comienzo, fin)values(2,'2222222B','2B','2020-04-23 12:34:56','2022-04-23 12:34:56');
insert into reserva (id, dni, num_serie, comienzo, fin)values(3,'1111111A','3C','2022-05-23 12:34:56','2023-05-23 12:34:56');

INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');

INSERT INTO users(email, password, username) VALUES ('admin@TA27.com', '$2a$10$mR4MU5esBbUd6JWuwWKTA.tRy.jo4d4XRkgnamcOJfw5pJ8Ao/RDS', 'admin');
INSERT INTO users(email, password, username) VALUES ('user@TA27.com', '$2a$10$mR4MU5esBbUd6JWuwWKTA.tRy.jo4d4XRkgnamcOJfw5pJ8Ao/RDS', 'user');

INSERT INTO user_roles(user_id, role_id) VALUES (1, 1);
INSERT INTO user_roles(user_id, role_id) VALUES (1, 2);
INSERT INTO user_roles(user_id, role_id) VALUES (2, 1);