# BookChatz Backend

Welcome to the backend of **BookChatz** - a web application where readers can post their personal reviews about the books they have read. This project is built using Spring Boot and uses PostgreSQL as its database, running as a Docker container.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
- [Configuration](#configuration)
- [Running the Application](#running-the-application)
- [Running the Containerized Application](#running-the-containerized-application)
- [API Endpoints](#api-endpoints)
- [Contributing](#contributing)
- [License](#license)

## Features

- CRUD operations for user reviews.
- Integration with PostgreSQL database.
- RESTful API design.

## Technologies Used

- **Spring Boot**
- **Hibernate**
- **Flyway**
- **PostgreSQL**
- **Docker**

## Getting Started

### Prerequisites

Before you begin, ensure you have the following tools installed:

- [Java 22](https://jdk.java.net/22/)
- [Maven](https://maven.apache.org/)
- [Docker](https://www.docker.com/)
- [Postman](https://www.postman.com/) (optional, for testing APIs)

### Clone the Repository

```bash
git clone https://github.com/veysel-ozdemir/spring-backend-internship.git
cd spring-backend-internship
```

## Configuration

### Docker Setup

Ensure Docker is running on your local machine. The application includes a compose.yaml file and a Dockerfile for setting up the PostgreSQL database.

### Application Properties

The application is pre-configured to use the PostgreSQL database through Docker Compose. The relevant configuration can be found in the application.properties file:
```bash
...
spring.datasource.url=jdbc:postgresql://localhost:5432/blogdb
spring.datasource.username=postgres
spring.datasource.password=Bc.9876
spring.datasource.driver-class-name=org.postgresql.Driver
...
```

## Running the Application

1. Build the project using Maven:
```bash
mvn clean install
```

2. Run the Spring Boot application:
```bash
mvn spring-boot:run
```

## Running the Containerized Application
The application is fully containerized and deployed on [Docker Hub](https://hub.docker.com/r/veyselch/spring-app). 
If you prefer to run the entire application, including the Spring Boot backend and PostgreSQL database, using Docker, follow these steps:
1. Ensure Docker is running on your local machine.

2. Create the following `compose.yaml` file:
```yaml
version: '3.8'

services:
  app:
    image: veyselch/spring-app:latest
    container_name: app-latest
    ports:
      - "8000:8080"
    depends_on:
      - db
    networks:
      - backend
    environment:
      SPRING_DATASOURCE_URL: jdbc:postgresql://db:5432/blogdb
      SPRING_DATASOURCE_USERNAME: postgres
      SPRING_DATASOURCE_PASSWORD: Bc.9876

  db:
    image: postgres:latest
    container_name: db-latest
    environment:
      - POSTGRES_USER=postgres
      - POSTGRES_PASSWORD=Bc.9876
      - POSTGRES_DB=blogdb
    ports:
      - "5432:5432"
    networks:
      - backend

networks:
  backend:
    driver: bridge
```
3. Open the terminal in the directory where `compose.yaml` file is located and run the file with the following command:
```bash
docker-compose up
```

> *Run this command on subsequent uses to ensure that you are using the latest version of the containerized application:*
> ```bash
> docker-compose up --pull always
> ```

## API Endpoints

The application exposes the following endpoints:

- **/users** - User management endpoints
- **/posts** - Post management endpoints
- **/books** - Book management endpoints

### User Endpoints

- **/users/all** - get all users
- **/users/{id}** - get user by id
- **/users/posts?userId={id}** - get all posts of user
- **/users/login** - user login
- **/users/register** - user register
- **/users/edit-user** - update user
- **/users/delete/{id}** - delete user by id 

### Post Endpoints

- **/posts/all** - get all posts
- **/posts/{id}** - get post by id
- **/posts/users/{userId}** - get all posts of user
- **/posts/new-post** - create post
- **/posts/edit-post** - update post
- **/posts/delete/{id}** - delete post by id

### Book Endpoints

- **/books/all** - get all books
- **/books/{id}** - get book by id
- **/books/new-book** - create book
- **/books/delete/{id}** - delete book by id

## Contributing

Contributions are welcome! Please fork the repository and create a pull request with your changes.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

