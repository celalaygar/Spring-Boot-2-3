### 12 - Spring-Boot-12-SpringData-2-JPA-PostgreSQL
how to use @OneToMany,@ManyToOne for spring boot and data in multiple table.<br/>
how to use specific sql query with @Query<br/>
first one : create bottom table on any database called Users in pgAdmin 4.<br/> if you change database's name. you can change.
``` 
CREATE TABLE car(
    id BIGINT PRIMARY KEY     NOT NULL,
    name VARCHAR(255),
    model INTEGER
);
CREATE TABLE customer(
    id BIGINT PRIMARY KEY     NOT NULL,
    name VARCHAR(255),
    email VARCHAR(255)
);

CREATE TABLE book(
    id BIGINT PRIMARY KEY  NOT NULL,
    nae VARCHAR(255),
    customeid BIGINT,
    FOREIGN KEY (customer_id) REFERENCES customer (id)
);
``` 
second one : Write localhost:8182/insert to insert data on database.
``` . 
localhost:8182/books    localhost:8182/book/{id}   localhost:8182/customers   localhost:8182/customer/{id}
``` 
