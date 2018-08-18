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
