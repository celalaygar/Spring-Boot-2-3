# Spring Boot Projects Collection

This repository contains a collection of 32 small example projects built primarily with Spring Boot, showcasing various functionalities, integrations, and best practices. Each project is designed to demonstrate a specific concept or technology, providing a clear and concise example.

---

### General Information

-   **Port Number Configuration**: To change the default port number for any Spring Boot application, you can modify the `server.port` property in the `application.properties` file located in `src/main/resources/application.properties`. For example:
    ```properties
    server.port=8182
    ```
-   **Database Schema Generation**: For projects utilizing JPA and Hibernate, you can configure automatic database table generation by setting `spring.jpa.hibernate.ddl-auto` in `application.properties`.
    -   `create`: Tables will be created from scratch every time the application starts.
    -   `update`: Existing tables will be updated, and new tables will be created if they don't exist, preserving existing data. It's recommended to use `update` for persistence after initial setup.

##### Useful References for Spring Technologies:



https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
https://www.logicbig.com/ - https://howtodoinjava.com/
https://o7planning.org/ - https://www.concretepage.com/spring-boot/
https://memorynotfound.com/ - https://www.dineshonjava.com/
---

### Project Descriptions

#### 1 - `spring-boot-HelloWorld`
-   **Description**: A foundational "Hello World" example demonstrating the absolute basics of setting up and running a Spring Boot application.
-   **Technologies**: Spring Boot.
-   **Database**: PostgreSQL (default).
-   **Links**: `http://localhost:3092/`, `http://localhost:3092/welcome`

#### 2 - `spring-boot-view-JSP-File-1`
-   **Description**: Demonstrates how to integrate and render JavaServer Pages (JSP) as view templates within a Spring Boot application.
-   **Technologies**: Spring Boot, JSP.
-   **Database**: PostgreSQL (default).
-   **Links**: `http://localhost:8182/`, `http://localhost:8182/personels`

#### 3 - `spring-boot-view-Error-Page`
-   **Description**: Shows how to implement custom error pages (e.g., 404, 403) in a Spring Boot application by placing HTML files in `src/main/resources/public/error/`.
-   **Technologies**: Spring Boot, HTML.
-   **Database**: PostgreSQL (default).
-   **Usage**: Accessing non-existent paths like `http://localhost:8182/deneme` will display the custom error page.

#### 4 - `springboot-(REST_API_QUERY)`
-   **Description**: A static REST API example demonstrating basic HTTP methods (GET, POST, PUT, DELETE) for CRUD operations. Includes JUnit tests for API interaction.
-   **Technologies**: Spring Boot, REST API, JUnit.
-   **Database**: PostgreSQL (default).
-   **Usage**: Run `PersonelClinicRestControllerTest.java` for testing. Data changes can be observed at `localhost:8182/rest/personels`.

#### 5 - `springboot-with-h2-database(REST_API_QUERY)`
-   **Description**: Demonstrates using JDBC with an in-memory H2 database. Includes examples of creating schemas, tables, and inserting data using `data.sql` and `schema.sql`.
-   **Technologies**: Spring Boot, JDBC, H2 Database, REST API.
-   **Database**: H2.
-   **Usage**: Examine `src/main/resources/data.sql` & `schema.sql`. Run `createPersonelTest`, `deletePersonelTest` in `PersonelClinicRestControllerTest.java`.

#### 6 - `springboot-jpa-with-h2-database (REST_API_QUERY)`
-   **Description**: Illustrates the integration of JPA (Java Persistence API) with an H2 in-memory database for data persistence. Focuses on core JPA annotations like `@Transactional`, `@Id`, `@GeneratedValue`, `@Entity`, `@Table`, and `@Column`.
-   **Technologies**: Spring Boot, JPA, H2 Database, REST API.
-   **Database**: H2.

#### 7 - `springboot-simple-security-example`
-   **Description**: A basic Spring Security example showcasing login, logout, custom login pages, and "remember me" functionality with static user credentials defined in `application.properties`.
-   **Technologies**: Spring Boot, Spring Security.
-   **Database**: PostgreSQL (default).
-   **Configuration**: User credentials can be changed in `application.properties`.

#### 8 - `SpringJPA-PostgreSQL-Example`
-   **Description**: Demonstrates basic CRUD (Create, Read, Update, Delete) operations using JPA with a PostgreSQL database. Includes instructions for setting up the `customer` table in pgAdmin 4.
-   **Technologies**: Spring Boot, JPA, PostgreSQL.
-   **Database**: PostgreSQL.
-   **Usage**: First, `localhost:8182/save` to insert data, then `localhost:8182/findall`, `localhost:8182/findbyid?id=3`, `localhost:8182/findbylastname?lastname=Terim`.

#### 9 - `springboot-security-with-h2-example`
-   **Description**: An example of role-based authorization using Spring Security with an H2 database. Different roles (ROLE_EDITOR, ROLE_ADMIN, ROLE_USER) have varying access levels to specific endpoints. Shows both plaintext and bcrypt-encrypted passwords.
-   **Technologies**: Spring Boot, Spring Security, H2 Database, Role-Based Authorization, Bcrypt.
-   **Database**: H2.
-   **Configuration**: User roles and passwords are defined in `src/main/resources/data.sql`. Includes a `PasswordEncoderTest.java` for generating encrypted passwords.

#### 10 - `Spring-Boot-10-JPA-PostgreSQL-CRUD-RESTful Services-And-Jsp`
-   **Description**: Combines JPA, PostgreSQL, RESTful services, and JSP for a comprehensive CRUD application. Provides both REST endpoints and JSP views for managing data.
-   **Technologies**: Spring Boot, JPA, PostgreSQL, REST API, JSP.
-   **Database**: PostgreSQL.
-   **Usage**: `localhost:8182/`, `localhost:8182/customers`, `localhost:8182/customer/1`, `localhost:8182/rest/customers`, `localhost:8182/rest/customer/1`.

#### 11 - `Spring-Boot-11-SpringData-1-JPA-PostgreSQL`
-   **Description**: Focuses on advanced JPA mappings, specifically `@OneToOne` relationships, `@JoinColumn`, and `@JsonIgnore` annotations, demonstrating data handling across multiple tables in PostgreSQL.
-   **Technologies**: Spring Boot, Spring Data JPA, PostgreSQL, `@OneToOne`, `@JoinColumn`, `@JsonIgnore`.
-   **Database**: PostgreSQL.
-   **Usage**: `localhost:8182/insert` to populate data. Then `localhost:8182/details`, `localhost:8182/customers`, `localhost:8182/customer/{id}`, `localhost:8182/customerjson/{id}`.

#### 12 - `Spring-Boot-12-SpringData-2-JPA-PostgreSQL`
-   **Description**: Explores `@ManyToOne` relationships in Spring Data JPA with PostgreSQL, along with the use of `@Query` annotation for custom SQL queries.
-   **Technologies**: Spring Boot, Spring Data JPA, PostgreSQL, `@ManyToOne`, `@Query`.
-   **Database**: PostgreSQL.
-   **Usage**: `localhost:8182/insert` to populate data. Then `localhost:8182/books`, `localhost:8182/book/{id}`, `localhost:8182/customers`, `localhost:8182/customer/{id}`.

#### 13 - `Spring-Boot-13-SpringData-3-JPA-Hibernate-PostgreSQL`
-   **Description**: Demonstrates the use of `@Embeddable` and `@Embedded` annotations in Spring Data JPA with Hibernate and PostgreSQL, for embedding complex types within entities.
-   **Technologies**: Spring Boot, Spring Data JPA, Hibernate, PostgreSQL, `@Embeddable`, `@Embedded`.
-   **Database**: PostgreSQL.
-   **Usage**: `localhost:8182/insert_car` to insert data. REST operations via Postman (`localhost:8182/car` for POST, `localhost:8182/car/{id}` for PUT/DELETE). Browser links: `localhost:8182/car1/{id}`, `localhost:8182/car2/{id}`, `localhost:8182/car_with_name/{name}`, `localhost:8182/car_with_model/{model}`.

#### 14 - `Spring-Boot-14-SpringData-4-Thymeleaf-JPA-PostgreSQL`
-   **Description**: Integrates Thymeleaf with Spring Data JPA and PostgreSQL, showcasing `@OneToMany` and `@ManyToOne` relationships in a web application.
-   **Technologies**: Spring Boot, Spring Data JPA, Thymeleaf, PostgreSQL, `@OneToMany`, `@ManyToOne`.
-   **Database**: PostgreSQL.
-   **Usage**: `localhost:8182/rest/insert` to populate data. Then `localhost:8182/customers`, `localhost:8182/rest/customers`, `localhost:8182/rest/cust`.

#### 15 - `Spring-Boot-15-SpringSecurity-(Simple)-JPA-PostgreSQL`
-   **Description**: A simple Spring Security example with JPA and PostgreSQL, demonstrating role-based access control using `@Secured` annotation and static user credentials defined in `webConfigurationClass.java`.
-   **Technologies**: Spring Boot, Spring Security, JPA, PostgreSQL, `@Secured`.
-   **Database**: PostgreSQL.
-   **User Credentials**:
    -   `admin / admin / ADMIN`
    -   `celal / celal / USER`
    -   `arda / arda / EDITOR`
-   **Access Links**:
    -   `PermitAll`: `localhost:8182/userinfo/`
    -   `ADMIN`: `localhost:8182/rest/customers/`
    -   `USER`: `localhost:8182/rest/customers/`, `localhost:8182/rest/customer-by-email/{email}/`, `localhost:8182/customer/{email}/`, `localhost:8182/rest/customerbyname/{name}`
    -   `EDITOR`: `localhost:8182/rest/cust/`, `localhost:8182/rest/customer-by-name/{name}/`

#### 16 - `Spring-Boot-16-SpringData-5-Thymeleaf-JPA-PostgreSQL`
-   **Description**: Focuses on `@ManyToMany` relationships and `@JoinTable` annotation in Spring Data JPA with Thymeleaf and PostgreSQL, demonstrating how to handle many-to-many associations between entities.
-   **Technologies**: Spring Boot, Spring Data JPA, Thymeleaf, PostgreSQL, `@ManyToMany`, `@JoinTable`.
-   **Database**: PostgreSQL.

#### 17 - `Spring-Boot-17-SpringSecurity-Jpa-PostgreSQL`
-   **Description**: A comprehensive example of user registration and login functionality using Spring Security with JPA and PostgreSQL. Includes a video demonstration.
-   **Technologies**: Spring Boot, Spring Security, JPA, Hibernate, PostgreSQL, Thymeleaf, Bootstrap.
-   **Database**: PostgreSQL.
-   **Video**: [![Watch the video](https://img.youtube.com/vi/VAG2s3j5L3E/hqdefault.jpg)](https://www.youtube.com/watch?v=VAG2s3j5L3E&feature=youtu.be)

#### 18 - `Spring-Boot-18-Mongodb`
-   **Description**: Demonstrates how to integrate and use MongoDB as the NoSQL database for a Spring Boot application. Covers basic CRUD operations with MongoDB.
-   **Technologies**: Spring Boot, MongoDB.
-   **Database**: MongoDB.

#### 19 - `Spring-Boot-19-RabbitMQ`
-   **Description**: An example showcasing message queuing with RabbitMQ in a Spring Boot application. Demonstrates producer and consumer patterns for asynchronous communication.
-   **Technologies**: Spring Boot, RabbitMQ.
-   **Database**: PostgreSQL (default).

#### 20 - `Spring-Boot-20-React-JWT-without-Redux`
-   **Description**: A full-stack application demonstrating JWT (JSON Web Token) based authentication with a Spring Boot backend and a React.js frontend, without using Redux for state management.
-   **Technologies**: Spring Boot, React.js, JWT, REST API.
-   **Database**: PostgreSQL (default).

#### 21 - `Spring-Boot-21-React-JWT-with-Redux`
-   **Description**: A full-stack application similar to project 20, but integrating Redux for centralized state management in the React.js frontend, along with JWT authentication and a Spring Boot backend.
-   **Technologies**: Spring Boot, React.js, Redux, JWT, REST API.
-   **Database**: PostgreSQL (default).

#### 22 - `Spring-Boot-22-Role-Based-JWT`
-   **Description**: Extends JWT authentication to implement role-based access control. Demonstrates how to issue and validate JWTs with user roles, and secure endpoints based on those roles.
-   **Technologies**: Spring Boot, JWT, Role-Based Security, REST API.
-   **Database**: PostgreSQL (default).

#### 23 - `Spring-Boot-23-Base-Model-Inheritance`
-   **Description**: Illustrates the concept of base model inheritance in JPA with PostgreSQL, specifically using `@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)` to manage common fields across multiple entities.
-   **Technologies**: Spring Boot, JPA, PostgreSQL, Inheritance.
-   **Database**: PostgreSQL.
-   **Reference**: See `Transaction.java` for an example of the inheritance strategy.

#### 24 - `Spring-Boot-24-Unit-Test`
-   **Description**: Provides examples of writing unit tests for Spring Boot applications, covering various components like services, repositories, and controllers, using JUnit and Mockito.
-   **Technologies**: Spring Boot, JUnit, Mockito.
-   **Database**: PostgreSQL (default).

#### 25 - `Spring-Boot-25-Elastic-Search`
-   **Description**: Demonstrates integration of Elastic Search with a Spring Boot application for powerful full-text search and analytical capabilities.
-   **Technologies**: Spring Boot, Elastic Search.
-   **Database**: PostgreSQL (default, for primary data if any).

#### 26 - `Spring-Boot-26-Kafka-Producer-Consuöer-Scheduled`
-   **Description**: Showcases the implementation of Kafka producers and consumers in Spring Boot for real-time data streaming, along with scheduled tasks for automated operations.
-   **Technologies**: Spring Boot, Apache Kafka, Scheduled Tasks.
-   **Database**: PostgreSQL (default).

#### 27 - `Spring-Boot-27-PostgreSQL-Trigger-Java-Listener`
-   **Description**: Explores advanced PostgreSQL features by demonstrating how to create and use database triggers, and how to listen for these trigger events from a Java Spring Boot application.
-   **Technologies**: Spring Boot, PostgreSQL, Database Triggers, Java Listeners.
-   **Database**: PostgreSQL.

#### 28 - `Spring-Boot-28-ReactJS-WebSocket`
-   **Description**: A real-time communication example using WebSockets with a Spring Boot backend and a React.js frontend. Ideal for chat applications or live data updates.
-   **Technologies**: Spring Boot, React.js, WebSockets.
-   **Database**: PostgreSQL (default).

#### 29 - `Spring-Boot-29-Logging`
-   **Description**: Focuses on configuring and utilizing logging frameworks (e.g., Logback, Log4j2) in a Spring Boot application, demonstrating different log levels and output destinations.
-   **Technologies**: Spring Boot, Logging (Logback/Log4j2).
-   **Database**: PostgreSQL (default).

#### 30 - `Spring-Boot-30-BaseRequest-BaseEntity-BaseResponse`
-   **Description**: Implements common architectural patterns using base classes for requests, entities, and responses to promote code reusability and maintainability in a Spring Boot application.
-   **Technologies**: Spring Boot, Design Patterns.
-   **Database**: PostgreSQL (default).

#### 31 - `Spring-Boot-31-WebFlux-Security-MongoDB-RateLimit-Configuration`
-   **Description**: A reactive Spring Boot application using WebFlux, incorporating Spring Security for authentication/authorization, MongoDB for data storage, and implementing rate limiting for API protection.
-   **Technologies**: Spring Boot WebFlux, Spring Security, MongoDB, Rate Limiting.
-   **Database**: MongoDB.

#### 32 - `Spring-Boot-32-Security-WebFlux-Logging-RateLimit-MongoDB`
-   **Description**: A comprehensive reactive application built with Spring Boot WebFlux, featuring Spring Security, robust logging, API rate limiting, and MongoDB persistence.
-   **Technologies**: Spring Boot WebFlux, Spring Security, Logging, Rate Limiting, MongoDB.
-   **Database**: MongoDB.


