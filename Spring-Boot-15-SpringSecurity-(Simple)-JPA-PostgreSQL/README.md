### 15 - Spring-Boot-15-SpringSecurity-(Simple)-JPA-PostgreSQL (with Static user and password)
How to use spring security and @Secured @Query with static user and password datas on spring boot and WebSecurityConfigurerAdapter.
- How will database's table be generated automatically. Look at this applicaton.properties pls. Beacuse write `spring.jpa.hibernate.ddl-auto=create` on application.properties on line 15. 
- First you must run this project. database tables will be generated automatically after PgAdmin4 open. <br/>
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
How to use spring security and @Secured("..."). look at this `webConfigurationClass.java` on Spring-Boot-15-SpringSecurity-(Simple)-JPA-PostgreSQL/src/main/java/com/example/demo/   <br>
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
Permitall links
localhost:8182/userinfo/

for ADMIN, ADMIN can access these links
localhost:8182/rest/customers/

for USER, USER can acces these links
localhost:8182/rest/customers/      localhost:8182/rest/customer-by-email/{email}/
localhost:8182/customer/{email}/    localhost:8182/rest/customerbyname/{name]   

for EDITOR, EDITOR can acces these links
localhost:8182/rest/cust/   localhost:8182/rest/customer-by-name/{name}/
``` 
