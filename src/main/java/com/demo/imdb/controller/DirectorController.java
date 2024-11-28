package com.demo.imdb.controller;

import com.demo.imdb.DTO.DirectorDTO;
import com.demo.imdb.constant.WebConstants;
import com.demo.imdb.entity.Director;
import com.demo.imdb.mapper.ObjectTransformer;
import com.demo.imdb.repository.DirectorRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(WebConstants.URL_START)
@AllArgsConstructor
public class DirectorController {

    private final ObjectTransformer objectTransformer;
    private final DirectorRepository directorRepository;

    @GetMapping(WebConstants.DIRECTOR+"/all")
    public Page<DirectorDTO> getAll() {

        return null;
    }

    @GetMapping(WebConstants.DIRECTOR+"/id")
    public DirectorDTO getById(@RequestParam Long id) {

        return objectTransformer.toDTO(directorRepository.findById(id).get());
    }

}
