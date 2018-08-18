### 11 - Spring-Boot-11-SpringData-1-JPA-PostgreSQL
how to use @OneToOne, @JoinColumn, @JsonIgnore for spring boot and data in multiple table.<br/>
first one : create bottom table on any database called Users in pgAdmin 4.<br/> if you change database's name. you can change.
``` 
CREATE TABLE customer(
    id BIGINT PRIMARY KEY     NOT NULL,
    name VARCHAR(255),
    email VARCHAR(255)
);

CREATE TABLE details(
    id BIGINT PRIMARY KEY  NOT NULL,
    city VARCHAR(255),
    country VARCHAR(255),
    phone_number VARCHAR(255),
    customeid BIGINT,
    FOREIGN KEY (customerid) REFERENCES customer (id)
);
``` 
second one : Write localhost:8182/insert to insert data on database. then write other link
``` .  
localhost:8182/details  localhost:8182/customers   localhost:8182/customers   localhost:8182/customer/{id}
  localhost:8182/customerjson/{id}
``` 
