<h1 align = "center"> Expense Tracker </h1>

<p align="center">
<a href="Java url">
    <img alt="Java" src="https://img.shields.io/badge/Java->=8-darkblue.svg" />
</a>
<a href="Maven url" >
    <img alt="Maven" src="https://img.shields.io/badge/maven-3.0.5-brightgreen.svg" />
</a>
<a href="Spring Boot url" >
    <img alt="Spring Boot" src="https://img.shields.io/badge/Spring Boot-3.0.6-brightgreen.svg" />
</a>
  
<a >
    <img alt="MySQL" src="https://img.shields.io/badge/MySQL-blue.svg">
</a>
</p>
   
The expense tracker API enables users to manage their expenses by creating, reading, updating, and deleting expense records. It supports user registration and login. The API stores expenses with details like title, description, price, date, time, and userId. Users can generate reports for specific months or weeks. The API uses a MySQL database, implements annotation-based validation, and follows a structured project organization with separate packages for different components.

---
<br>

## Framework Used
* Spring Boot

---
<br>

## Dependencies
The following dependencies are required to run the project:

* Spring Boot Dev Tools
* Spring Web
* Spring Data JPA
* MySQL Driver
* Lombok
* Validation

<br>

## Database Configuration
To connect to a MySQL database, update the application.properties file with the appropriate database URL, username, and password. The following properties need to be updated:
```
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
spring.datasource.url = jdbc:mysql://localhost:3306/<DatabaseName>
spring.datasource.username =root
spring.datasource.password =Abhay123@
spring.jpa.show-sql = true
spring.jpa.hibernate.ddl-auto = update

spring.jpa.properties.hibernate.show_sql=true
spring.jpa.properties.hibernate.use_sql_comments=true
spring.jpa.properties.hibernate.format_sql=true

```
<br>

## Language Used
* Java

---
<br>

## Data Model

<br>



* Authentication Token 
```
tokenId : Long
token : string
tokenCreationDate : LocalDate
@OneToOne 
user : User

```


<br>
 


<br>

## DataBase Used
* SQL database
```
We have used Persistent database to implement CRUD Operations.
```
---
<br>

# Documentation
To develop an expense tracker API with the given requirements, we will use Java with the Spring Boot framework, MySQL as the database, and Hibernate for object-relational mapping. The API will provide endpoints for users to perform CRUD operations on expenses, generate reports, and retrieve expenses for a specific date and time.

Key Points:

Users must sign in or register to access the API.
The expense model will include fields such as title, description, price, date, time, and userId.
The API should have endpoints to create, read, update, and delete expenses.
Users can generate reports for a specific month or week.
The API should store expense records for at least three months.
MySQL will be used as the database, and the IP address of the deployment link should be static.
Annotation-based validation should be implemented for input validation.
The project should have separate packages for controllers, services, repositories, models, and DTOs.
By following these guidelines, you can develop a robust expense tracker API that allows users to manage their expenses, generate reports, and retrieve expenses based on specific criteria.
