### Spring-Boot-2
- Port numarası nasıl değiştirilir? Port numarasını değiştirmek isterseniz proje içerisindeki `src/main/resources/application.properties` 
dizininde bulunan `application.properties` dosyasının içerisine giripi örnek olarak `server.port=3132` yazarak değiştirebbilirsiniz.
``` 
``` 
- Otomatik olarak bazı projelerde kullanılan veri tabanı tablolarının oluşmasını isterseniz eğer tekrar applicaton.properties dosyası 
içerisinde `spring.jpa.hibernate.ddl-auto=create` create değerini vererek veritabanını oluşturabilirsiniz.
Daha sonra bu veritabanı kalıcı olarak kalmasını isterseniz proje çalışır haldeyken veya durdurup `create` değerinin yerine `update` yazarak 
düzeltebilirsiniz. Eğer değeri `create` olarak bırakırsınız projeyi her çalıştırdığınızda veritabanı tabloları sıfırdan tekrar oluşturulacaktır.
##### spring teknelojilerini kullanırken yararlanılabileceğiniz referans sayfalar 
```
- https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
- https://www.logicbig.com/                           - https://howtodoinjava.com/
- https://o7planning.org/                             - https://www.concretepage.com/spring-boot/
- https://memorynotfound.com/                         - https://www.dineshonjava.com/
``` 
### 1 - spring-boot-HelloWorld
Bu proje çalıştırıldıktan sonra hangi linkte browserde görünür. <br/>
Ayrıca `application.properties` dosyasında belirlenmiş olan port numarasına dikkat ediniz.
``` 
Links: 
    http://localhost:3092/    http://localhost:3092/welcome
```
### 2 - spring-boot-view-JSP-File-1
Spring boot projesinde jsp file nasıl kullanılır ve nasıl sonuclar elde edilebilir.
``` 
Links: 
http://localhost:8182/    http://localhost:8182/personels
```
### 3 - spring-boot-view-Error-Page
Error sayfası nasıl kullanılabilir.`src/main/resources/public/error/(ErrorPage.html)` dizinine Error sayfası eklemek zorundasınız. 
Örnek olarak  ` 404.html veya 403.html` 
Altta verilen linkleri yazarsanız eğer Error sayfalarını göremezsiniz.
``` 
http://localhost:8182/    http://localhost:8182/personels
``` 
Üst tarafta belirtilen linkler dışında örnek olarak altta verilen linkleri yazarsanız eğer Error sayfalarını görebilirsiniz.
``` 
http://localhost:8182/deneme                           http://localhost:8182/asd        
http://localhost:8182/asdqwe/121243dqwe?c=asldkwqe     http://localhost:8182/deneme.jsp
```
### 4 - springboot-(REST_API_QUERY) 
###### (Static)
- RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE and RequestMethod.GET kullanımı gösterilmiltir.
`PersonelClinicRestControllerTest.java  (src/test/java/com/javaegitimleri/app/web/)` paketindeki Test bölümünde kullanımını test edebilirsiniz.
- Eclipse üzerinde `run as -> Junit Test` ile  `rc/test/java/com/javaegitimleri/app/web/PersonelClinicRestControllerTest.java ` dosyasındaki methodları çalıştırabilir ve sonuçları görebilirsiniz. Değişen data sonuçlarını localhost:8182/rest/personels linkinden gözlemleyebilirsiniz.
### 5 - springboot-with-h2-database (REST_API_QUERY)  (jdbc with h2 database)
- h2 database jdbc ile nasıl kullanılmaktadır.<br/>
- Bu uygulamada H2 database üzerinde schema, table nasıl kurulur ve jdbc ile data nasıl eklenir bunlar gösterilmiştir. `src/main/resources/ data.sql & schema.sql` dosyalarındaki sql query leri inceleyebilirsiniz.<br/>
- Ayrıca ` src/test/java/com/javaegitimleri/app/web/PersonelClinicRestControllerTest.java` dizinindeki createPersonelTest, deletePersonelTest methodları Eclipse üzerinde ` run as -> Junit Test` ile çalıştırabilirsiniz.

### 6 - springboot-jpa-with-h2-database (REST_API_QUERY)
H2 database ile JPA nasıl kullanılır bu gösterilmiştir.<br/>
@Transactional, @Id, @GeneratedValue, @Entity, @Table @Column annotasyonları nasıl kullanılır.

### 7 - springboot-simple-security-example
- Login and logout prosedürleri nasıl kullanılır. nasıl kullanıldığı gösterilmiştir.
- Specific login page ve beni hatırla yönteminin kullanımı gösterilmiştir.
- ilk olarak spring-boot-starter-security dependency pom.xml içerisine eklemek zorundasınız. 
- Statik user name ve password belirleme işlemleri için `src/main/resources/...` dizinndeki `application.properties` dosyasına bakabilirsiniz. 
``` 
biz örnek olarak bu user name ve password ü belirledik.
spring.security.user.name=celal
spring.security.user.password=123456
```
### 8 - SpringJPA-PostgreSQL-Example
Bu örnek uygulamada Postgresql ve buna bağlı olarak pgAdmin 4 kullanılmıştır. 
- İlk adım olarak pdAdmin 4 açınız  Veri tabanı isni olarak Personels adında bir veri tabanı oluşturmalısınız isterseniz application properties dosyasında ismi değiştirip ona göre yaptığınız değişikliklere göre veri tabanı ismi kullanabilirsiniz. 
- daha sonra  SQL Editor kullanınız ve customer table  oluşturmak için alttaki sql query i kullanabilirsiniz.
``` 
CREATE TABLE customer(
    id BIGINT PRIMARY KEY     NOT NULL,
    firstname VARCHAR(20),
    lastname VARCHAR(20)
);
``` 
ilk olarak veritabanına kayıt işlemleri yapmak için browser üzerinde localhost:8182/save yazmanız gerekmektedir. 
Daha sonra  örnek olarak alttaki linkleri deneyebilirsiniz.
``` 
localhost:8182/findall
localhost:8182/findbyid?id=3  
localhost:8182/findbylastname?lastname=Terim
``` 
