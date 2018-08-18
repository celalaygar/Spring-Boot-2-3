### 13 - Spring-Boot-13-SpringData-3-JPA-Hibernate-PostgreSQL
how to use @Embeddable, @Embedded for Spring data on Spring Boot
``` 
CREATE TABLE car(
    id BIGINT PRIMARY KEY     NOT NULL,
    name VARCHAR(255),
    model INTEGER,
    details VARCHAR(255)
);
``` 
second one : First Write localhost:8182/insert_car to insert data on database.
``` . 
localhost:8182/insert_car    
``` 
Then write other links such as 
``` 
for Post method on Postman                  localhost:8182/car
for Put and Delete method on Postman        localhost:8182/car/{id}
``` 
Also write these links on Any Browser       
``` 
localhost:8182/car1/{id}                localhost:8182/car2/{id}
localhost:8182/car_with_name/{name}     localhost:8182/car_with_model/{model}
``` 
