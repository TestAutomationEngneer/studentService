CREATE TABLE if not exists public.actor (
	id numeric PRIMARY KEY NULL,
	firstname varchar NOT NULL,
	lastname varchar NOT NULL,
	rating numeric NOT NULL
);