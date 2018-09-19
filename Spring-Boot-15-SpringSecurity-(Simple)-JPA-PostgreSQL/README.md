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
How to use spring security and @Secured("USER"). look at this `webConfigurationClass.java` on Spring-Boot-15-SpringSecurity-(Simple)-JPA-PostgreSQL/src/main/java/com/example/demo/   <br>
You can use user and password to login when you run this project
`webConfigurationClass.java`
``` 
  USER     / PASSWORD     / ROLE
-------------------------------------------
- admin    / admin        / "ADMIN"
- celal    / celal        / "USER"
- arda     / arda         / "EDITOR"
``` 
Accessing links for roles
``` 
for ADMIN, ADMIN can access these links
localhost:8182/rest/customers/**    localhost:8182/userinfo/    localhost:8182/cust/
for USER, USER can acces these links
localhost:8182/rest/customers/**    localhost:8182/userinfo/    localhost:8182/rest/customer/{email}
for EDITOR, EDITOR can acces these links
localhost:8182/rest/customers/**    localhost:8182/userinfo/    localhost:8182/rest/cust
``` 
