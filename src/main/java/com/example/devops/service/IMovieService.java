package com.example.devops.service;

import com.example.devops.model.Movie;

import java.util.List;

/**
 * IMovieService is an interface that defines the operations
 * related to managing Movie entities.
 * These operations include adding, updating, deleting, and retrieving movies.
 */
public interface IMovieService {

    /**
     * Adds a new movie to the system.
     *
     * @param movie The Movie object containing the details of the movie to be added.
     * @return The added Movie object.
     */
    Movie addMovie(Movie movie);

    /**
     * Updates an existing movie in the system.
     *
     * @param idMovie The ID of the movie to be updated.
     * @param movie The Movie object containing the updated movie details.
     * @return The updated Movie object.
     */
    Movie updateMovie(int idMovie, Movie movie);

    /**
     * Deletes a movie from the system based on the provided ID.
     *
     * @param idMovie The ID of the movie to be deleted.
     * @return A boolean value indicating whether the deletion was successful.
     */
    boolean deleteMovie(int idMovie);

    /**
     * Retrieves a list of all movies in the system.
     *
     * @return A List containing all Movie objects.
     */
    List<Movie> getMovies();

    /**
     * Retrieves a specific movie by its ID.
     *
     * @param idMovie The ID of the movie to retrieve.
     * @return The Movie object corresponding to the provided ID.
     */
    Movie getMovie(int idMovie);
}

