package com.example.devops.controller;

import com.example.devops.model.Movie;
import com.example.devops.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/peliculas")
public class MovieController {

    @Autowired
    private IMovieService movieService;

    /**
     * Health check endpoint to verify service status.
     *
     * @return a string indicating the service is running fine.
     */
    @RequestMapping(value = "/healthcheck")
    public String healthCheck(){
        return "Service status fine!!";
    }

    /**
     * Retrieves a list of all movies in the system.
     *
     * @return A List containing all Movie objects stored in the database.
     */
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        try {
            List<Movie> movies = movieService.getMovies();
            if(movies.isEmpty()){
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
            return ResponseEntity.ok(movies);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Get a movie by its ID.
     *
     * @param movieId The ID of the movie to retrieve.
     * @return A ResponseEntity containing the movie details or an error message if the movie is not found.
     */
    @GetMapping("/{movieId}")
    public ResponseEntity<?> getMovies(@PathVariable Integer movieId){
        try {
            Movie movie = movieService.getMovie(movieId);
            if(movie == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            return ResponseEntity.ok(movie);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * Add a new movie.
     *
     * @param movie The movie object to be added.
     * @return A ResponseEntity with the newly created movie and a status of 201 (Created) or an error status.
     */
    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie){
        try {
            Movie newMovie = movieService.addMovie(movie);
            return new ResponseEntity<>(newMovie, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    /**
     * Update an existing movie.
     *
     * @param movieId The ID of the movie to update.
     * @param movie The movie object containing the updated data.
     * @return A ResponseEntity with the updated movie or an error status if the update fails.
     */
    @PutMapping("/{movieId}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Integer movieId, @RequestBody Movie movie){
        Movie updatedMovie = movieService.updateMovie(movieId, movie);
        return ResponseEntity.ok(updatedMovie);
    }

    /**
     * Delete a movie by its ID.
     *
     * @param movieId The ID of the movie to delete.
     * @return A ResponseEntity indicating the success of the deletion or a 404 status if the movie is not found.
     */
    @DeleteMapping("/{movieId}")
    public ResponseEntity<Movie> deleteMovie(@PathVariable Integer movieId){
        boolean deleted = movieService.deleteMovie(movieId);
        if(deleted){
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}