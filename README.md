# AirMonke- Flight Booking App
<img align="right" src="https://github.com/pratyushgta/AirMonke_Aeroplan/blob/master/app/src/main/res/drawable/airmonke_logo_v.png?raw=true" height="250" width="300">
<div align="justify">
The purpose of the Airline Booking System is to provide a platform for customers to search for flights, make reservations, manage their passenger information, and process payments. 
  
The system aims to streamline the booking process, making it more efficient and user-friendly. It also aims to reduce manual work and errors associated with traditional booking systems.
This document outlines the software requirements for the development of a Flight Booking System using a microservices architecture.
</div>

<img src="https://github.com/pratyushgta/AirMonke_Aeroservice/blob/master/readme_files/AirMonke_Model.png?raw=true">

# SRS DOCUMENT:
## Scope
A fully responsive web-based Flight Booking System built using modern technologies, Microservices & Cloud Native Architecture patterns. It is an end-to-end reservation solution that makes use of microservices architecture with full-stack technologies. This includes below-mentioned functional microservices which are independently deployable with bounded context.
1.	Polyglot Languages & Frameworks: Java - Spring Boot/Cloud, JavaScript/TypeScript - Node, ExpressJS, React
2.	Polyglot Databases: MySQL
3.	Able to deploy to local Kubernetes (k8s) cluster as containers (Docker) and also to Public Cloud (AWS).

## System Overview
### Functional Overview
Building a microservice-based flight reservation system would require developing separate microservices for the respective functionalities within the system, which helps in building distributed architecture capabilities. This system can broadly be divided into below mentioned services: 
1. Authentication Service
- Manages user data and provides functionality for user registration, login, and profile management.
- Functionalities:
  - User registration and management
  - Authentication and authorization of users
  - Token generation and validation for secured access to services
       
2. Booking Service
- Handles the booking of flights. It interacts with the Flight Service to reserve seats and manage bookings. Also provides functionality for searching flights based on various criteria.
- Functionalities:
  - Create, read, update, and cancel bookings
  - Check booking status
  - Handle booking-related events such as confirmation, cancellation, etc.

 <img src="https://github.com/pratyushgta/AirMonke_Aeroservice/blob/master/readme_files/MSA_Project_ER1.png?raw=true">
 
3.	Flight Service
- Manages information about flights, including schedules, seat availability, and pricing.
- Functionalities:
  - Manage flight schedules
  - Manage seat availability and configurations
  - Provide flight information to passengers

<img src="https://github.com/pratyushgta/AirMonke_Aeroservice/blob/master/readme_files/MSA_Project_ER2.png?raw=true">

5.	Passenger Service
- Manages passenger information who have booked tickets. Interacts with Authentication Service and Booking Service.
- Functionalities:
  - Manage passenger profiles
  - Associate passengers with bookings
  - Retrieve passenger details for bookings

6.	Payment Service
- Handles payment transactions. It interacts with the Booking Service to confirm bookings upon successful payment.
- Functionalities:
  - Process payment transactions securely
  - Handle payment status updates
  - Provide payment confirmation to passengers

### ER Diagram
<img src="https://github.com/pratyushgta/AirMonke_Aeroservice/blob/master/readme_files/MSA_Project_ER3.png?raw=true">

### Technical Overview
Domain-driven implementation is the most optimal way of implementing the before-mentioned microservices using Spring Cloud. Following are the key artifacts of the implementation:

1. Technologies used by each microservice

| Microservice | Technologies that can be used |
| --- | --- |
| Authentication Service | REST API built using: Spring Boot, Spring Cloud with Maven as build tool, Leverages MySQL as data store |
| Booking Service | REST API built using: NodeJS, Relies on MySQL as a data store, Kafka for handling events related to flight updates, schedule changes, etc. Docker for containerizing the flight services |
| Flight Service | REST API built using: Spring Boot, Spring Cloud with Maven as build tool, Leverages MySQL as data store |
| Passenger Service | REST API built using: SpringBoot, Spring Data JPA: For interacting with the database and managing passenger-related data, Spring Cloud Netflix Eureka: For service registration and discovery |
| Payment Service | Docker: For containerizing payment service and ensuring consistent deployment across environments, JWT: Securing payment service endpoints and managing authentication |

2. Common technologies
- Swagger/OpenAPI:  For documenting and exposing RESTful APIs for payment and booking related functionalities.
- SQL Server or MySQL: As a relational database for storing payment information.
- Eureka Server (Service Registry): Netflix Eureka Server for service registration and discovery. Each microservice registers itself with Eureka server upon startup, and other microservices can discover these services by querying Eureka.
- API Gateway (Spring Cloud Gateway): To route requests from clients to appropriate microservices. It can also handle cross-cutting concerns like authentication, rate limiting, etc.
- DTO (Data Transfer Objects): To transfer data between microservices and clients. They help in decoupling the internal domain model of a microservice from the external API.
- Security: Implementing security measures such as OAuth2 or JWT for authentication and authorization of API requests.
- Logging and Monitoring: 
- Containerization (Docker): Containerizing each microservice using Docker for easy deployment and scalability.
- Orchestration (Kubernetes): For deploying Dockerized microservices on a Kubernetes cluster for container orchestration, scaling, and management.
- Real-time Data Streaming: Apache Kafka for live availability updates

### Workflow
<img src="https://github.com/pratyushgta/AirMonke_Aeroservice/blob/master/readme_files/MSA_Project_ER4.png?raw=true">
<img src="https://github.com/pratyushgta/AirMonke_Aeroservice/blob/master/readme_files/MSA_Project_ER5.png?raw=true">

> Contributed by:
- [Pratyush](https://github.com/pratyushgta)
- [Aadil](https://github.com/code-il)
- [Vidit](https://github.com/viditk2)
- [Ansh](https://github.com/AnshM0301)
