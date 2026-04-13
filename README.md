# 🔗 URL Shortener Service

A simple and scalable **URL Shortener Service** built using **Spring Boot**, **MySQL**, and **REST APIs**.
This application allows users to shorten long URLs, redirect using short links, and track usage analytics.

---

## 🚀 Features

* ✅ Generate unique short URLs
* 🔁 Redirect to original URL
* 📊 Track click count (basic analytics)
* ♻️ Avoid duplicate URL entries
* 🔒 Collision-safe short code generation
* 📦 RESTful API design (JSON-based)

---

## 🛠️ Tech Stack

* **Backend:** Java, Spring Boot
* **Database:** MySQL
* **ORM:** Spring Data JPA (Hibernate)
* **API Testing:** Postman

---

## 📁 Project Structure

```
url-shortener/
 ├── controller/
 ├── service/
 ├── repository/
 ├── entity/
 ├── dto/
 └── UrlShortenerApplication.java
```

---

## ⚙️ Setup Instructions

### 1️⃣ Clone Repository

```bash
git clone https://github.com/your-username/url-shortener.git
cd url-shortener
```

---

### 2️⃣ Create Database

```sql
CREATE DATABASE url_shortener;
```

---

### 3️⃣ Configure `application.properties`

```properties
server.port=8080

spring.datasource.url=jdbc:mysql://localhost:3306/url_shortener
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=create
spring.jpa.show-sql=true
```

---

### 4️⃣ Run Application

```bash
mvn spring-boot:run
```

---

## 🧪 API Endpoints

### 🔹 1. Shorten URL

**POST** `/shorten`

#### Request Body:

```json
{
  "url": "https://www.google.com"
}
```

#### Response:

```
http://localhost:8080/AbC123
```

---

### 🔹 2. Redirect to Original URL

**GET** `/{shortCode}`

* Returns HTTP **302 Redirect**
* Automatically redirects to original URL

---

### 🔹 3. Get URL Statistics

**GET** `/stats/{shortCode}`

#### Response:

```json
{
  "id": 1,
  "originalUrl": "https://www.google.com",
  "shortCode": "AbC123",
  "clickCount": 5,
  "createdAt": "2026-04-13T18:00:00"
}
```

---

## 🧠 How It Works

1. User submits a long URL
2. System generates a unique short code
3. URL is stored in database
4. Short URL is returned
5. When accessed:

   * System looks up original URL
   * Increments click count
   * Redirects user

---

## ⚠️ Notes

* `ddl-auto=create` will **drop and recreate tables on each run**
* Short code generation ensures **no collisions**
* Duplicate URLs return existing short link

---

## 🔥 Future Improvements

* 📈 Advanced analytics (IP, browser, location)
* ⏳ Expiry time for links
* ✏️ Custom short URLs
* ⚡ Redis caching
* 🌐 Frontend dashboard (React/Angular)
* 🔐 Rate limiting & security

---

## 👨‍💻 Author

Dhananjay Kadale
---

## ⭐ Contribution

Feel free to fork and contribute! Pull requests are welcome.

---

## 📜 License

This project is licensed under the MIT License.
