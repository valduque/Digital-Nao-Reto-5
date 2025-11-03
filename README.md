# 🛒 Online Store Orders API

## 📋 Project Overview
This project is a **Spring Boot 3.0 RESTful API** for managing **orders in an online store**.  
It allows users to create, read, update, and delete orders, with full integration to a database and complete API documentation via **Swagger**.  

The project follows best practices in code structure, documentation, and testing, ensuring scalability and maintainability.

---

## ⚙️ Tech Stack
- **Java 17+**
- **Spring Boot 3.0**
- **Spring Data JPA**
- **PostgreSQL** (Production) / **H2** (Development)
- **Maven**
- **Swagger / OpenAPI**
- **JUnit** (for testing)
- **Postman** (for API validation)

---

## 🏗️ Project Structure
src/
├─ main/
│ ├─ java/com/example/orders/
│ │ ├─ controller/ → REST Controllers
│ │ ├─ dto/ → Data Transfer Objects
│ │ ├─ entity/ → JPA Entities
│ │ ├─ repository/ → Spring Data Interfaces
│ │ ├─ service/ → Business Logic
│ │ └─ config/ → Configurations (Swagger, Profiles, etc.)
│ └─ resources/
│ ├─ application-dev.yml
│ ├─ application-test.yml
│ ├─ application-prod.yml
│ └─ data.sql / schema.sql
├─ test/ → Unit & Integration Tests
├─ pom.xml
└─ README.md

yaml
Copiar código

---

## 🚀 How to Run the Project

### 1️⃣ Prerequisites
- Java 17+
- Maven 3.9+
- PostgreSQL (optional)
- Git

### 2️⃣ Clone the Repository
```bash
git clone https://github.com/<your-username>/<repo-name>.git
cd <repo-name>
3️⃣ Choose Environment Profile
You can run the project in different modes:

Profile	Description	Command
dev	Development with H2 DB	mvn spring-boot:run -Dspring-boot.run.profiles=dev
test	Testing environment	mvn spring-boot:run -Dspring-boot.run.profiles=test
prod	Production with PostgreSQL	mvn spring-boot:run -Dspring-boot.run.profiles=prod

🧠 Environment Configuration
Each profile has its own configuration file:

application-dev.yml

application-test.yml

application-prod.yml

Use system environment variables for sensitive data, e.g.:

bash
Copiar código
export DB_URL=jdbc:postgresql://localhost:5432/orders_db
export DB_USERNAME=admin
export DB_PASSWORD=securepassword
🧩 API Endpoints
Method	Endpoint	Description
POST	/api/orders	Create a new order
GET	/api/orders	Get all orders
GET	/api/orders/{id}	Get order by ID
PUT	/api/orders/{id}	Update an order
DELETE	/api/orders/{id}	Delete an order

You can test all endpoints using the Postman Collection included in the repository (postman_collection.json).

📖 API Documentation (Swagger)
Once the app is running, access Swagger UI at:
👉 http://localhost:8080/swagger-ui/index.html

🧪 Testing
Run unit and integration tests with:

bash
Copiar código
mvn test
The test suite covers:

✅ Successful API responses

⚠️ Edge cases

❌ Error and validation handling

🖥️ Startup Script
A startup script (start.sh or start.bat) is included to automate environment setup and app launch.

Usage:

bash
Copiar código
./start.sh
🧾 Documentation & Decisions
All key team decisions and technical changes are documented in the /docs folder to support learning and transparency.

🧰 Additional Features
Environment-specific configurations

Clean architecture and code readability

Peer reviews and error logging

Comprehensive documentation and testing
