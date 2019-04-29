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
- RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE and RequestMethod.GET Kullanımı gösterilmiltir.
`PersonelClinicRestControllerTest.java  (src/test/java/com/javaegitimleri/app/web/)` paketindeki Test bölümünde kullanımını test edebilirsiniz.
- Eclipse üzerinde `run as -> Junit Test` ile  `rc/test/java/com/javaegitimleri/app/web/PersonelClinicRestControllerTest.java ` dosyasındaki methodları çalıştırabilir ve sonucları görebilirsiniz.. 
DDeğişen data sonuçlarını localhost:8182/rest/personels linkinden gözlemleyebilirsiniz.
### 5 - springboot-with-h2-database (REST_API_QUERY)  (jdbc with h2 database)
- h2 database jdbc ile nasıl kullanılmaktadır.<br/>
- Bu uygulamada H2 database üzerinde schema, table nasıl kurulur ve jdbc ile data nasıl eklenir bunlar gösterilmiştir. `src/main/resources/ data.sql & schema.sql` dosyalarındaki sql query leri inceleyebilirsiniz.<br/>
- Ayrıca ` src/test/java/com/javaegitimleri/app/web/PersonelClinicRestControllerTest.java` dizinindeki createPersonelTest, deletePersonelTest methodları Eclipse üzerinde ` run as -> Junit Test` ile çalıştırabilirsiniz.

