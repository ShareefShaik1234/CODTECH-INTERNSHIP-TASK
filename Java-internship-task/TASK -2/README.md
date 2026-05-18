# REST API Client in Java

## Overview
This project is a Java REST API Client developed for CODTECH Internship Task 2.

The application:
- Connects to a public REST API
- Sends HTTP GET requests
- Receives JSON responses
- Parses and displays structured data

API Used:
https://api.agify.io

---

## Features
- REST API integration
- HTTP request handling
- JSON response parsing
- Structured output display
- Exception handling

---

## Technologies Used
- Java
- HttpURLConnection
- JSON Parsing
- REST API

---

## File Name

```bash
RestApiClient.java
```

---

## How to Compile

```bash
javac RestApiClient.java
```

---

## How to Run

```bash
java RestApiClient
```

---

## Sample Output

```text
Enter a name: Rahul

RAW JSON RESPONSE:
{"name":"rahul","age":27,"count":45678}

===== STRUCTURED DATA =====
Name            : rahul
Predicted Age   : 27
Prediction Count: 45678
```

---

## Internship Task
CODTECH Internship - Task 2

Develop a Java application that:
- Connects to a REST API
- Fetches JSON data
- Parses and displays useful information