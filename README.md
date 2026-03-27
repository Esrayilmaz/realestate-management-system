# Emlak Yönetim Sistemi (Real Estate Management System)
Bu proje, Java Spring Boot kullanılarak geliştirilmiş bir 
Emlak İşletmesi Yönetim Sistemidir.
Amaç; emlak firmalarının müşteri, 
emlak ve arama süreçlerini yönetebileceği 
modern ve katmanlı mimariye sahip bir 
web uygulaması sunmaktır.

## Özellikler
İşletme Yönetimi
Müşteri Yönetimi (CRUD)
Emlak Yönetimi (CRUD)
Emlak Arama (filtreleme)
Yazdırılabilir emlak detayları
Dashboard ekranı

## Kullanılan Teknolojiler

- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Thymeleaf
- Bootstrap 5

## Proje Mimarisi

Controller → HTTP isteklerini karşılar
Service → İş kurallarını içerir
Repository → Veritabanı işlemlerini yönetir
Entity → Veritabanı modelleri
DTO → Veri transfer objeleri
Mapper → Entity ↔ DTO dönüşümleri
Exception → Hata yönetimi

## Ekranlar

- Dashboard
- Customers
- Properties
- Agency
- Property Search
- Property Print

## Senaryo Akışı

1. Emlak işletmesi kaydedilir
2. Bir müşteri oluşturulur
3. Bu müşteriye ait emlak kaydı girilir
4. İkinci bir müşteri oluşturulur
5. Arama kriterleri girilerek emlak araması yapılır
6. Uygun emlaklar listelenir
7. Emlak detayları yazdırılabilir

## Kurulum ve Çalıştırma

1. Veritabanı oluşturma

   CREATE DATABASE realestate_db;

2. application.properties ayarı

   spring.datasource.url=jdbc:postgresql://localhost:5432/realestate_db
   spring.datasource.username=postgres
   spring.datasource.password=1234
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

3. Uygulamayı Çalıştırma

RealestateApplication.java

##  Detaylı Dokümantasyon
docs/analiz-tasarim.md


