### 14 - Spring-Boot-14-SpringData-4-Thymeleaf-JPA-PostgreSQL
how to use @ManyToOne for spring boot and data in multiple table.<br/>
how to use Thymeleaf with jpa hibernate on spring boot.<br/>
first one : create bottom table on any database called Users in pgAdmin 4.<br/> if you change database's name. you can change.
``` 
CREATE TABLE customer(
    id BIGINT PRIMARY KEY     NOT NULL,
    name VARCHAR(255),
    email VARCHAR(255),
    enabled boolen,
    password VARCHAR(255)
);
CREATE TABLE customer_role(
    id BIGINT PRIMARY KEY  NOT NULL,
    role_name VARCHAR(255),
    customeid BIGINT,
    FOREIGN KEY (customer_id) REFERENCES customer (id)
);
``` 
second one : Write localhost:8182/rest/insert to insert data on database.
``` . 
localhost:8182/customers    localhost:8182/rest/customers   localhost:8182/rest/cust
``` 
![Cat](https://github.com/celalaygar/Spring-Boot-2/blob/master/Spring-Boot-14-SpringData-4-Thymeleaf-JPA-PostgreSQL/customer%20table.png "Tables and Entity Classes")
