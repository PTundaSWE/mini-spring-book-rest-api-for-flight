# Mini Spring Boot REST API for Flight

---

This is a tiny but real Spring Boot REST API for Flight 🚀
**Technologies in use:**

- Spring Web (REST)
- Spring Data JPA
- H2 in-memory DB (no setup needed)

> **You can later swap H2 → MySQL/Postgres easily.**

---

## Project Structure

```plaintext
mini-spring-rest-api-for-flight/
pom.xml
src/
  main/
    java/
      org/
        paul/
          flightapi/
          FlightApiApplication.java
          model/
            Flight.java
          repository/
            IFlightRepository.java
          service/
            FlightService.java
          controllers/
            FlightController.java
    resources/
      application.properties(H2 config)    
```

---

## Class Diagram

![Image](https://github.com/PTundaSWE/mini-spring-book-rest-api-for-flight/blob/main/docs/flight-api-Flight_API___Class_Diagram.png)

---

## Test the API 

1. Run:
   `mvn spring-boot:run`
2. Create a flight (POST):
   ```bash
    curl -X POST http://localhost:8080/api/flights \
    -H "Content-Type: application/json" \
    -d '{"departureCity":"PIT","arrivalCity":"NYC"}'
   ```
3. Get all flights (GET):
   `curl http://localhost:8080/api/flights`
4. Search by route:
   `curl "http://localhost:8080/api/flights/search?from=PIT&to=NYC"`   