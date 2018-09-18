### 15 - Spring-Boot-15-SpringSecurity-(Simple)-JPA-PostgreSQL (with Static user and password)
How to use spring security with statick user and password datas on spring boot.<br/> 
First after PgAdmin4 open, you must run this project. database tables will be generated automatically. <br/>
How will database table to be generated automatically. Look at this applicaton.properties pls. Beacuse line 15. spring.jpa.hibernate.ddl-auto=create on application.properties.<br/>

but table is here
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
How to use spring security. look at this `webConfigurationClass.java` on Spring-Boot-15-SpringSecurity-(Simple)-JPA-PostgreSQL/src/main/java/com/example/demo/   <br>
You can use user and password to login when you run this project
`webConfigurationClass.java`
``` 
user / password / role
admin    / admin  / "ADMIN","USER"
fatihf   / 1234   / "ADMIN"
celal    / 006    / "USER"
aygar    / aygar  / "EDITOR"
arda     / 1905   / "EDITOR","USER"
``` 
