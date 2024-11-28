package com.demo.imdb.controller;

import com.demo.imdb.DTO.DirectorDTO;
import com.demo.imdb.constant.APIConstants;
import com.demo.imdb.mapper.ObjectTransformer;
import com.demo.imdb.repository.DirectorRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(APIConstants.URL_START)
@AllArgsConstructor
public class DirectorController {

    private final ObjectTransformer objectTransformer;
    private final DirectorRepository directorRepository;

    @GetMapping(APIConstants.DIRECTOR+APIConstants.ALL)
    public Page<DirectorDTO> getAll() {

        return null;
    }

    @GetMapping(APIConstants.DIRECTOR+APIConstants.ID)
    public DirectorDTO getById(@RequestParam Long id) {

        return objectTransformer.toDTO(directorRepository.findById(id).get());
    }

}
