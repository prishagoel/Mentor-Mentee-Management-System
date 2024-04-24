# Mentorship Management System

## Description

The Mentorship Management System is a Java Spring Boot web application designed to assist teachers in managing their mentorship activities. It implements an MVC architecture and utilizes an SQL database for data storage.

## Functionality

- **Student Management**: Teachers can keep a record of all students under their mentorship, view the student list, and add new students.
- **Meeting Management**: Teachers can schedule mentorship meetings with students and review past meetings.

## Design Principles

- **meeting.java**: Follows the Single Responsibility Principle (SRP) from SOLID principles.
- **student.java**: Follows the Single Responsibility Principle (SRP) from SOLID principles.
- **meetingservice.java**: Implements the Information Expert pattern from GRASP principles.
- **writeablestudentservice.java and impl**: Demonstrates Polymorphism from GRASP principles.
- **student service files**: Follows the Interface Segregation Principle (ISP) from SOLID principles.

## Creational Design Pattern

- **readablestudentserviceimpl.java**: Implements the Singleton Pattern for ensuring a single instance of the service.

## Structural Design Pattern

- **writeablestudentproxy.java**: Utilizes the Proxy Pattern to control access to write operations on student data.

## Behavioral Design Pattern

- **universitycontroller.java**: Implements the Command Pattern for encapsulating actions performed by the controller methods.

## Tech Stack

- Java Spring Boot
- SQL database

## Usage

To run the Mentorship Management System:
1. Clone this repository.
2. Set up the required database and configure database properties in the application.
3. Build and run the application using Maven or your preferred IDE.
4. Access the application through the provided URL.

   
