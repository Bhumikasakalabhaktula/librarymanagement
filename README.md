# Library Management System

## Overview

The Library Management System is a Spring Boot application designed to manage authors, books, and publishers. It provides a RESTful API for creating, reading, updating, and deleting records in a library database. This system aims to streamline the management of library resources and improve the user experience for both library staff and patrons.

## Features

- **Author Management**: Create, read, update, and delete authors.
- **Book Management**: Manage books, including their titles, publication dates, authors, and publishers.
- **Publisher Management**: Create, read, update, and delete publishers.
- **Search Functionality**: Search for books by title, author, or publisher.
- **Sorting**: Sort books by title or publication date.
- **Reporting**: Generate reports on the count of books by each author.
- **Error Handling**: Comprehensive error handling with meaningful messages.

## Technologies Used

- **Java**: Programming language used for the application.
- **Spring Boot**: Framework for building the RESTful API.
- **JPA (Hibernate)**: ORM for database interactions.
- **MySQL**: Database for storing authors, books, and publishers.
- **Lombok**: Library to reduce boilerplate code.
- **Jackson**: Library for JSON processing.

## Prerequisites

Before you begin, ensure you have the following installed:

- **Java 11 or higher**
- **MySQL Server**
- **Maven**

## Setup Instructions

1. **Clone the repository:**

   ```bash
   git clone https://github.com/yourusername/library-management-system.git
   cd library-management-system
   
   ## API Documentation

### Base URL
The base URL for all API endpoints is:

### Endpoints

#### Books

##### 1. Get All Books
- **Endpoint**: `/books`
- **Method**: `GET`
- **Description**: Retrieve a list of all books.
- **Response**:
  - **Status Code**: `200 OK`
  - **Body**: 
    ```json
    [
      {
        "id": 1,
        "title": "Book Title",
        "author": "Author Name",
        "publisher": "Publisher Name",
        "publicationDate": "2023-01-01"
      },
      ...
    ]
    ```

##### 2. Get Book by ID
- **Endpoint**: `/books/{id}`
- **Method**: `GET`
- **Description**: Retrieve a book by its ID.
- **Parameters**:
  - `id` (path parameter): The ID of the book to retrieve.
- **Response**:
  - **Status Code**: `200 OK`
  - **Body**: 
    ```json
    {
      "id": 1,
      "title": "Book Title",
      "author": "Author Name",
      "publisher": "Publisher Name",
      "publicationDate": "2023-01-01"
    }
    ```
- **Error Response**:
  - **Status Code**: `404 Not Found`
  - **Body**: 
    ```json
    {
      "error": "Book not found"
    }
    ```

##### 3. Add a New Book
- **Endpoint**: `/books`
- **Method**: `POST`
- **Description**: Add a new book to the library.
- **Request Body**:
  - **Content-Type**: `application/json`
  - **Body**: 
    ```json
    {
      "title": "New Book Title",
      "authorId": 1,
      "publisherId": 1,
      "publicationDate": "2023-01-01"
    }
    ```
- **Response**:
  - **Status Code**: `201 Created`
  - **Body**: 
    ```json
    {
      "id": 2,
      "title": "New Book Title",
      "authorId": 1,
      "publisherId": 1,
      "publicationDate": "2023-01-01"
    }
    ```

##### 4. Update a Book
- **Endpoint**: `/books/{id}`
- **Method**: `PUT`
- **Description**: Update an existing book by its ID.
- **Parameters**:
  - `id` (path parameter): The ID of the book to update.
- **Request Body**:
  - **Content-Type**: `application/json`
  - **Body**: 
    ```json
    {
      "title": "Updated Book Title",
      "authorId": 1,
      "publisherId": 1,
      "publicationDate": "2023-01-01"
    }
    ```
- **Response**:
  - **Status Code**: `200 OK`
  - **Body**: 
    ```json
    {
      "id": 1,
      "title": "Updated Book Title",
      "authorId": 1,
      "publisherId": 1,
      "publicationDate": "2023-01-01"
    }
    ```

##### 5. Delete a Book
- **Endpoint**: `/books/{id}`
- **Method**: `DELETE`
- **Description**: Delete a book by its ID.
- **Parameters**:
  - `id` (path parameter): The ID of the book to delete.
- **Response**:
  - **Status Code**: `204 No Content`
  - **Body**: (empty)

#### Authors

##### 1. Get All Authors
- **Endpoint**: `/authors`
- **Method**: `GET`
- **Description**: Retrieve a list of all authors.
- **Response**:
  - **Status Code**: `200 OK`
  - **Body**: 
    ```json
    [
      {
        "id": 1,
        "name": "Author Name"
      },
      ...
    ]
    ```

##### 2. Get Author by ID
- **Endpoint**: `/authors/{id}`
- **Method**: `GET`
- **Description**: Retrieve an author by their ID.
- **Parameters**:
  - `id` (path parameter): The ID of the author to retrieve.
 - **Response**:
  - **Status Code**: `200 OK`
  - **Body**: 
    ```json
    {
      "id": 1,
      "name": "Author Name"
    }
    ```
- **Error Response**:
  - **Status Code**: `404 Not Found`
  - **Body**: 
    ```json
    {
      "error": "Author not found"
    }
    ```

##### 3. Add a New Author
- **Endpoint**: `/authors`
- **Method**: `POST`
- **Description**: Add a new author to the library.
- **Request Body**:
  - **Content-Type**: `application/json`
  - **Body**: 
    ```json
    {
      "name": "New Author Name"
    }
    ```
- **Response**:
  - **Status Code**: `201 Created`
  - **Body**: 
    ```json
    {
      "id": 2,
      "name": "New Author Name"
    }
    ```

##### 4. Update an Author
- **Endpoint**: `/authors/{id}`
- **Method**: `PUT`
- **Description**: Update an existing author by their ID.
- **Parameters**:
  - `id` (path parameter): The ID of the author to update.
- **Request Body**:
  - **Content-Type**: `application/json`
  - **Body**: 
    ```json
    {
      "name": "Updated Author Name"
    }
    ```
- **Response**:
  - **Status Code**: `200 OK`
  - **Body**: 
    ```json
    {
      "id": 1,
      "name": "Updated Author Name"
    }
    ```

##### 5. Delete an Author
- **Endpoint**: `/authors/{id}`
- **Method**: `DELETE`
- **Description**: Delete an author by their ID.
- **Parameters**:
  - `id` (path parameter): The ID of the author to delete.
- **Response**:
  - **Status Code**: `204 No Content`
  - **Body**: (empty)

#### Publishers

##### 1. Get All Publishers
- **Endpoint**: `/publishers`
- **Method**: `GET`
- **Description**: Retrieve a list of all publishers.
- **Response**:
  - **Status Code**: `200 OK`
  - **Body**: 
    ```json
    [
      {
        "id": 1,
        "name": "Publisher Name"
      },
      ...
    ]
    ```

##### 2. Get Publisher by ID
- **Endpoint**: `/publishers/{id}`
- **Method**: `GET`
- **Description**: Retrieve a publisher by their ID.
- **Parameters**:
  - `id` (path parameter): The ID of the publisher to retrieve.
- **Response**:
  - **Status Code**: `200 OK`
  - **Body**: 
    ```json
    {
      "id": 1,
      "name": "Publisher Name"
    }
    ```
- **Error Response**:
  - **Status Code**: `404 Not Found`
  - **Body**: 
    ```json
    {
      "error": "Publisher not found"
    }
    ```

##### 3. Add a New Publisher
- **Endpoint**: `/publishers`
- **Method**: `POST`
- **Description**: Add a new publisher to the library.
- **Request Body**:
  - **Content-Type**: `application/json`
  - **Body**: 
    ```json
    {
      "name": "New Publisher Name"
    }
    ```
- **Response**:
  - **Status Code**: `201 Created`
  - **Body**: 
    ```json
    {
      "id": 2,
      "name": "New Publisher Name"
    }
    ```

##### 4. Update a Publisher
- **Endpoint**: `/publishers/{id}`
- **Method**: `PUT`
- **Description**: Update an existing publisher by their ID.
- **Parameters**:
  - `id` (path parameter): The ID of the publisher to update.
- **Request Body**:
  - **Content-Type**: `application/json`
  - **Body**: 
    ```json
    {
      "name": "Updated Publisher Name"
    }
    ```
- **Response**:
  - **Status Code**: `200 OK`
  - **Body**: 
    ```json
    {
      "id": 1,
      "name": "Updated Publisher Name"
    }
    `` ##### 5. Delete a Publisher
- **Endpoint**: `/publishers/{id}`
- **Method**: `DELETE`
- **Description**: Delete a publisher by their ID.
- **Parameters**:
  - `id` (path parameter): The ID of the publisher to delete.
- **Response**:
  - **Status Code**: `204 No Content`
  - **Body**: (empty)

### Error Handling
For all endpoints, the API will return appropriate HTTP status codes and error messages in the response body for any errors encountered during the request processing. Common error responses include:

- **400 Bad Request**: The request was invalid or cannot be served.
- **401 Unauthorized**: Authentication is required and has failed or has not yet been provided.
- **403 Forbidden**: The request was valid, but the server is refusing action.
- **404 Not Found**: The requested resource could not be found.
- **500 Internal Server Error**: An error occurred on the server side.

### Conclusion-test-bhumika
This API documentation provides a comprehensive overview of the available endpoints for managing books, authors, and publishers in your Library Management System. Make sure to test each endpoint thoroughly to ensure they work as expected and provide the correct responses.