DataBase:
Postgres
docker run --rm -d --name pg -e "POSTGRES_PASSWORD=postgres" -e POSTGRES_DB=student -p 5432:5432 postgres


CREATE TABLE STUDENT(
id INT PRIMARY KEY     NOT NULL,
firstname           TEXT    NOT NULL,
lastname            TEXT     NOT NULL
);


INSERT INTO STUDENT (id,firstname,lastname) VALUES (1, 'Brad', 'Pitt');
INSERT INTO STUDENT (id,firstname,lastname) VALUES (2, 'Angelina', 'Jolie');
INSERT INTO STUDENT (id,firstname,lastname) VALUES (3, 'Salma', 'Hayek');

select * from student


API
1. http://localhost:9090/student/all
2. http://localhost:9090/student/2
3. POST   http://localhost:9090/student/create

POST
{
"id": 1,
"firstName": "Angelina",
"lastName": "Jolie"
}

1. GET
   http://localhost:9090/student/2
2. swagger
   http://localhost:9090/swagger-ui/
3. Rapidoc
   http://localhost:9090/swagger/views/rapidoc