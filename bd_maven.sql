-- Active: 1712587474957@@127.0.0.1@5432@db_maven

CREATE TABLE Lugares (
	idLugar SERIAL ,
	nombre VARCHAR(100),
	descripcion TEXT,
	region VARCHAR(100),
	PRIMARY key(idLugar)
);

CREATE TABLE Razas (
	idRaza SERIAL ,
	nombre VARCHAR(100),
	descripcion TEXT,
    PRIMARY key(idRaza)
);

CREATE TABLE Eventos (
	idEvento SERIAL,
	nombre VARCHAR(100),
	descripcion TEXT,
	fecha DATE,
	fk_lugar INT,
    PRIMARY key(idEvento),
	FOREIGN KEY (fk_lugar) REFERENCES Lugares(idLugar)
);

CREATE TABLE Personajes (
	idPersonaje SERIAL ,
	nombre VARCHAR(100) ,
	fk_raza INT ,
	fk_lugar INT, --Lugar de origen
	descripcion TEXT,
    PRIMARY KEY(idPersonaje),
	FOREIGN KEY (fk_raza) REFERENCES Razas(idRaza),
	FOREIGN KEY (fk_lugar) REFERENCES Lugares(idLugar)
);

CREATE TABLE Personajes_Eventos (
	fk_personaje INT,
	fk_evento INT,
	FOREIGN KEY (fk_personaje) REFERENCES Personajes(idPersonaje),
	FOREIGN KEY (fk_evento) REFERENCES Eventos(idEvento)
);


INSERT INTO Lugares (nombre, descripcion, region)
VALUES ('Rivendel', 'Un valle élfico escondido entre las montañas', 'Eriador'),
       ('Mordor', 'La tierra oscura donde reside Sauron', 'Mordor'),
       ('Gondor', 'Un reino humano en decadencia que lucha contra Mordor', 'Gondor'),
       ('Rohan', 'Un reino de jinetes ubicado en las llanuras', 'Rohan'),
       ('El Bosque Negro', 'Un bosque peligroso habitado por criaturas oscuras', 'Eriador');

INSERT INTO Razas (nombre, descripcion)
VALUES ('Elfos', 'Seres inmortales de gran belleza y sabiduría'),
       ('Hobbits', 'Criaturas pequeñas y pacíficas que viven en la Comarca'),
       ('Enanos', 'Un pueblo robusto y habilitoso en la minería y la herrería'),
       ('Hombres', 'La raza más diversa de la Tierra Media, con diferentes reinos y culturas'),
       ('Orcos', 'Criaturas brutales y deformes al servicio de Sauron');


INSERT INTO Personajes (nombre, fk_raza, fk_lugar, descripcion)
VALUES ('Frodo Bolsón', (SELECT idRaza FROM Razas WHERE nombre = 'Hobbits'), (SELECT idLugar FROM Lugares WHERE nombre = 'La Comarca'), 'Un hobbit que lleva la carga de destruir el Anillo Único'),
       ('Gandalf', NULL, NULL, 'Un mago sabio y poderoso que guía a la Comunidad del Anillo'),
       ('Aragorn', (SELECT idRaza FROM Razas WHERE nombre = 'Hombres'), (SELECT idLugar FROM Lugares WHERE nombre = 'Gondor'), 'Un humano noble que reclama su destino como rey de Gondor'),
       ('Legolas', (SELECT idRaza FROM Razas WHERE nombre = 'Elfos'), (SELECT idLugar FROM Lugares WHERE nombre = 'Rivendel'), 'Un elfo guerrero y hábil arquero'),
       ('Gimli', (SELECT idRaza FROM Razas WHERE nombre = 'Enanos'), NULL, 'Un enano valiente y leal a sus amigos');

INSERT INTO Eventos (nombre, descripcion, fecha, fk_lugar)
VALUES
  ('Concilio de Elrond', 'Reunión donde se decide destruir el Anillo Único', '2023-12-01', (SELECT idLugar FROM Lugares WHERE nombre = 'Rivendel')),
  ('Batalla de los Campos de Pelennor', 'Gran batalla entre Gondor y Mordor', '2024-01-01', (SELECT idLugar FROM Lugares WHERE nombre = 'Gondor')),
  ('Destrucción del Anillo Único', 'Frodo arroja el Anillo al Monte del Destino', '2024-03-25', (SELECT idLugar FROM Lugares WHERE nombre = 'Mordor')),
  ('Coronación de Aragorn', 'Aragorn se convierte en rey de Gondor', '2024-05-01', (SELECT idLugar FROM Lugares WHERE nombre = 'Gondor')),
  ('Partida de los Elfos', 'Los Elfos abandonan la Tierra Media para navegar hacia Valinor', '2024-06-30', (SELECT idLugar FROM Lugares WHERE nombre = 'Rivendel'));

INSERT INTO Personajes_Eventos (fk_personaje, fk_evento)
VALUES
  -- Frodo Bolsón
  ((SELECT idPersonaje FROM Personajes WHERE nombre = 'Frodo Bolsón'), (SELECT idEvento FROM Eventos WHERE nombre = 'Concilio de Elrond')),
  ((SELECT idPersonaje FROM Personajes WHERE nombre = 'Frodo Bolsón'), (SELECT idEvento FROM Eventos WHERE nombre = 'Destrucción del Anillo Único')),
  
  -- Gandalf
  ((SELECT idPersonaje FROM Personajes WHERE nombre = 'Gandalf'), (SELECT idEvento FROM Eventos WHERE nombre = 'Concilio de Elrond')),
  
  -- Aragorn
  ((SELECT idPersonaje FROM Personajes WHERE nombre = 'Aragorn'), (SELECT idEvento FROM Eventos WHERE nombre = 'Batalla de los Campos de Pelennor')),
  ((SELECT idPersonaje FROM Personajes WHERE nombre = 'Aragorn'), (SELECT idEvento FROM Eventos WHERE nombre = 'Coronación de Aragorn')),
  
  -- Legolas
  ((SELECT idPersonaje FROM Personajes WHERE nombre = 'Legolas'), (SELECT idEvento FROM Eventos WHERE nombre = 'Batalla de los Campos de Pelennor')),
  
  -- Gimli
  ((SELECT idPersonaje FROM Personajes WHERE nombre = 'Gimli'), (SELECT idEvento FROM Eventos WHERE nombre = 'Batalla de los Campos de Pelennor'));
