### 8 - SpringJPA-PostgreSQL-Example
first step
Open pdAdmin 4, use SQL Editor and make a query to create customer table in database called Personels
Also you can create any database called diffrent name.
``` 
CREATE TABLE customer(
    id BIGINT PRIMARY KEY     NOT NULL,
    firstname VARCHAR(20),
    lastname VARCHAR(20)
);
``` 
second step
``` 
First you need to write localhost:8182/save
Then you can try writing bottom any link
localhost:8182/findall
localhost:8182/findbyid?id=3  
localhost:8182/findbylastname?lastname=Terim
``` 
