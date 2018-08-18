
### 10 - Spring-Boot-10-JPA-PostgreSQL-CRUD-RESTful Services-And-Jsp
how to use postgresql with jpa for CRUD for RESTful and jsp file. `create, read, update, delete` <br/>
Open pdAdmin 4, use SQL Editor and make a query to create customer table in database called Personels.Also you can create any database called diffrent name.
``` 
CREATE TABLE customer(
    id BIGINT PRIMARY KEY     NOT NULL,
    firstname VARCHAR(20),
    lastname VARCHAR(20)
);
``` 
you can try below sample links.
``` 
localhost:8182/                 localhost:8182/customers          localhost:8182/customer/1
localhost:8182/rest/customers   localhost:8182/rest/customer/1 
``` 
