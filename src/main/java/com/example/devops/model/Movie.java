package com.example.devops.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * The Movie class represents a movie entity in the system.
 * This class is annotated as an Entity, meaning it is mapped to a table in a relational database.
 * Lombok annotations are used to reduce boilerplate code, automatically generating
 * constructors, getters, setters, and other utility methods.
 */
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Movie {

    /**
     * The unique identifier for each movie.
     * This field is annotated with @Id, indicating that it serves as the primary key in the database.
     */
    @Id
    private Integer id;

    /**
     * The name of the movie.
     * This field is annotated with @Column to map it to the "name" column in the database.
     */
    @Column(name= "name")
    private String name;

    /**
     * The category or genre of the movie (e.g., drama, action, comedy).
     * This field is mapped to the "category" column in the database.
     */
    @Column(name= "category")
    private String category;

    /**
     * The release year of the movie.
     * This field is mapped to the "year" column in the database.
     */
    @Column(name = "year")
    private int year;

    /**
     * The director of the movie.
     * This field is mapped to the "director" column in the database.
     */
    @Column(name = "director")
    private String director;

    /**
     * The duration of the movie, typically represented in hours and minutes (e.g., "2h 30m").
     * This field is mapped to the "duration" column in the database.
     */
    @Column(name = "duration")
    private String duration;

    /**
     * The rating (rating) of the movie, which is a numeric value (e.g., 7.5).
     * This field is mapped to the "rating" column in the database.
     */
    @Column(name = "rating")
    private double rating;

}
