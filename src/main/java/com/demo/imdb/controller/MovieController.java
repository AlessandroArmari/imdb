package com.demo.imdb.controller;

import com.demo.imdb.constant.APIConstants;
import com.demo.imdb.entity.Movie;
import com.demo.imdb.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(APIConstants.API)
@AllArgsConstructor
public class MovieController {

    private MovieRepository movieRepository;

    @GetMapping(APIConstants.MOVIE)
    public List<Movie> getAll() {

        return movieRepository.findAll();
    }

}
