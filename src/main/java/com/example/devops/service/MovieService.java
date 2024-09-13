package com.example.devops.service;

import com.example.devops.model.Movie;
import com.example.devops.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * MovieService is a service class that provides business logic for managing Movie entities.
 * It implements the IMovieService interface and uses MovieRepository to interact with the database.
 * The class is annotated with @Service to denote that it is a Spring service component.
 * Lombok's @RequiredArgsConstructor generates a constructor with required arguments (final fields).
 */
@Service
@RequiredArgsConstructor
public class MovieService implements IMovieService {

    /**
     * The repository used to perform CRUD operations on Movie entities.
     * It is injected via the constructor by Lombok's @RequiredArgsConstructor.
     */
    @Autowired
    private final MovieRepository movieRepository;

    /**
     * Adds a new movie to the system.
     *
     * @param movie The Movie object containing the details of the movie to be added.
     * @return The added Movie object, saved in the database.
     */
    @Override
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    /**
     * Updates an existing movie in the system.
     *
     * @param idMovie The ID of the movie to be updated.
     * @param movie The Movie object containing the updated movie details.
     * @return The updated Movie object if the movie exists, or null if the movie was not found.
     */
    @Override
    public Movie updateMovie(int idMovie, Movie movie) {
        Optional<Movie> existingMovie = movieRepository.findById(idMovie);
        if (existingMovie.isPresent()) {
            Movie movieToUpdate = existingMovie.get();
            movieToUpdate.setName(movie.getName());
            movieToUpdate.setCategory(movie.getCategory());
            movieToUpdate.setYear(movie.getYear());
            movieToUpdate.setDirector(movie.getDirector());
            movieToUpdate.setDuration(movie.getDuration());
            movieToUpdate.setRating(movie.getRating()); // Updated field name to 'rating'
            return movieRepository.save(movieToUpdate);
        }
        return null;
    }

    /**
     * Deletes a movie from the system based on the provided ID.
     *
     * @param idMovie The ID of the movie to be deleted.
     * @return A boolean value indicating whether the deletion was successful (true if deleted, false if not found).
     */
    @Override
    public boolean deleteMovie(int idMovie) {
        if (movieRepository.existsById(idMovie)) {
            movieRepository.deleteById(idMovie);
            return true;
        }
        return false;
    }

    /**
     * Retrieves a list of all movies in the system.
     *
     * @return A List containing all Movie objects stored in the database.
     */
    @Override
    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    /**
     * Retrieves a specific movie by its ID.
     *
     * @param idMovie The ID of the movie to retrieve.
     * @return The Movie object corresponding to the provided ID, or null if not found.
     */
    @Override
    public Movie getMovie(int idMovie) {
        return movieRepository.findById(idMovie).orElse(null);
    }
}