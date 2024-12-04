# AKAKCE CLONE PROJECT

## Technologies Used

- **Spring**: Backend framework used for creating RESTful APIs.
- **Vue**: Frontend framework used for building the user interface.
- **PostgreSQL**: Database used to store application data.

## Images
![image](https://github.com/user-attachments/assets/cd93c337-722c-45db-a72c-1de58cb2abf9)
![image](https://github.com/user-attachments/assets/20ac770a-c5b7-4c41-8e28-d1db9b11827a)
![image](https://github.com/user-attachments/assets/8c4c14f1-d457-4c22-ac15-8dd78fada376)
![image](https://github.com/user-attachments/assets/bcfe2471-0665-4155-80ab-a3ad63951d1b)
![image](https://github.com/user-attachments/assets/43c2275f-c4b3-4bef-8efa-66253501836c)
![image](https://github.com/user-attachments/assets/f0bbf837-76fc-47a5-9e7a-cb3aa2653d1e)

## APIs
Below are the available API endpoints:

### 1. **GET** `/api/products`
   - **Description**: Fetches all product data while ensuring that no duplicate products are included. This API is used on the main screen of the application, where we display a list of unique products. Products with pricing details are fetched from the `/api/products/all` endpoint.

### 2. **GET** `/api/products/all`
   - **Description**: Fetches all product data, including inactive products (if applicable).

### 3. **POST** `/api/products/all`
   - **Description**: Adds a new product or updates an existing one.

### 4. **DELETE** `/api/products/{id}`
   - **Description**: Deletes the product with the specified `id`.

### 5. **GET** `/api/products/model/{modelNo}`
   - **Description**: Fetches product details based on the specific model number (`modelNo`).

## Installation

To run the project locally:

1. Clone this repository.
2. Set up the PostgreSQL database.
3. Configure the Spring and Vue applications.
4. Start the backend and frontend servers.
