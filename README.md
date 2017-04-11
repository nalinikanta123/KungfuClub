# KungfuClub
School Administrative website built in AngularJS and Spring Boot

# System Architecture
The system architecture is based on the traditional pattern MVC – Model View Controller. 
This pattern, when well applied, divide the system into three interconnected parts.
The MVC pattern provides low coupling among the user interface, business rules and data layer. 
It also allows code reuse and parallel development.
The User Interface (front-end) is coded essentially using HTML and JavaScript.
The AngularJS library was used to build the HTML code, interact with the server and return the responses from the server.
The client user interface will make requests to the server and the data returned will be JSON documents. 
They will be dynamically parsed to be presented to the user.
On the server-side we adopted Java as the programming language.
The web server used to build and run the system is Open Source and widely used, the Tomcat webserver.
The web layer is coded on the top of the Java Spring Framework.
It is also Open Source and in our system, it is responsible for receiving the clients requests via 
HTTP and return the data in JSON format back to the user interface to be presented.
The last important system layer is the data layer. The DBMS used to implement this system was PostgreSQL.
The ORM (Object-relational Mapping) API also provided by the Spring Framework was used to maintain the data 
and provide all the necessary access to the database to insert, update, remove and search.

