package com.example.restapipractice.practice1.controller;

import com.example.restapipractice.practice1.domain.Movie;
import com.example.restapipractice.practice1.service.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie/v1")
public class MovieController {
    private MovieServiceImpl movieServiceImpl;

    @Autowired
    public MovieController(MovieServiceImpl movieServiceImpl){
        this.movieServiceImpl = movieServiceImpl;
    }

    @PostMapping(value = "/movie")
    public ResponseEntity<?> save(@RequestBody Movie movie){
        Movie movie1 = movieServiceImpl.add(movie);
        return new ResponseEntity<>(movie1, HttpStatus.CREATED);
    }

}
