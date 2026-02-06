# Items REST API – Sample Task Submission

## Overview

This is a simple Java (Spring Boot + Kotlin) backend application that provides REST APIs to manage a collection of items.
The application uses an in-memory data store (ArrayList) and supports adding items and fetching items by ID.

## Technologies Used

* Java 17
* Spring Boot
* Kotlin
* Gradle
* Reactive Web (WebFlux)

## Item Model

Each item contains:

* id (auto-generated)
* name (required)
* description (required)
* price (positive value)

## Data Storage

Items are stored in memory using an ArrayList.
Data will reset when the application restarts.

## API Endpoints

### 1) Add Item

**POST** `/items`

Request Body:

```
{
  "name": "Laptop",
  "description": "Gaming laptop",
  "price": 75000
}
```

Response:

```
{
  "id": 1,
  "name": "Laptop",
  "description": "Gaming laptop",
  "price": 75000
}
```

### 2) Get Item by ID

**GET** `/items/{id}`

Example:

```
GET /items/1
```

Response:

```
{
  "id": 1,
  "name": "Laptop",
  "description": "Gaming laptop",
  "price": 75000
}
```

## Input Validation

* name → required
* description → required
* price → must be positive

## How to Run the Application

### Prerequisites

* Java 17 installed
* Gradle (or use wrapper)

### Steps

1. Open terminal in project folder
2. Run:

```
./gradlew bootRun
```

3. Server starts at:

```
http://localhost:8080
```

## Testing APIs

### Using curl (PowerShell)

```
Invoke-RestMethod -Method POST "http://localhost:8080/items" -ContentType "application/json" -Body '{"name":"Phone","description":"Android","price":20000}'
```

Then open:

```
http://localhost:8080/items/1
```

## Important Notes

* This uses in-memory storage only
* No database is used
* Data resets after restart

## Author

Submitted as part of Freelance Java Developer sample task.
