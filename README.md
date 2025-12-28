# Utility Payment Processing Platform

A Spring Boot project for managing **Subscribers**, **Billers**, and **Payments**.  
This project simulates a real-world utility payment processing platform with features like registration, login, payment initiation, and fetching payment history with pagination and sorting.

---

## 🧰 Technology Stack

- **Backend:** Java, Spring Boot, Spring Data JPA, Hibernate  
- **Database:** MySQL  
- **Build Tool:** Maven  
- **IDE:** IntelliJ IDEA  

---

## Folder Structure
src/main/java/com/example/utility_payment_processing_platform/
│
├─ controllers # REST Controllers (Subscriber, Biller, Payment)
├─ services # Business logic
├─ repositories # JPA Repositories
├─ entities # JPA Entities
├─ DTO # Request/Response DTOs
├─ exception # Global Exception Handler & Custom Exceptions
├─ UtilityPaymentProcessingPlatformApplication.java

## Setup Instructions

1. **Clone the repository**

```bash
git clone https://github.com/Anmolsri2002/Utility_Payment_Processing_Platform.git
cd Utility_Payment_Processing_Platform

2. **Create MySQL Database**

CREATE DATABASE utility_payment_platform;

3. Update application.properties

spring.datasource.url=jdbc:mysql://localhost:3306/utility_payment_platform
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
