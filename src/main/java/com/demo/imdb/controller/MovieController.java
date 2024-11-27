package com.demo.imdb.controller;

import com.demo.imdb.constant.WebConstants;
import com.demo.imdb.entity.Movie;
import com.demo.imdb.repository.MovieRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(WebConstants.URL_START)
@AllArgsConstructor
public class MovieController {

    private MovieRepository movieRepository;

    @GetMapping("/")
    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

}
