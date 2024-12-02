# Login Project

This is a simple login application built with Spring Boot, Spring Security, and MySQL. The application provides basic user registration and authentication functionalities.

## Features

- User registration with encrypted passwords
- User authentication
- Role-based access control (user, admin)
- Endpoints for registering users and viewing products

## Technologies Used

- Java 19
- Spring Boot 3.1.0-SNAPSHOT
- Spring Security
- Spring Data JPA
- MySQL
- Maven
- Lombok

## Getting Started

### Prerequisites

- Java 19
- MySQL
- Maven

### Installation

1. **Clone the repository:**
	```sh
    git clone https://github.com/bogdanene06/LoginProject.git
	```
 

2. **Configure the MySQL database:**

    - Create a database named `LoginProject`.
    - Update the `application.properties` file with your MySQL database credentials.

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/LoginProject?createDatabaseIfNotExist=true&autoReconnect=true&useSSL=false
    spring.datasource.username=root
    spring.datasource.password=""
    ```

3. **Build the project:**
    ```sh
    mvn clean install
    ```

4. **Run the project:**
    ```sh
    mvn spring-boot:run
    ```

### Usage

1. **Register a new user:**

    Send a POST request to `http://localhost:8080/my-user/register` with the following JSON body:

    ```json
    {
        "username": "Admin",
        "password": "passwordAdmin",
        "role": "admin"
    }
    ```

2. **View all products (authenticated user):**

    Send a POST request to `http://localhost:8080/product/all` with a valid `MyUserDTO` JSON body:

    ```json
    {
        "username": "Amin",
        "password": "passwordAdmin"
    }
    ```

3. **Add a new product (admin only):**

    Send a POST request to `http://localhost:8080/product/add` with the following JSON body:

    ```json
    {
        "username": "Admin",
        "password": "passwordAdmin",
        "productName": "Flower example added from front-end",
        "productPrice": 10.0
    }
    ```

### Project Structure

- `src/main/java/Exercitii/controller`: Contains the REST controllers for handling HTTP requests.
- `src/main/java/Exercitii/entity`: Contains the entity classes for the database.
- `src/main/java/Exercitii/mapper`: Contains the mappers for converting between DTOs and entities.
- `src/main/java/Exercitii/repository`: Contains the Spring Data JPA repositories.
- `src/main/java/Exercitii/config`: Contains the security configuration.
- `src/main/resources`: Contains the application properties and other resources.

### Contact

Author: **Ene Bogdan**
Country: **Romania**
