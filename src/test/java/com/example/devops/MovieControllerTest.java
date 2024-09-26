package com.example.devops;

import com.example.devops.controller.MovieController;
import com.example.devops.model.Movie;
import com.example.devops.service.IMovieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Unit tests for the MovieController class.
 * This class uses JUnit and Mockito to test the behavior of the MovieController methods
 * by mocking the IMovieService interface. Each test case isolates and validates
 * the functionality of individual controller methods.
 */
public class MovieControllerTest {

    // Mock object for IMovieService, which will simulate the service behavior.
    @Mock
    private IMovieService movieService;

    // The MovieController instance with injected mock service.
    @InjectMocks
    private MovieController movieController;

    /**
     * Sets up the test environment before each test by initializing the mock objects.
     * This is achieved using the openMocks method from MockitoAnnotations.
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);  // Initializes the mock objects before each test.
    }

    /**
     * Tests the healthCheck() method in MovieController.
     * This test ensures that the health check endpoint returns the expected string response.
     */
    @Test
    void testHealthCheck() {
        String result = movieController.healthCheck();
        assertEquals("Service status fine!!", result);  // Asserts that the response matches the expected output.
    }

    /**
     * Tests the getAllMovies() method in MovieController.
     * This test verifies that the method returns a list of movies when they are present
     * and that the status code is 200 (OK).
     */
    @Test
    void testGetAllMoviesReturnsList() {
        // Creates a sample list of Movie objects.
        List<Movie> movies = List.of(
                new Movie(1, "Inception", "Sci-Fi", 2010, "Christopher Nolan", "2h 28m", 8.8)
        );
        when(movieService.getMovies()).thenReturn(movies);  // Mocks the service response.

        // Calls the controller method and asserts the response.
        ResponseEntity<List<Movie>> response = movieController.getAllMovies();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, Objects.requireNonNull(response.getBody()).size());  // Asserts the size of the returned list.
        assertEquals("Inception", response.getBody().get(0).getName());  // Asserts the content of the response.
    }

    /**
     * Tests the getAllMovies() method in MovieController when no movies are available.
     * This test verifies that the method returns a 204 (No Content) status when the movie list is empty.
     */
    @Test
    void testGetAllMoviesReturnsNoContent() {
        when(movieService.getMovies()).thenReturn(Collections.emptyList());  // Mocks an empty list response.

        // Calls the controller method and asserts the response.
        ResponseEntity<List<Movie>> response = movieController.getAllMovies();
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());  // Asserts the 204 No Content status.
    }

    /**
     * Tests the getMovies() method in MovieController.
     * This test verifies that the method returns the correct movie when found
     * and that the status code is 200 (OK).
     */
    @Test
    void testGetMovieReturnsMovie() {
        Movie movie = new Movie(1, "Interstellar", "Sci-Fi", 2014, "Christopher Nolan", "2h 49m", 8.6);
        when(movieService.getMovie(1)).thenReturn(movie);  // Mocks the service response.

        // Calls the controller method and asserts the response.
        ResponseEntity<?> response = movieController.getMovies(1);
        assertEquals(HttpStatus.OK, response.getStatusCode());  // Asserts the 200 OK status.
        assertEquals(movie, response.getBody());  // Asserts that the returned movie matches the expected object.
        assertEquals("Interstellar", ((Movie) Objects.requireNonNull(response.getBody())).getName());  // Asserts movie details.
    }

    /**
     * Tests the getMovies() method in MovieController when the movie is not found.
     * This test verifies that the method returns a 404 (Not Found) status.
     */
    @Test
    void testGetMovieReturnsNotFound() {
        when(movieService.getMovie(1)).thenReturn(null);  // Mocks a null response indicating no movie found.

        // Calls the controller method and asserts the response.
        ResponseEntity<?> response = movieController.getMovies(1);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());  // Asserts the 404 Not Found status.
    }

    /**
     * Tests the addMovie() method in MovieController.
     * This test verifies that a new movie is successfully added and that the status code is 201 (Created).
     */
    @Test
    void testAddMovieReturnsCreated() {
        Movie movie = new Movie(2, "The Dark Knight", "Action", 2008, "Christopher Nolan", "2h 32m", 9.0);
        when(movieService.addMovie(any(Movie.class))).thenReturn(movie);  // Mocks the service response.

        // Calls the controller method and asserts the response.
        ResponseEntity<Movie> response = movieController.addMovie(movie);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());  // Asserts the 201 Created status.
        assertEquals(movie, response.getBody());  // Asserts that the returned movie matches the expected object.
        assertEquals("The Dark Knight", Objects.requireNonNull(response.getBody()).getName());  // Asserts movie details.
    }

    /**
     * Tests the addMovie() method in MovieController when an invalid request is made.
     * This test verifies that the method returns a 400 (Bad Request) status for invalid input.
     */
    @Test
    void testAddMovieReturnsBadRequest() {
        when(movieService.addMovie(any(Movie.class))).thenThrow(IllegalArgumentException.class);  // Mocks an exception.

        // Calls the controller method and asserts the response.
        ResponseEntity<Movie> response = movieController.addMovie(new Movie());
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());  // Asserts the 400 Bad Request status.
    }

    /**
     * Tests the updateMovie() method in MovieController.
     * This test verifies that an existing movie is successfully updated and that the status code is 200 (OK).
     */
    @Test
    void testUpdateMovieReturnsOk() {
        Movie movie = new Movie(1, "Dunkirk", "War", 2017, "Christopher Nolan", "1h 46m", 7.9);
        when(movieService.updateMovie(anyInt(), any(Movie.class))).thenReturn(movie);  // Mocks the service response.

        // Calls the controller method and asserts the response.
        ResponseEntity<Movie> response = movieController.updateMovie(1, movie);
        assertEquals(HttpStatus.OK, response.getStatusCode());  // Asserts the 200 OK status.
        assertEquals(movie, response.getBody());  // Asserts that the returned movie matches the updated object.
        assertEquals("Dunkirk", Objects.requireNonNull(response.getBody()).getName());  // Asserts movie details.
    }

    /**
     * Tests the deleteMovie() method in MovieController.
     * This test verifies that a movie is successfully deleted and that the status code is 200 (OK).
     */
    @Test
    void testDeleteMovieReturnsOk() {
        when(movieService.deleteMovie(1)).thenReturn(true);  // Mocks a successful deletion response.

        // Calls the controller method and asserts the response.
        ResponseEntity<Movie> response = movieController.deleteMovie(1);
        assertEquals(HttpStatus.OK, response.getStatusCode());  // Asserts the 200 OK status.
    }

    /**
     * Tests the deleteMovie() method in MovieController when the movie is not found.
     * This test verifies that the method returns a 404 (Not Found) status when the movie doesn't exist.
     */
    @Test
    void testDeleteMovieReturnsNotFound() {
        when(movieService.deleteMovie(1)).thenReturn(false);  // Mocks a failed deletion response.

        // Calls the controller method and asserts the response.
        ResponseEntity<Movie> response = movieController.deleteMovie(1);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());  // Asserts the 404 Not Found status.
    }
}
