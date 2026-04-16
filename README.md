# TicketHub - Scalable Event Booking API 🎟️

TicketHub is a backend system designed to manage high-traffic event seat reservations. It focuses on data integrity, concurrency control, and clean architecture, showcasing modern software engineering patterns.

## 🛠️ Technical Stack
* **Runtime:** Java 26 (Utilizing Records, Pattern Matching, and Sealed Classes)
* **Framework:** Spring Boot 4.0.5
* **Database:** PostgreSQL (Relational integrity & ACID transactions)
* **Messaging:** RabbitMQ (Asynchronous processing & Event-driven workflows)
* **Infrastructure:** Docker & Docker Compose
* **Documentation:** SpringDoc OpenAPI (Swagger UI)
* **Mapping:** MapStruct

## 🏗️ Architecture & Patterns Applied
* **CQRS (Command Query Responsibility Segregation):** Dedicated paths for write operations (Commands) and read operations (Queries) to optimize performance and scalability.
* **Domain-Driven Design (DDD):** Rich Domain Model with Protected Aggregate Roots. Business logic is encapsulated within the domain layer to prevent anemic models.
* **Concurrency Control:** Implementation of database-level constraints and transactional locks to prevent double-booking issues.
* **Clean Architecture:** Strict separation of concerns across `api`, `application`, `domain`, and `infrastructure` layers.

## 📋 Key Features & Roadmap
- [x] **Core Domain:** Booking lifecycle management (PENDING, CONFIRMED, EXPIRED).
- [x] **Data Integrity:** Database-level unique constraints for Event + Seat pairs.
- [ ] **Asynchronous Expiration:** Using RabbitMQ TTL (Time-To-Live) to automatically release unpaid seats.
- [ ] **Query Side:** Specialized read models for real-time seat availability maps.

## 🔧 Getting Started
1. **Clone the repository:**
   ```
   git clone [https://github.com/bernardomcb/tickethub.git](https://github.com/bernardomcb/tickethub.git)
   ```

2. **Launch Infrastructure:**
    ```
    docker-compose up -d
    ```
3. **Run Application:**
    ```
    ./mvnw spring-boot:run
    ```

4. **API Docs:**
    Explore endpoints via Swagger UI: http://localhost:8080/swagger-ui.html


## 👨‍💻 Author

**Bernardo Guilherme Madruga Mecabô**

* [LinkedIn](https://www.linkedin.com/in/bernardomecabo/)
* [GitHub](https://github.com/bernardommecabo)