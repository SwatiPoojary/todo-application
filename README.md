
# Todo Application

This is a simple online todo application with a web interface.
The basic functionality of the application are:
1) User can sign in with a unquie username and password.
2) User can view their task list
3) User can add new task
4) User can Mark an individual task as Done or Pending
5) User can update the task and in the update page the user can also mark the task as Done or Pending
6) User can delete the task
7) All the task will be stored in the database so that when the user logins in again, he/she can view the task
8) The task list will show Id, Description, Status,	Created Date and Modified Date.
9) Whenever the task is pending it will be in yellow colour and whenever the task will be done it will be in green color

## Technologies used
Java
Springboot
Spring Security
Spring Data JPA
H2 Database
Html
Thymeleaf
Docker

## Production Ready

Dockerfile is present to dockerzie the application
build docker image using script:
    docker build -t todo-application .
run application:
    docker run -p 8080:8080 todo-application

## Approaches Used
H2 database is used because it is an open source, embedded and in memory relational database. Dependency of adding a new database is avoided. The data is persisted in the h2 file and hence the user can login can any to view their data.

Thymeleaf is used instead of JSP because it provides more readable code, it is easy to understand as it has HTML like syntax and can also perform complex functionality.

Spring security is used because it provides ways of implementing authentication, authorization and protection. There is no need to write code for the login functionality, spring security provides it bydefault. 

## Design Patterns
1) Singleton Design Pattern
Singleton design pattern ensures that a class can have only one object. Spring makes sure that this design pattern is followed and allows a singleton object per container.

2) Proxy Design Pattern
Proxy is a structural design pattern, in which a object acts as a substitute for the actual object. In our application proxy is used in service layer where the controller can only access the service interface, and the interface will then provide a implementation class for the service.


## Anything extra you would have done give more time
Registration Page
Logout button
Junit Test Cases


