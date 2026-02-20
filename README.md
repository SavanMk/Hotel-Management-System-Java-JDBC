Hotel Management System (Java + JDBC + MySQL) 

Project Overview

This is a console-based Hotel Management System developed using Core Java, JDBC, and MySQL following the DAO (Data Access Object) and DTO (Data Transfer Object) architecture pattern.
The system allows users to manage hotel rooms with full CRUD operations and filtered search functionality.

Features

Add new rooms
view all rooms
Update room status (Available / Occupied)
Delete rooms
View only available rooms

Structured layered architecture (DAO + DTO)

Uses PreparedStatement (prevents SQL injection)
Technologies Used
Java (JDK 17)
JDBC
MySQL
Git & GitHub
VS Code

Project Structure
HotelApp
│
├── src
│   ├── model
│   │   └── RoomDTO.java
│   │
│   ├── dao
│   │   ├── RoomDAO.java
│   │   └── RoomDAOImpl.java
│   │
│   └── Main.java
│
└── mysql-connector-j (Referenced Library)

Architecture Used

This project follows a layered architecture:
Main (UI Layer)
        ↓
DAO Interface
        ↓
DAO Implementation (JDBC Logic)
        ↓
MySQL Database
✔ DTO (RoomDTO)

Used to transfer room data between layers.

✔ DAO (RoomDAO)

Defines database operations.

✔ DAO Implementation (RoomDAOImpl)

Contains actual JDBC logic for database interaction.

Database Setup
Create Database
CREATE DATABASE hotel_db;
USE hotel_db;
Create Table
CREATE TABLE rooms (
    room_id INT PRIMARY KEY AUTO_INCREMENT,
    room_type VARCHAR(50),
    price DOUBLE,
    status VARCHAR(20)
);

How to Run the Project

Install MySQL and create the database & table.
Update database credentials in RoomDAOImpl.java:

private static final String USER = "root";
private static final String PASS = "your_password";

Make sure MySQL Connector JAR is added to referenced libraries.
Run Main.java.
