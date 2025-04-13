# TredBase Family Payment Processing System

This is a Spring Boot application for processing real-time family payments involving parents and students. It handles shared and unique relationships, ensures atomic balance updates, and integrates security for role-based access control.

---

## 🚀 How to Build, Run, and Test the Application

### ✅ Prerequisites
- Java 17+
- Maven 3.8+
- Postman

### ✅ Build the Application

```bash
mvn clean install
✅ Run the Application
bash
Copy
Edit
mvn spring-boot:run
This will:

Start the application on http://localhost:8080

Automatically seed:

2 parents: Parent A (id=1), Parent B (id=2)

3 students: Student 1 (shared), Student 2 (Parent A only), Student 3 (Parent B only)

✅ Test the Application
Use Postman or any API client to send a POST request:

URL: http://localhost:8080/api/payments
Authorization: Basic Auth

Username: admin

Password: adminpass

Body (example):

json
Copy
Edit
{
  "parentId": 1,
  "studentId": 1,
  "paymentAmount": 100.00
}
Expected Output:

json
Copy
Edit
{
  "message": "Payment processed successfully",
  "studentId": 1,
  "updatedStudentBalance": 300.00,
  "updatedParentBalances": {
    "1": 450.00,
    "2": 470.00
  }
}
🔐 Security Design Decisions
Spring Security is used with Basic Auth (no JWT) for simplicity.

Only users with role ADMIN are authorized to access the /api/payments endpoint.

User credentials are configured in-memory using InMemoryUserDetailsManager.

This approach provides a secure yet lightweight authentication layer, suitable for rapid testing and internal systems.

🔄 Multi-Table Payment Processing Design
The PaymentService is annotated with @Transactional to ensure atomic operations across multiple tables.

The method updates balances in the Parent and Student entities:

If any error occurs during the transaction (e.g., invalid ID, DB failure), all changes are rolled back automatically.

Shared children result in updates to both parent records.

Unique children affect only the initiating parent.

This ensures consistency across all tables and meets the atomicity requirement defined in the task.

📊 Arithmetic Logic and Balance Update Explanation
Dynamic Fee Logic:
Each payment applies a dynamic fee of 10%:

java
Copy
Edit
adjustedAmount = paymentAmount * (1 + 0.1)
This means the amount deducted from the parent(s) is 10% more than what the student receives.

For shared children, the fee-inclusive amount is split evenly between both parents.

For example:

paymentAmount = 100

adjustedAmount = 110

parentA -55, parentB -55

student +100

All arithmetic is done using BigDecimal to preserve accuracy and prevent floating-point rounding issues.

Used both H2 and Mysql they work the current database is H2 database

🧠 Summary
✅ Secure API with role-based access

✅ Atomic, rollback-safe updates to multiple tables

✅ Accurate arithmetic with real-world fee logic

✅ Ready for local testing and deployment
