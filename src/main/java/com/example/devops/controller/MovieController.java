package com.example.devops.controller;

import com.example.devops.model.Movie;
import com.example.devops.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/peliculas")
public class MovieController {

    @Autowired
    private IMovieService movieService;

    @RequestMapping(value = "/healthcheck")
    public String healthCheck(){
        return "Service status fine!!";
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<?> getMovies(@PathVariable int idMovie){
        try {
            List<Movie> movie = (List<Movie>) movieService.getMovie(idMovie);
            return ResponseEntity.ok(movie);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
