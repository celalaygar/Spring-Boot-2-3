### Spring-Boot-2
how to change port number? <br/>
if you wanna change port number, write (server.port=3132) command on application.properties in src/main/resources/application.properties. you can change port number in applicaton.properties. 
``` 
server.port=8182
``` 
##### for Referans how to learn spring technology. 
```
- https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
- https://www.logicbig.com/                           - https://howtodoinjava.com/
- https://o7planning.org/                             - https://www.concretepage.com/spring-boot/
- https://memorynotfound.com/                         - https://www.dineshonjava.com/

``` 
### 1 - spring-boot-HelloWorld
how to run project. Look at application.properties where Port number is there. 
``` 
Links: 
    http://localhost:3092/    http://localhost:3092/welcome
```
### 2 - spring-boot-view-JSP-File-1
How to use and view jsp file on spring boot
``` 
Links: 
http://localhost:8182/    http://localhost:8182/personels
```
### 3 - spring-boot-view-Error-Page
How to use and view Error page on spring boot<br/>
you can writer anylink  except bottom links. you have to add to src/main/resources/public/error 404.html (error page)<br/>
if you write one of bottom links, you can't see error page as error.html
``` 
http://localhost:8182/    http://localhost:8182/personels
``` 
if you write one of bottom links, you can see error page as error.html
``` 
http://localhost:8182/deneme                           http://localhost:8182/asd        
http://localhost:8182/asdqwe/121243dqwe?c=asldkwqe     http://localhost:8182/deneme.jsp
```
### 4 - springboot-(REST_API_QUERY) 
###### (Static)
how to use RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE and RequestMethod.GET<br/>
you can experiment with JUNİT on PersonelClinicRestControllerTest.java  (src/test/java/com/javaegitimleri/app/web/) 
```   
You can try runnuing anymethods with run as -> Junit Test in src/test/java/com/javaegitimleri/app/web/PersonelClinicRestControllerTest.java. 
Then you can look at changing data on localhost:8182/rest/personels
``` 
### 5 - springboot-with-h2-database (REST_API_QUERY)  (jdbc with h2 database)
how to create schema, table and add data with jdbc in table. you can look src/main/resources/ data.sql & schema.sql.<br/>
how to use h2 database with jdbc.
``` 
Also You can try runnuing createPersonelTest, deletePersonelTest methods with run as -> Junit Test 
in src/test/java/com/javaegitimleri/app/web/PersonelClinicRestControllerTest.java.
``` 
### 6 - springboot-jpa-with-h2-database (REST_API_QUERY)
how to use jpa with h2 database<br/>
how to use @Transactional, @Id, @GeneratedValue, @Entity, @Table @Column
### 7 - springboot-simple-security-example
how to use login and logout procedure<br/>
how to use specific login page <br/>
how to use remember me for security login<br/>
First you have to add spring-boot-starter-security dependency file in pom.xml. <br/>
look at application.properties file in src/main/resources/...
``` 
#you can change username and password. then you can try login proccessing
spring.security.user.name=celal
spring.security.user.password=123456
``` 
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
### 9 - springboot-security-with-h2-example
How to use login process<br/>
Anybody has ROLE_EDITOR or ROLE_ADMIN can enter links called /rest/** and /actuator/** for `AUTHORIZATION`.Anybody only has ROL_USER can't enter links called /rest/** and /actuator/**
- `links` -> `localhost:8182/rest/personels`, `localhost:8182/rest/personel/3`, `localhost:8182/rest/personel?fn=Celal`
- `links` -> `localhost:8182/actuator/health`
``` 
INSERT INTO USERS VALUES('user1','{noop}12345',TRUE);
INSERT INTO USERS VALUES('user2','{noop}secrett',TRUE);
INSERT INTO USERS VALUES('celal','{noop}secret',TRUE);
``` 
you can write data below first-three sql queries instead of above sql queris in src/main/resources/data.sql
```    
INSERT INTO USERS VALUES('user1','{bcrypt}$2a$10$FMQOTEUiRN1L2MV2gfYas.MEDnLcEffuenRme5WdFgkwcuWA2jyhG',TRUE);
INSERT INTO USERS VALUES('user2','{bcrypt}$2a$10$.qPu/z1bV0Lw5uSpv6YMKeiCUI4rsxfNY/HJJBgw9E7CYUULMW3CS',TRUE);
INSERT INTO USERS VALUES('celal','{bcrypt}$2a$10$m9RM8vLgWvu/8Ig21HURG.IHIeFEie8CsKaGV1FeQ88bi27Xz4wJS',TRUE);
``` 
username and password will be same again when you changed first-three lines in src/main/resources/data.sql.<br/>
for encrypted data you can look at PasswordEncoderTest.java class in src/test/com/javaegitimleri/ap/test
for example (encrypted data) 
- `12345` -> `{bcrypt}$2a$10$FMQOTEUiRN1L2MV2gfYas.MEDnLcEffuenRme5WdFgkwcuWA2jyhG`
- `secrett` -> `{bcrypt}$2a$10$.qPu/z1bV0Lw5uSpv6YMKeiCUI4rsxfNY/HJJBgw9E7CYUULMW3CS`
- `secret` -> `{bcrypt}$2a$10$m9RM8vLgWvu/8Ig21HURG.IHIeFEie8CsKaGV1FeQ88bi27Xz4wJS`

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
### 12 - Spring-Boot-12-SpringData-2-JPA-PostgreSQL
how to use @ManyToOne for spring boot and data in multiple table.<br/>
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
    name VARCHAR(255),
    customeid BIGINT,
    FOREIGN KEY (customer_id) REFERENCES customer (id)
);
``` 
second one : Write localhost:8182/insert to insert data on database.
``` . 
localhost:8182/books    localhost:8182/book/{id}   localhost:8182/customers   localhost:8182/customer/{id}
``` 
### 13 - Spring-Boot-13-SpringData-3-JPA-Hibernate-PostgreSQL
how to use @Embeddable, @Embedded for Spring data on Spring Boot<br/>
first one : create bottom table on any database called Users in pgAdmin 4.<br/> 
if you change database's name. you can change.
``` 
CREATE TABLE car(
    id BIGINT PRIMARY KEY     NOT NULL,
    name VARCHAR(255),
    model INTEGER,
    details VARCHAR(255)
);
``` 
second one : First write localhost:8182/insert_car to insert data on database.
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
### 14 - Spring-Boot-14-SpringData-4-Thymeleaf-JPA-PostgreSQL
how to use @OneToMany and @ManyToOne for spring boot and data in multiple table.<br/>
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
### 15 - Spring-Boot-15-SpringSecurity-(Simple)-JPA-PostgreSQL (with Static user and password)
How to use spring security and @Secured @Query with static user and password datas on spring boot and WebSecurityConfigurerAdapter.
- How will database's table be generated automatically. Look at this applicaton.properties pls. Database's table can be generated automatically, İf you write `spring.jpa.hibernate.ddl-auto=create` on application.properties on line 15. 
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

