#  Analiz ve Tasarım Dokümanı

##  Proje Tanımı

Bu proje, emlak işletmelerinin müşteri ve emlak süreçlerini yönetebileceği bir web uygulamasıdır.
Sistem; müşteri kayıtları, emlak girişleri ve arama işlemlerini merkezi bir yapı üzerinden yönetmeyi amaçlar.

---

##  Proje Amacı

* Emlak işletmelerinin dijital ortamda yönetimini sağlamak
* Müşteri ve emlak ilişkilerini düzenli şekilde tutmak
* Kullanıcıların ihtiyaçlarına göre emlak araması yapabilmesini sağlamak

---

##  Sistem Modülleri

### 1. İşletme Yönetimi

* İşletmeye ait bilgiler kaydedilir
* (İşletme adı, yetkili kişi, adres, telefon vb.)

---

### 2. Müşteri Yönetimi

* Müşteri ekleme, güncelleme ve silme işlemleri yapılır
* Müşteri tipine göre sistem davranışı değişir

Müşteri tipleri:

* ALICI (BUYER) → Arama yapan müşteri
* SATICI (SELLER / OWNER) → Emlak sahibi müşteri

---

### 3. Emlak Yönetimi

* Emlak kayıtları sisteme eklenir
* Her emlak bir müşteriye (owner) bağlıdır
* Emlak özellikleri:

    * Tür
    * Metrekare
    * Oda sayısı
    * Kat bilgisi
    * Isınma türü
    * Fiyat

---

### 4. Emlak Arama

* Kullanıcı belirli kriterlere göre arama yapabilir

* Filtreleme kriterleri:

    * Şehir / İlçe
    * Fiyat aralığı
    * Metrekare
    * Oda sayısı
    * Emlak türü
    * Isınma türü
    * Eşya durumu

* Arama işlemi dinamik olarak gerçekleştirilir

---

### 5. Yazdırma

* Arama sonucunda bulunan emlaklar için çıktı alınabilir

---

## Mimari Tasarım


* **Controller Katmanı**

    * Kullanıcıdan gelen istekleri karşılar

* **Service Katmanı**

    * İş kurallarını içerir

* **Repository Katmanı**

    * Veritabanı işlemlerini yönetir

* **Entity Katmanı**

    * Veritabanı tablolarını temsil eder

* **DTO Katmanı**

    * Veri transferi sağlar

* **Mapper Katmanı**

    * Entity ve DTO dönüşümlerini gerçekleştirir

---

## Veritabanı Tasarımı

### Tablolar

* agencies
* customers
* properties
* property_search_requests

---

## İlişkiler

### Customer → Property

* Bir müşteri birden fazla emlak sahibi olabilir
* Her emlak yalnızca bir müşteriye aittir

```text
Customer (1) ──── (N) Property
```

---

### Customer → PropertySearchRequest

* Bir müşteri birden fazla arama talebi oluşturabilir

```text
Customer (1) ──── (N) PropertySearchRequest
```

---

##  İş Kuralları

* Emlak kaydı yalnızca **SATICI** müşterilere yapılabilir
* **ALICI** müşteriler yalnızca arama işlemlerinde kullanılır
* Müşteri silinirken bağlı emlak kayıtları kontrol edilir
* Arama işlemleri filtreleme kriterlerine göre yapılır
* Sistem veri doğrulama (validation) içerir

---

##  Arama Mekanizması

Arama işlemleri Spring Data JPA Specification kullanılarak gerçekleştirilmiştir.

Dinamik filtreleme sayesinde kullanıcıdan gelen kriterlere göre sorgu oluşturulur.

---

##  Senaryo Akışı

1. İşletme kaydı oluşturulur
2. Müşteri kaydı yapılır
3. Emlak kaydı girilir
4. Yeni bir müşteri oluşturulur
5. Arama kriterleri girilir
6. Uygun emlaklar listelenir
7. Emlak bilgileri yazdırılır

---

## Sonuç

Bu sistem, emlak işletmelerinin temel ihtiyaçlarını karşılayan, katmanlı mimari ile geliştirilmiş bir web uygulamasıdır.
Sistem, genişletilebilir ve sürdürülebilir bir yapı sunmaktadır.
