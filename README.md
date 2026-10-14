# Spring Training REST API

A simple Spring Boot REST API for managing customers, products, and orders. The
application uses Spring Data JPA with an in-memory H2 database for local
development.

## Technology Stack

- Java 21
- Spring Boot 4.1.0
- Spring Web MVC
- Spring Data JPA
- H2 Database
- Maven

## Project Structure

```text
src/
├── main/
│   ├── java/com/example/demo/
│   │   ├── controller/   # REST endpoints
│   │   ├── entity/       # JPA entities
│   │   ├── repository/   # Data access layer
│   │   └── service/      # Business logic
│   └── resources/
│       └── application.properties
└── test/
    └── java/             # Application tests
```

## Prerequisites

- JDK 21 or later
- Git

The repository includes the Maven Wrapper, so a separate Maven installation is
not required.

## Getting Started

Clone the repository and start the application:

```bash
git clone <repository-url>
cd SpringMIT
```

On Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

On macOS or Linux:

```bash
./mvnw spring-boot:run
```

The API starts at [http://localhost:8081](http://localhost:8081).

## API Overview

### Customers

| Method | Endpoint | Description |
| --- | --- | --- |
| `GET` | `/customers` | List all customers |
| `POST` | `/customers` | Create a customer |
| `GET` | `/customers/{id}` | Find a customer by ID |
| `GET` | `/customers/email/{email}` | Find a customer by email |
| `GET` | `/customers/city/{city}` | Find customers by city |
| `GET` | `/customers/age/{age}` | Find customers by age |
| `POST` | `/customers/list` | Create multiple customers |
| `PUT` | `/customers/{id}` | Update a customer |
| `DELETE` | `/customers/{id}` | Delete a customer |

### Products

| Method | Endpoint | Description |
| --- | --- | --- |
| `GET` | `/products` | List all products |
| `POST` | `/products` | Create a product |
| `POST` | `/products/list` | Create multiple products |
| `GET` | `/products/{id}` | Find a product by ID |
| `GET` | `/products/category/{category}` | Find products by category |
| `PUT` | `/products/{id}` | Update a product |
| `DELETE` | `/products/{id}` | Delete a product |

### Orders

| Method | Endpoint | Description |
| --- | --- | --- |
| `POST` | `/orders/{customerId}/{productId}/{qty}` | Place an order |
| `GET` | `/orders` | List all orders |
| `GET` | `/orders/customer/{customerId}` | List orders for a customer |
| `GET` | `/orders/count/{customerId}` | Count a customer's orders |
| `GET` | `/orders/bill/{customerId}` | Calculate a customer's total bill |
| `GET` | `/orders/revenue` | Calculate total revenue |

## H2 Database Console

The H2 console is enabled for local development at:

```text
http://localhost:8081/h2-console
```

Use the JDBC URL and credentials configured in
`src/main/resources/application.properties`.

> The database is in-memory, so its data is cleared whenever the application
> restarts.

## Testing

Run the test suite with:

```powershell
.\mvnw.cmd test
```

On macOS or Linux:

```bash
./mvnw test
```

## Frontend

The frontend is maintained in a **separate repository** and is not included in
this project. Configure the frontend to use the API base URL:

```text
http://localhost:8081
```

## License

This project is intended for learning and development purposes.
