package com.demo.imdb.controller;

import com.demo.imdb.DTO.DirectorDTO;
import com.demo.imdb.constant.WebConstants;
import com.demo.imdb.entity.Director;
import com.demo.imdb.repository.DirectorRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(WebConstants.URL_START)
@AllArgsConstructor
public class DirectorController {

    private final ModelMapper modelMapper;
    private DirectorRepository directorRepository;

    @GetMapping(WebConstants.DIRECTOR)
    public DirectorDTO getOne() {

        Director d = directorRepository.findAll().stream().findFirst().get();
        return modelMapper.map(d, DirectorDTO.class);
    }

}
