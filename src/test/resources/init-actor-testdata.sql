DROP SCHEMA public;
CREATE SCHEMA public;
DROP TABLE IF EXISTS actor;

CREATE TABLE public.actor (
id numeric PRIMARY KEY NULL,
firstname varchar NOT NULL,
lastname varchar NOT NULL,
rating numeric NOT NULL
);

INSERT INTO actor (firstname, lastname, rating, id) VALUES ('Brad', 'Pitt', 3, 1);
INSERT INTO actor (firstname, lastname, rating, id) VALUES ('Angelina', 'Jolie', 4, 2);
INSERT INTO actor (firstname, lastname, rating, id) VALUES ('Salma', 'Hayek', 2, 3);
