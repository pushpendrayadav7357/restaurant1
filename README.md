# Restaurant Management System

The Restaurant Management System is a Spring Boot application designed to manage a restaurant's menu, orders, and user roles. It offers various features for different user roles (Admin, Normal User, Visitor) to interact with the system.

## Frameworks and Language Used

- **Framework**: Spring Boot
- **Programming Language**: Java
- **Database**: H2 Database (for demonstration; can be configured for other databases)
- **Security**: Spring Security with JSON Web Tokens (JWT)
- **API**: RESTful API
- **Frontend**: Not included (can be integrated as needed)

## Data Flow

The project follows a typical Spring Boot architecture with the following key components:

1. **Controller**:
   - Responsible for handling incoming HTTP requests and routing them to the appropriate service methods.
   - Defines the REST endpoints for user, food item, and order management.
   - Implements role-based access control for these endpoints.

2. **Services**:
   - Implements business logic for user management, food item management, and order management.
   - Validates and processes requests from controllers.
   - Utilizes repositories to interact with the database.
   
3. **Repository**:
   - Provides data access and persistence.
   - Interacts with the H2 database to manage user, food item, and order data.
   
4. **Database Design**:
   - The application uses an H2 in-memory database for demonstration purposes.
   - Data entities include User, FoodItem, and Order, each with their respective attributes and relationships.

## Data Structures Used

The project leverages several data structures, including:

- **Entities**: User, FoodItem, Order
- **Data Transfer Objects (DTOs)**: Used to transfer data between the frontend and backend.
- **Role-based Access Control Lists**: Lists of endpoints and their associated user roles for access control.

## Project Summary

The Restaurant Management System is a Spring Boot application that allows users to interact with the system based on their roles. It provides functionalities for user registration and authentication, food item management, order placement, and order status updates.

- **User Roles**:
  - Admin: Can create food items, view all orders, and update order statuses.
  - Normal User: Can place orders and view their order history.
  - Visitor: Can view food items and descriptions but cannot place orders.

- **Security**:
  - JWT-based authentication and role-based access control for secure user management and data access.

- **Database**:
  - Uses an H2 in-memory database for demonstration purposes, with entities designed to represent users, food items, and orders.

