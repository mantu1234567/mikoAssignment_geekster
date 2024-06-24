### Miko Assignment Project
Overview

The Miko Assignment project is a simple Spring Boot application that provides an API for executing SQL commands to create tables and insert data. The application uses Redis to track the success or failure of these operations and stores metadata and data in text files.

Features

Execute SQL Commands: The API can handle SQL commands for creating tables and inserting data.
Track Operations: Redis is used to keep count of successful and failed operations.
Store Data: Metadata and data are stored in text files.

Requirements
Java 17 or later
Spring Boot 3.3.1 or later
Redis
Installation
Clone the repository:

bash
Copy code
git clone [https://github.com/mantu1234567/mikoAssignment_geekster]
cd mikoAssignment
Build the project:

bash
Copy code
mvn clean install
Run the project:

bash
Copy code
mvn spring-boot:run
Usage
API Endpoint
POST /execute: Executes a given SQL command.
Request
URL: /execute
Method: POST
Body: Raw SQL string
Example
Create Table:

sh
Copy code
curl -X POST http://localhost:8080/execute -d "CREATE TABLE USERS (id INTEGER, name String)"
Insert Data:

sh
Copy code

curl -X POST http://localhost:8080/execute -d "INSERT INTO USERS VALUES (1, 'Mantu')"
Redis Keys

SUCCESS: Incremented for each successful operation.
FAILURE: Incremented for each failed operation.
Code Explanation

MikoAssignmentApplication.java

This is the main entry point for the Spring Boot application.

DatabaseController.java

This controller handles the /execute endpoint, processes the SQL string, and calls the appropriate service methods.

DatabaseService.java

This service contains methods to handle CREATE TABLE and INSERT INTO SQL commands. The metadata and data are stored in metadata.txt and data.txt files respectively.

Methods
handleCreateTable(String sqlString): Parses and processes CREATE TABLE SQL commands.
handleInsertTable(String sqlString): Parses and processes INSERT INTO SQL commands.
Contributing
Fork the repository
Create a new branch (git checkout -b feature-branch)
Make your changes
Commit your changes (git commit -m 'Add some feature')
Push to the branch (git push origin feature-branch)
Create a new Pull Request
License
This project is licensed under the MIT License. See the LICENSE file for details.

Acknowledgements
Spring Boot
Redis
