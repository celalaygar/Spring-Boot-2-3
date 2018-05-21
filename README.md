### spring-boot-experiments-

##### you can change port number in all project. 
how to change : look at in application.properties ( src/main/resources/application.properties ). you can change port number in applicaton.properties
``` 
server.port=8182
``` 

#### 1 - spring-boot-HelloWorld
how to run project. Look at application.properties where Port number is there. 
``` 
Links: 
    http://localhost:3092/    http://localhost:3092/welcome
```
#### 2 - spring-boot-view-JSP-File-1
How to use and view jsp file on spring boot
``` 
Links: 
http://localhost:8182/    http://localhost:8182/personels
```
#### 3 - spring-boot-view-Error-Page
How to use and view Error page on spring boot
you can writer anylink  except bottom links. don't forget you have to add to src/main/resources/public/error 404.html (error page)  

if you write one of bottom links, you can't see error page as error.html
``` 
http://localhost:8182/    http://localhost:8182/personels
``` 
if you write one of bottom links, you can see error page as error.html
``` 
http://localhost:8182/deneme       http://localhost:8182/asd        
http://localhost:8182/asdqwe/121243dqwe?c=asldkwqe     http://localhost:8182/deneme.jsp
```

#### 4 - springboot-(REST_API_QUERY)
how to use RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE and RequestMethod.GET

you can experiment  with JUNİT on PersonelClinicRestControllerTest.java  (src/test/java/com/javaegitimleri/app/web/) 
```   
You can try runnuing the methods with run as -> Junit Test in src/test/java/com/javaegitimleri/app/web/PersonelClinicRestControllerTest.java. 
Then you can look at changing data on localhost:8182/rest/personels
``` 

#### 5 - springboot-with-h2-database (REST_API_QUERY) 
how to create schema, table and add data in table you can look src/main/resources/ data.sql & schema.sql.

how to use h2 database.

First You have to add dependencies in pom.xml if you want to use h2 database with rest_api
``` 
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jdbc</artifactId>
</dependency>
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>
``` 
Also You can try runnuing createPersonelTest, deletePersonelTest methods with run as -> Junit Test in src/test/java/com/javaegitimleri/app/web/PersonelClinicRestControllerTest.java.
 

