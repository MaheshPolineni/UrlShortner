# URL Shortener

A full-stack **URL Shortener application built with Java**, allowing users to convert long URLs into short, easy-to-share links.

The application also provides **user authentication using JWT**, allowing users to securely sign up, log in, and manage their own shortened URLs.

---

## About the Project

The application provides a simple way to create and manage shortened URLs.

Users can:

* Create an account
* Log in securely using JWT authentication
* Convert long URLs into short URLs
* Access the original URL through the generated short URL
* View URLs created by their account
* Manage their URL history

The project also includes a frontend built using **HTML, CSS, and JavaScript**.

---

## Features

### URL Shortening

Users can submit a long URL and receive a unique shortened URL.

```text
Long URL
   │
   ▼
https://example.com/a/very/long/url/with/many/parameters
   │
   ▼
URL Shortener
   │
   ▼
https://your-domain/Ab12X
```

---

### URL Redirection

When a user visits the generated short URL, the application looks up the corresponding original URL and redirects the user to it.

```text
Short URL
    │
    ▼
Backend
    │
    ▼
Find original URL
    │
    ▼
Redirect
    │
    ▼
Original URL
```

For example:

```text
https://your-domain/Ab12X
              ↓
https://example.com/some/long/url
```

---

### User Authentication

The application uses **JWT (JSON Web Tokens)** for authentication.

Users can:

* Sign up
* Log in
* Receive an authentication token
* Access protected functionality
* Manage URLs associated with their account

Simplified authentication flow:

```text
User
 │
 ├── Signup
 │      ↓
 │   Account Created
 │
 └── Login
        ↓
     JWT Token
        ↓
Authenticated Requests
```

---

### JWT Authentication

Protected requests require a valid JWT.

```text
Client
   │
   │ Request + JWT
   ▼
Backend
   │
   ├── Validate JWT
   │
   ├── Valid ──────► Process Request
   │
   └── Invalid ────► Reject Request
```

This allows the application to associate requests with authenticated users.

---

### User-Specific URLs

Each authenticated user can view the URLs associated with their account.

Example:

```text
User: John

Original URL                         Short URL
---------------------------------------------------
https://example.com/page1            /Ab12X
https://example.com/products         /K9Lm2
https://example.com/about            /Pq72Z
```

This allows users to keep track of the URLs they have created.

---

## Technologies Used

### Backend

* Java
* Java Web / Spring-based backend
* JWT Authentication

### Frontend

* HTML
* CSS
* JavaScript

### Authentication

* JSON Web Tokens (JWT)
* Signup and Login

---

## Application Architecture

```text
                  ┌─────────────────────┐
                  │      Frontend       │
                  │   HTML/CSS/JS       │
                  └──────────┬──────────┘
                             │
                             │ HTTP Requests
                             ▼
                  ┌─────────────────────┐
                  │    Java Backend     │
                  │                     │
                  │ Controllers         │
                  │ Authentication      │
                  │ URL Shortening      │
                  │ URL Redirection     │
                  └──────────┬──────────┘
                             │
                             ▼
                  ┌─────────────────────┐
                  │     Data Storage    │
                  │                     │
                  │ Users               │
                  │ Original URLs       │
                  │ Short URLs          │
                  └─────────────────────┘
```

---

## URL Shortening Flow

When a user submits a long URL:

```text
1. User enters long URL
           ↓
2. Frontend sends request
           ↓
3. Backend receives URL
           ↓
4. Short identifier is generated
           ↓
5. URL mapping is stored
           ↓
6. Short URL is returned
           ↓
7. User can share the short URL
```

---

## Redirection Flow

When someone accesses a short URL:

```text
1. User opens short URL
           ↓
2. Backend receives short identifier
           ↓
3. Application searches for URL mapping
           ↓
4. Original URL is retrieved
           ↓
5. User is redirected to original URL
```

---

## Project Structure

A simplified structure:

```text
URL-Shortener/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── ...
│       │
│       └── resources/
│           └── static/
│               ├── html/
│               ├── css/
│               └── js/
│
├── pom.xml
└── README.md
```

> The exact structure may vary depending on the current project implementation.

---

## Getting Started

### Prerequisites

* Java JDK
* Maven
* Mysql database with a Url_shortner names database 

### Clone the Repository

```bash
git clone <your-repository-url>
```

Build the application:

```bash
mvn clean package
```

Run the application:

```bash
mvn spring-boot:run
```

Alternatively:

```bash
java -jar target/urlshortner.jar
```

---

## Authentication

### Signup

A new user can create an account by providing the required registration information.

### Login

After successful login, the backend generates a JWT that can be used to access protected endpoints.

```text
Signup
  ↓
Login
  ↓
JWT Generated
  ↓
Authenticated Requests
```

---

## Project Objectives

The main objectives of this project were to:

* Build a URL shortening service using Java
* Understand URL mapping and redirection
* Implement user authentication
* Learn JWT-based authentication
* Associate shortened URLs with individual users
* Build a frontend using HTML, CSS, and JavaScript
* Understand communication between frontend and backend
* Practice developing a complete web application

---

## Key Concepts Learned

Through this project, I gained practical experience with:

* Java backend development
* REST API development
* JWT authentication
* User registration and login
* Authentication and authorization
* URL shortening algorithms
* HTTP redirects
* Frontend-backend communication
* User-specific data management
* Web application development

---

## Future Improvements

Potential improvements include:

* Add URL expiration
* Add click/visit analytics
* Track creation and expiration dates
* Add custom short URLs
* Add rate limiting
* Add URL validation
* Add QR code generation
* Add pagination for user URL history
* Add automated tests
* Add Docker support
* Add CI/CD deployment

---

## Project Status

**Completed — Personal/learning project.**

The project was developed to gain hands-on experience with **Java web development, URL shortening, JWT authentication, and frontend-backend integration**.
