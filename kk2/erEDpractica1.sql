SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS cursan;
DROP TABLE IF EXISTS hacen;
DROP TABLE IF EXISTS realizan;
DROP TABLE IF EXISTS alumnos;
DROP TABLE IF EXISTS asignaturas;
DROP TABLE IF EXISTS elaboran;
DROP TABLE IF EXISTS examenes;
DROP TABLE IF EXISTS practicas;
DROP TABLE IF EXISTS profesores;




/* Create Tables */

CREATE TABLE alumnos
(
	num_alu int NOT NULL AUTO_INCREMENT,
	nombre varchar(25),
	grupo varchar(15),
	PRIMARY KEY (num_alu),
	UNIQUE (num_alu)
);


CREATE TABLE asignaturas
(
	num_asi int NOT NULL,
	nombre varchar(25),
	num_profe int NOT NULL,
	PRIMARY KEY (num_asi),
	UNIQUE (num_asi),
	UNIQUE (num_profe)
);


CREATE TABLE cursan
(
	num_alu int NOT NULL,
	num_asi int NOT NULL,
	trimestre varchar(25),
	UNIQUE (num_alu),
	UNIQUE (num_asi)
);


CREATE TABLE elaboran
(
	cod_practica int NOT NULL,
	titulo varchar(25) NOT NULL,
	num_profe int,
	fecha date,
	UNIQUE (num_profe)
);


CREATE TABLE examenes
(
	num_exa int NOT NULL,
	npreguntas int,
	fecha date,
	PRIMARY KEY (num_exa),
	UNIQUE (num_exa)
);


CREATE TABLE hacen
(
	num_alu int NOT NULL,
	num_exa int NOT NULL,
	nota float(2,2),
	UNIQUE (num_alu),
	UNIQUE (num_exa)
);


CREATE TABLE practicas
(
	cod_practica int NOT NULL,
	titulo varchar(25) NOT NULL,
	nivel int,
	PRIMARY KEY (cod_practica, titulo)
);


CREATE TABLE profesores
(
	num_profe int NOT NULL,
	nombre varchar(25),
	PRIMARY KEY (num_profe),
	UNIQUE (num_profe)
);


CREATE TABLE realizan
(
	num_alu int NOT NULL,
	cod_practica int NOT NULL,
	titulo varchar(25) NOT NULL,
	nota int,
	fecha date,
	UNIQUE (num_alu)
);



/* Create Foreign Keys */

ALTER TABLE cursan
	ADD FOREIGN KEY (num_alu)
	REFERENCES alumnos (num_alu)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE hacen
	ADD FOREIGN KEY (num_alu)
	REFERENCES alumnos (num_alu)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE realizan
	ADD FOREIGN KEY (num_alu)
	REFERENCES alumnos (num_alu)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE cursan
	ADD FOREIGN KEY (num_asi)
	REFERENCES asignaturas (num_asi)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE hacen
	ADD FOREIGN KEY (num_exa)
	REFERENCES examenes (num_exa)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE elaboran
	ADD FOREIGN KEY (cod_practica, titulo)
	REFERENCES practicas (cod_practica, titulo)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE realizan
	ADD FOREIGN KEY (cod_practica, titulo)
	REFERENCES practicas (cod_practica, titulo)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE asignaturas
	ADD FOREIGN KEY (num_profe)
	REFERENCES profesores (num_profe)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE elaboran
	ADD FOREIGN KEY (num_profe)
	REFERENCES profesores (num_profe)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



