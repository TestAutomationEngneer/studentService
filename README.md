DataBase:
Postgres
docker run --rm -d --name pg -e "POSTGRES_PASSWORD=postgres" -e POSTGRES_DB=actor -p 5432:5432 postgres


CREATE TABLE public.actor (
id numeric PRIMARY KEY NULL,
firstname varchar NULL,
lastname varchar NULL
);


INSERT INTO actor (id,firstname,lastname) VALUES (1, 'Brad', 'Pitt');
INSERT INTO actor (id,firstname,lastname) VALUES (2, 'Angelina', 'Jolie');
INSERT INTO actor (id,firstname,lastname) VALUES (3, 'Salma', 'Hayek');

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