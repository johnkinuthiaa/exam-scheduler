# **Springboot Exam Scheduler**
**This project is a web application designed to streamline the exam scheduling process. It's built using Maven, Spring Boot, and SQL for a robust and efficient solution.**
## Prerequisites
**Before running the project, ensure you have the following installed:**

- **Java 17 or later**
- **Maven**
- **MySQL or PostgreSQL with a configured user and database.**


## Cloning the Project 

**`git clone https://github.com/johnkinuthiaa/exam-scheduler.git`**

## Configuring Database
**Update Application Properties: Open the application.properties file in the src/main/resources directory. Modify the database connection properties to match your database configuration:
Properties**

**`spring.datasource.url=jdbc:[your db source]`**

**`spring.datasource.username=your_username`**

**`spring.datasource.password=your_password `**


# Running the Project

**Build and Run: From the project's root directory, run the following Maven command:**

``Bash``

**`mvn spring-boot:run`**

**This will build the project and start the Spring Boot application.**
## Accessing the Application
**Once the application starts, it will be accessible at http://localhost:8080 (or the port specified in application.properties file).**
