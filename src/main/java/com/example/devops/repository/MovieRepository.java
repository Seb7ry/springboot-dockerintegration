package com.example.devops.repository;

import com.example.devops.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * MovieRepository is an interface that extends JpaRepository and JpaSpecificationExecutor
 * to provide CRUD operations and specification-based queries for Movie entities.
 *
 * - JpaRepository provides basic CRUD functionality.
 * - JpaSpecificationExecutor allows more complex queries using specifications.
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer>, JpaSpecificationExecutor<Movie> {

    /**
     * Finds a specific movie by its ID.
     *
     * @param idMovie The ID of the movie to be found.
     * @return An Optional containing the Movie object if found, or empty if not.
     */
    Optional<Movie> findById(Integer idMovie);

    /**
     * Finds all the movies.
     *
     * @return A List containing the Movies objects if found, or empty if not.
     */
    List<Movie> findAll();
}
