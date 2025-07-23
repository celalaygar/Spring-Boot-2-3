# Spring Boot Projeleri Koleksiyonu

Bu depo, Spring Boot ile oluşturulmuş 32 küçük örnek projeden oluşan bir koleksiyonu içermektedir. Her proje, belirli bir konsepti veya teknolojiyi göstermek, açık ve özlü bir örnek sunmak üzere tasarlanmıştır.

---

### Genel Bilgiler

-   **Port Numarası Yapılandırması**: Herhangi bir Spring Boot uygulamasının varsayılan port numarasını değiştirmek için, `src/main/resources/application.properties` dosyasında bulunan `server.port` özelliğini düzenleyebilirsiniz. Örneğin:
    ```properties
    server.port=8182
    ```
-   **Veritabanı Şeması Oluşturma**: JPA ve Hibernate kullanan projeler için, `application.properties` dosyasında `spring.jpa.hibernate.ddl-auto` ayarını yaparak otomatik veritabanı tablo oluşturmayı yapılandırabilirsiniz.
    -   `create`: Uygulama her başladığında tablolar sıfırdan oluşturulacaktır.
    -   `update`: Mevcut tablolar güncellenecek ve yeni tablolar yoksa oluşturulacak, mevcut veriler korunacaktır. İlk kurulumdan sonra kalıcılık için `update` kullanılması önerilir.

##### Spring Teknolojileri İçin Yararlı Referanslar:
```
https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
https://www.logicbig.com/ 
https://howtodoinjava.com/
https://o7planning.org/
https://www.concretepage.com/spring-boot/
https://memorynotfound.com/
https://www.dineshonjava.com/
```
### Proje Açıklamaları

#### 1 - `spring-boot-HelloWorld`
-   **Açıklama**: Bir Spring Boot uygulamasını kurmanın ve çalıştırmanın temel adımlarını gösteren "Merhaba Dünya" örneği.
-   **Teknolojiler**: Spring Boot.
-   **Veritabanı**: PostgreSQL (varsayılan).
-   **Linkler**: `http://localhost:3092/`, `http://localhost:3092/welcome`

#### 2 - `spring-boot-view-JSP-File-1`
-   **Açıklama**: Bir Spring Boot uygulamasında JavaServer Pages (JSP) dosyalarını görünüm şablonları olarak nasıl entegre edeceğinizi ve render edeceğinizi gösterir.
-   **Teknolojiler**: Spring Boot, JSP.
-   **Veritabanı**: PostgreSQL (varsayılan).
-   **Linkler**: `http://localhost:8182/`, `http://localhost:8182/personels`

#### 3 - `spring-boot-view-Error-Page`
-   **Açıklama**: `src/main/resources/public/error/` dizinine HTML dosyaları yerleştirerek Spring Boot uygulamasında özel hata sayfalarını (örneğin, 404, 403) nasıl uygulayacağınızı gösterir.
-   **Teknolojiler**: Spring Boot, HTML.
-   **Veritabanı**: PostgreSQL (varsayılan).
-   **Kullanım**: `http://localhost:8182/deneme` gibi var olmayan yollara erişim, özel hata sayfasını gösterecektir.

#### 4 - `springboot-(REST_API_QUERY)`
-   **Açıklama**: CRUD işlemleri için temel HTTP metotlarını (GET, POST, PUT, DELETE) gösteren statik bir REST API örneği. API etkileşimi için JUnit testleri içerir.
-   **Teknolojiler**: Spring Boot, REST API, JUnit.
-   **Veritabanı**: PostgreSQL (varsayılan).
-   **Kullanım**: Test için `PersonelClinicRestControllerTest.java`'yı çalıştırın. Veri değişiklikleri `localhost:8182/rest/personels` adresinden gözlemlenebilir.

#### 5 - `springboot-with-h2-database(REST_API_QUERY)`
-   **Açıklama**: Bellek içi H2 veritabanı ile JDBC kullanımını gösterir. `data.sql` ve `schema.sql` kullanarak şemaları, tabloları oluşturma ve veri ekleme örneklerini içerir.
-   **Teknolojiler**: Spring Boot, JDBC, H2 Veritabanı, REST API.
-   **Veritabanı**: H2.
-   **Kullanım**: `src/main/resources/data.sql` ve `schema.sql`'ı inceleyin. `PersonelClinicRestControllerTest.java`'daki `createPersonelTest`, `deletePersonelTest`'i çalıştırın.

#### 6 - `springboot-jpa-with-h2-database (REST_API_QUERY)`
-   **Açıklama**: Veri kalıcılığı için JPA (Java Persistence API) ile H2 bellek içi veritabanının entegrasyonunu gösterir. `@Transactional`, `@Id`, `@GeneratedValue`, `@Entity`, `@Table` ve `@Column` gibi temel JPA anotasyonlarına odaklanır.
-   **Teknolojiler**: Spring Boot, JPA, H2 Veritabanı, REST API.
-   **Veritabanı**: H2.

#### 7 - `springboot-simple-security-example`
-   **Açıklama**: `application.properties` dosyasında tanımlanan statik kullanıcı kimlik bilgileriyle giriş, çıkış, özel giriş sayfaları ve "beni hatırla" işlevselliğini sergileyen basit bir Spring Security örneği.
-   **Teknolojiler**: Spring Boot, Spring Security.
-   **Veritabanı**: PostgreSQL (varsayılan).
-   **Yapılandırma**: Kullanıcı kimlik bilgileri `application.properties` dosyasında değiştirilebilir.

#### 8 - `SpringJPA-PostgreSQL-Example`
-   **Açıklama**: PostgreSQL veritabanı ile JPA kullanarak temel CRUD (Oluştur, Oku, Güncelle, Sil) işlemlerini gösterir. pgAdmin 4'te `customer` tablosunu kurma talimatlarını içerir.
-   **Teknolojiler**: Spring Boot, JPA, PostgreSQL.
-   **Veritabanı**: PostgreSQL.
-   **Kullanım**: Önce veri eklemek için `localhost:8182/save`, ardından `localhost:8182/findall`, `localhost:8182/findbyid?id=3`, `localhost:8182/findbylastname?lastname=Terim`.

#### 9 - `springboot-security-with-h2-example`
-   **Açıklama**: H2 veritabanı ile Spring Security kullanarak rol tabanlı yetkilendirme örneği. Farklı roller (ROLE_EDITOR, ROLE_ADMIN, ROLE_USER) belirli uç noktalara farklı erişim seviyelerine sahiptir. Hem düz metin hem de bcrypt şifreli parolaları gösterir.
-   **Teknolojiler**: Spring Boot, Spring Security, H2 Veritabanı, Rol Tabanlı Yetkilendirme, Bcrypt.
-   **Veritabanı**: H2.
-   **Yapılandırma**: Kullanıcı rolleri ve parolaları `src/main/resources/data.sql`'da tanımlanmıştır. Şifreli parolalar oluşturmak için `PasswordEncoderTest.java` içerir.

#### 10 - `Spring-Boot-10-JPA-PostgreSQL-CRUD-RESTful Services-And-Jsp`
-   **Açıklama**: Kapsamlı bir CRUD uygulaması için JPA, PostgreSQL, RESTful hizmetler ve JSP'yi birleştirir. Veri yönetimi için hem REST uç noktaları hem de JSP görünümleri sunar.
-   **Teknolojiler**: Spring Boot, JPA, PostgreSQL, REST API, JSP.
-   **Veritabanı**: PostgreSQL.
-   **Kullanım**: `localhost:8182/`, `localhost:8182/customers`, `localhost:8182/customer/1`, `localhost:8182/rest/customers`, `localhost:8182/rest/customer/1`.

#### 11 - `Spring-Boot-11-SpringData-1-JPA-PostgreSQL`
-   **Açıklama**: İleri düzey JPA eşlemelerine, özellikle `@OneToOne` ilişkilerine, `@JoinColumn` ve `@JsonIgnore` anotasyonlarına odaklanarak PostgreSQL'de birden çok tablo arasında veri işlemeyi gösterir.
-   **Teknolojiler**: Spring Boot, Spring Data JPA, PostgreSQL, `@OneToOne`, `@JoinColumn`, `@JsonIgnore`.
-   **Veritabanı**: PostgreSQL.
-   **Kullanım**: Veri eklemek için `localhost:8182/insert`. Ardından `localhost:8182/details`, `localhost:8182/customers`, `localhost:8182/customer/{id}`, `localhost:8182/customerjson/{id}`.

#### 12 - `Spring-Boot-12-SpringData-2-JPA-PostgreSQL`
-   **Açıklama**: PostgreSQL ile Spring Data JPA'daki `@ManyToOne` ilişkilerini ve özel SQL sorguları için `@Query` anotasyonunun kullanımını inceler.
-   **Teknolojiler**: Spring Boot, Spring Data JPA, PostgreSQL, `@ManyToOne`, `@Query`.
-   **Veritabanı**: PostgreSQL.
-   **Kullanım**: Veri eklemek için `localhost:8182/insert`. Ardından `localhost:8182/books`, `localhost:8182/book/{id}`, `localhost:8182/customers`, `localhost:8182/customer/{id}`.

#### 13 - `Spring-Boot-13-SpringData-3-JPA-Hibernate-PostgreSQL`
-   **Açıklama**: Hibernate ve PostgreSQL ile Spring Data JPA'da `@Embeddable` ve `@Embedded` anotasyonlarının kullanımını, karmaşık tipleri varlıklar içine gömmeyi gösterir.
-   **Teknolojiler**: Spring Boot, Spring Data JPA, Hibernate, PostgreSQL, `@Embeddable`, `@Embedded`.
-   **Veritabanı**: PostgreSQL.
-   **Kullanım**: Veri eklemek için `localhost:8182/insert_car`. Postman aracılığıyla REST işlemleri (POST için `localhost:8182/car`, PUT/DELETE için `localhost:8182/car/{id}`). Tarayıcı linkleri: `localhost:8182/car1/{id}`, `localhost:8182/car2/{id}`, `localhost:8182/car_with_name/{name}`, `localhost:8182/car_with_model/{model}`.

#### 14 - `Spring-Boot-14-SpringData-4-Thymeleaf-JPA-PostgreSQL`
-   **Açıklama**: Thymeleaf'i Spring Data JPA ve PostgreSQL ile entegre ederek bir web uygulamasında `@OneToMany` ve `@ManyToOne` ilişkilerini sergiler.
-   **Teknolojiler**: Spring Boot, Spring Data JPA, Thymeleaf, PostgreSQL, `@OneToMany`, `@ManyToOne`.
-   **Veritabanı**: PostgreSQL.
-   **Kullanım**: Veri eklemek için `localhost:8182/rest/insert`. Ardından `localhost:8182/customers`, `localhost:8182/rest/customers`, `localhost:8182/rest/cust`.

#### 15 - `Spring-Boot-15-SpringSecurity-(Simple)-JPA-PostgreSQL`
-   **Açıklama**: `webConfigurationClass.java`'da tanımlanan `@Secured` anotasyonu ve statik kullanıcı kimlik bilgileriyle rol tabanlı erişim kontrolünü gösteren, JPA ve PostgreSQL ile basit bir Spring Security örneği.
-   **Teknolojiler**: Spring Boot, Spring Security, JPA, PostgreSQL, `@Secured`.
-   **Veritabanı**: PostgreSQL.
-   **Kullanıcı Kimlik Bilgileri**:
    -   `admin / admin / ADMIN`
    -   `celal / celal / USER`
    -   `arda / arda / EDITOR`
-   **Erişim Linkleri**:
    -   `Herkese Açık`: `localhost:8182/userinfo/`
    -   `ADMIN`: `localhost:8182/rest/customers/`
    -   `USER`: `localhost:8182/rest/customers/`, `localhost:8182/rest/customer-by-email/{email}/`, `localhost:8182/customer/{email}/`, `localhost:8182/rest/customerbyname/{name}`
    -   `EDITOR`: `localhost:8182/rest/cust/`, `localhost:8182/rest/customer-by-name/{name}/`

#### 16 - `Spring-Boot-16-SpringData-5-Thymeleaf-JPA-PostgreSQL`
-   **Açıklama**: Spring Data JPA'da Thymeleaf ve PostgreSQL ile `@ManyToMany` ilişkilerine ve `@JoinTable` anotasyonuna odaklanarak varlıklar arasındaki çoktan çoğa ilişkilerin nasıl ele alınacağını gösterir.
-   **Teknolojiler**: Spring Boot, Spring Data JPA, Thymeleaf, PostgreSQL, `@ManyToMany`, `@JoinTable`.
-   **Veritabanı**: PostgreSQL.

#### 17 - `Spring-Boot-17-SpringSecurity-Jpa-PostgreSQL`
-   **Açıklama**: Spring Security ile JPA ve PostgreSQL kullanarak kullanıcı kaydı ve giriş işlevselliğinin kapsamlı bir örneği. Bir video gösterimi içerir.
-   **Teknolojiler**: Spring Boot, Spring Security, JPA, Hibernate, PostgreSQL, Thymeleaf, Bootstrap.
-   **Veritabanı**: PostgreSQL.
-   **Video**: [![Videoyu İzle](https://img.youtube.com/vi/VAG2s3j5L3E/hqdefault.jpg)](https://www.youtube.com/watch?v=VAG2s3j5L3E&feature=youtu.be)

#### 18 - `Spring-Boot-18-Mongodb`
-   **Açıklama**: Bir Spring Boot uygulaması için NoSQL veritabanı olarak MongoDB'yi nasıl entegre edeceğinizi ve kullanacağınızı gösterir. MongoDB ile temel CRUD işlemlerini kapsar.
-   **Teknolojiler**: Spring Boot, MongoDB.
-   **Veritabanı**: MongoDB.

#### 19 - `Spring-Boot-19-RabbitMQ`
-   **Açıklama**: Bir Spring Boot uygulamasında RabbitMQ ile mesaj kuyruklama örneği. Asenkron iletişim için üretici ve tüketici desenlerini gösterir.
-   **Teknolojiler**: Spring Boot, RabbitMQ.
-   **Veritabanı**: PostgreSQL (varsayılan).

#### 20 - `Spring-Boot-20-React-JWT-without-Redux`
-   **Açıklama**: Spring Boot arka ucu ve React.js ön ucu ile JWT (JSON Web Token) tabanlı kimlik doğrulamayı Redux kullanmadan gösteren tam yığın bir uygulama.
-   **Teknolojiler**: Spring Boot, React.js, JWT, REST API.
-   **Veritabanı**: PostgreSQL (varsayılan).

#### 21 - `Spring-Boot-21-React-JWT-with-Redux`
-   **Açıklama**: 20. projeye benzer, ancak React.js ön ucunda merkezi durum yönetimi için Redux'u entegre eden, JWT kimlik doğrulaması ve Spring Boot arka ucu ile tam yığın bir uygulama.
-   **Teknolojiler**: Spring Boot, React.js, Redux, JWT, REST API.
-   **Veritabanı**: PostgreSQL (varsayılan).

#### 22 - `Spring-Boot-22-Role-Based-JWT`
-   **Açıklama**: JWT kimlik doğrulamasını rol tabanlı erişim kontrolünü uygulamak için genişletir. Kullanıcı rolleriyle JWT'leri nasıl yayınlayacağınızı ve doğrulayacağınızı ve bu rollere göre uç noktaları nasıl güvence altına alacağınızı gösterir.
-   **Teknolojiler**: Spring Boot, JWT, Rol Tabanlı Güvenlik, REST API.
-   **Veritabanı**: PostgreSQL (varsayılan).

#### 23 - `Spring-Boot-23-Base-Model-Inheritance`
-   **Açıklama**: JPA ile PostgreSQL'de temel model kalıtım konseptini, özellikle birden çok varlıkta ortak alanları yönetmek için `@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)` kullanımını gösterir.
-   **Teknolojiler**: Spring Boot, JPA, PostgreSQL, Kalıtım.
-   **Veritabanı**: PostgreSQL.
-   **Referans**: Kalıtım stratejisi örneği için `Transaction.java`'ya bakın.

#### 24 - `Spring-Boot-24-Unit-Test`
-   **Açıklama**: JUnit ve Mockito kullanarak hizmetler, depolar ve denetleyiciler gibi çeşitli bileşenleri kapsayan Spring Boot uygulamaları için birim testleri yazma örneklerini sunar.
-   **Teknolojiler**: Spring Boot, JUnit, Mockito.
-   **Veritabanı**: PostgreSQL (varsayılan).

#### 25 - `Spring-Boot-25-Elastic-Search`
-   **Açıklama**: Güçlü tam metin arama ve analitik yetenekler için Elastic Search'ün bir Spring Boot uygulamasıyla entegrasyonunu gösterir.
-   **Teknolojiler**: Spring Boot, Elastic Search.
-   **Veritabanı**: PostgreSQL (varsayılan, birincil veriler için).

#### 26 - `Spring-Boot-26-Kafka-Producer-Consuöer-Scheduled`
-   **Açıklama**: Gerçek zamanlı veri akışı için Spring Boot'ta Kafka üreticileri ve tüketicilerinin uygulanmasını, ayrıca otomatik işlemler için zamanlanmış görevleri sergiler.
-   **Teknolojiler**: Spring Boot, Apache Kafka, Zamanlanmış Görevler.
-   **Veritabanı**: PostgreSQL (varsayılan).

#### 27 - `Spring-Boot-27-PostgreSQL-Trigger-Java-Listener`
-   **Açıklama**: Veritabanı tetikleyicilerini nasıl oluşturacağınızı ve kullanacağınızı ve bu tetikleyici olaylarını bir Java Spring Boot uygulamasından nasıl dinleyeceğinizi göstererek gelişmiş PostgreSQL özelliklerini keşfeder.
-   **Teknolojiler**: Spring Boot, PostgreSQL, Veritabanı Tetikleyicileri, Java Dinleyicileri.
-   **Veritabanı**: PostgreSQL.

#### 28 - `Spring-Boot-28-ReactJS-WebSocket`
-   **Açıklama**: Spring Boot arka ucu ve React.js ön ucu ile WebSockets kullanarak gerçek zamanlı iletişim örneği. Sohbet uygulamaları veya canlı veri güncellemeleri için idealdir.
-   **Teknolojiler**: Spring Boot, React.js, WebSockets.
-   **Veritabanı**: PostgreSQL (varsayılan).

#### 29 - `Spring-Boot-29-Logging`
-   **Açıklama**: Bir Spring Boot uygulamasında farklı günlük seviyelerini ve çıktı hedeflerini göstererek günlükleme çerçevelerini (örneğin, Logback, Log4j2) yapılandırmaya ve kullanmaya odaklanır.
-   **Teknolojiler**: Spring Boot, Günlükleme (Logback/Log4j2).
-   **Veritabanı**: PostgreSQL (varsayılan).

#### 30 - `Spring-Boot-30-BaseRequest-BaseEntity-BaseResponse`
-   **Açıklama**: Bir Spring Boot uygulamasında kodun yeniden kullanılabilirliğini ve sürdürülebilirliğini teşvik etmek için istekler, varlıklar ve yanıtlar için temel sınıflar kullanarak ortak mimari desenleri uygular.
-   **Teknolojiler**: Spring Boot, Tasarım Desenleri.
-   **Veritabanı**: PostgreSQL (varsayılan).

#### 31 - `Spring-Boot-31-WebFlux-Security-MongoDB-RateLimit-Configuration`
-   **Açıklama**: WebFlux kullanan reaktif bir Spring Boot uygulaması, kimlik doğrulama/yetkilendirme için Spring Security'yi, veri depolama için MongoDB'yi içerir ve API koruması için hız sınırlaması uygular, Her request ve response (body, headers ve tüm parametreleriyle beraber) mongodb ye loglanır.
-   **Teknolojiler**: Spring Boot WebFlux, Spring Security, MongoDB, Hız Sınırlama.
-   **Veritabanı**: MongoDB.

#### 32 - `Spring-Boot-32-Security-WebFlux-Logging-RateLimit-MongoDB`
-   **Açıklama**: Spring Boot WebFlux ile oluşturulmuş kapsamlı bir reaktif uygulama, Spring Security, sağlam günlükleme, API hız sınırlaması ve MongoDB kalıcılığı özelliklerine sahiptir.
-   **Teknolojiler**: Spring Boot WebFlux, Spring Security, Günlükleme, Hız Sınırlama, MongoDB.
-   **Veritabanı**: MongoDB.
