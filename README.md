DataBase:
Postgres
docker run --rm -d --name pg -e "POSTGRES_PASSWORD=postgres" -e POSTGRES_DB=actor -p 5432:5432 postgres


CREATE TABLE public.actor (
id numeric PRIMARY KEY NULL,
firstname varchar NOT NULL,
lastname varchar NOT NULL,
rating numeric NOT NULL
);


INSERT INTO actor (id,firstname,lastname,rating) VALUES (1, 'Brad', 'Pitt', 3);
INSERT INTO actor (id,firstname,lastname,rating) VALUES (2, 'Angelina', 'Jolie', 1);
INSERT INTO actor (id,firstname,lastname,rating) VALUES (3, 'Salma', 'Hayek', 2);

select * from actor


API
1. http://localhost:8090/actor/all
2. http://localhost:8090/actor/2
3. POST   http://localhost:8090/actor/create

POST
{
"id": 5,
"firstname": "Tom",
"lastname": "Cruize",
"rating": 5,
}

1. GET
   http://localhost:8090/student/2
2. swagger
   http://localhost:8090/swagger-ui/
3. Rapidoc
   http://localhost:8090/swagger/views/rapidoc
4. redoc
   http://localhost:8090/redoc