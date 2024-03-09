# TeamViewer Coding Challenge
Good morning team, this repository contains code for a SpringBoot web application to manage products in an inventory system, developed as part of the TeamViewer Coding Challenge. I would like to extend me gratitude to the TeamViewer engineering team for allowing me to participate in thes exercise. Originally, I am a React/Node.js developer and this challenge allowed me to hone in and discover new material. I appologize if there are areas within the challenege I did not get to. Again, thank you for the opportunity to partake in this challenge!

## Overview
This Product Management System allows users to perform various operations such as listing all products, adding new products, updating existing products, and deleting products from a PostgreSQL inventory database. The system provides a RESTful API for seamless integration with other applications.

### API Endpoints 
Product API Calls:  
GET /api/products - Get a list of all products  
GET /api/products/{id} - Get a product by ID  
POST /api/products - Create a new product  
PUT /api/products/{id} - Update an existing product  
DELETE /api/products/{id} - Delete a product by ID 

Order API Calls:  
GET /api/orders - Get a list of all orders  
GET /api/orders/{id} - Get an order by ID  
POST /api/orders - Create a new order  
PUT /api/orders/{id} - Update an existing order  
DELETE /api/orders/{id} - Delete an order by ID  

OrderItem API Calls:  
GET /api/order-items - Get a list of all order items  
GET /api/order-items/{id} - Get an order item by ID  
POST /api/order-items - Create a new order item  
PUT /api/order-items/{id} - Update an existing order item  
DELETE /api/order-items/{id} - Delete an order item by ID  

## Prerequisites
Before you begin, ensure you have Docker installed on your system. You can download and install Docker from the official Docker website.

## Building and Running the Application
Follow these steps to build and run the application using Docker:

cd TEAMVIEWER
Build the Docker image:

docker build -t teamviewer-app .
Run the Docker container:

docker run -p 8080:8080 teamviewer-app
Access the application in your web browser:

Navigate to http://localhost:8080 to access the application.

### Additional Information
The application uses PostgreSQL as the database. The Docker configuration includes a PostgreSQL container.
The OpenAPI specification for the Product API is provided in the product_api.yaml file.
You can customize the application configuration, such as database URL and credentials, by modifying the application.properties file.
API Documentation
For API documentation, you can use the Swagger UI provided by the application. Once the application is running, navigate to http://localhost:8080/swagger-ui.html in your web browser.

