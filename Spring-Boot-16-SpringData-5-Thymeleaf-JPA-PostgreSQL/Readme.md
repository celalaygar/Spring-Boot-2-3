
### 16 - Spring-Boot-16-SpringData-5-Thymeleaf-JPA-PostgreSQL
how to use @ManyToMany and @JoinTable for spring boot and data in multiple table.<br/>
- You had bettet to look at this applicaton.properties pls. Database's table can be generated automatically, İf you write `spring.jpa.hibernate.ddl-auto=create` on application.properties.
- your database's table can create regularly when you wrote `spring.jpa.hibernate.ddl-auto=create` on application.properties
``` 
CREATE TABLE student(
    id INTEGER PRIMARY KEY     NOT NULL,
    name VARCHAR(255),
);
CREATE TABLE subject(
    id INTEGER PRIMARY KEY  NOT NULL,
    name VARCHAR(255)
);
``` 
