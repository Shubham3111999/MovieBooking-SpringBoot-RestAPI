# Movie Booking API

This API provides operations to manage movies in a movie booking system using Spring Boot.

## Base URL

All endpoints are relative to the base URL: `/ticket`

## Endpoints

### 1. Get List of Movies

- **Endpoint:** `GET /ticket/movies`
- **Description:** Retrieves a list of all movies.
- **Response:**
  - `200 OK` - Returns a list of movies in JSON format.
  
### 2. Add Movie to List

- **Endpoint:** `POST /ticket/movie`
- **Description:** Adds a new movie to the list.
- **Request Body:**
  ```json
  {
    "movieName": "The Great Adventure",
    "movieDirector": "John Doe",
    "movieRating": 8,
    "movieLanguage": "English",
    "writers": [
    "Jane Smith",
    "Robert Brown"
    ],
    "actors": [
    "Alice Johnson",
    "Michael Lee"
    ],
    "genre": [
    "Adventure",
    "Action"
    ]
  }

### 3. Get Movie By ID

- **Endpoint:** `GET /ticket/movie/{id}`
- **Description:** Get movie by id
- **Response:**
  - `200 OK` - Returns movie in JSON format.

### 4. Update Movie By ID

- **Endpoint:** `PUT /ticket/update/{id}`
- **Description:** Update movie by id

### 5. Delete Movie By ID

- **Endpoint:** `DELETE /ticket/movie/{id}`
- **Description:** Get movie by id
  

