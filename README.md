# BazaarAPI

**Description:** 

The Bazaar API is a platform that allows the management of customers, sales and products of a store. 
In addition to basic CRUD operations, it offers additional functionalities to improve business efficiency and analytics.

This api is the final project of the [Java API Development with SpringBoot course](https://todocodeacademy.com/course/desarrollo-de-apis-con-spring-boot/) of [TodoCode](https://todocodeacademy.com/)

## Requirements

Make sure you have the following installed before running the API:

- Java SDK 17
- Spring Boot
- MySQL 8.0+ (for database)
- Xampp or Wampp (for the database server)

And the Maven depences:
- Spring Boot DevTools DEVELOPER TOOLS
- Lombok DEVELOPER TOOLS 
- MySQL Driver SQL
- Spring Data JPA SQL
- H2 Database SQL
- Spring Web WEB

I recommend using the [IntelliJ IDEA IDE](https://www.jetbrains.com/idea/)  to run the API and to generate the Spring with [Spring Initializr](https://start.spring.io/).

## Installation

1. Open the terminal and drag the repository to a folder on your computer:
  
    -> mkdir bazaarapi (on your desktop).

    -> cd bazaarapi

    -> git clone https://github.com/lautajam/BazaarAPI

4. Open xaamp or wampp and run the MySQL server.

5. Create a MySQL database with the name "bazaar_db" (or name it whatever you want and modify the application.properties file).

6. In the terminal, access your project directory:

   -> cd bazaarapi (on your desktop).

8. Compile and run the project:

   -> mvn spring-boot:run

## Usage
At initialization time the API documentation can be found at the following link: localhost:8080/swagger-ui.html (port may vary).

In the Postman_Collection folder are all the api collections to import in Postman, everything is ready to be tested.
testing.
