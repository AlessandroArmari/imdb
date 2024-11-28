package com.demo.imdb.controller;

import com.demo.imdb.DTO.DirectorDTO;
import com.demo.imdb.constant.APIConstants;
import com.demo.imdb.mapper.ObjectTransformer;
import com.demo.imdb.repository.DirectorRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class DirectorController implements Icontroller<DirectorDTO> {


    private final ObjectTransformer objectTransformer;
    private final DirectorRepository directorRepository;
    private final String endpoint = APIConstants.API + APIConstants.DIRECTOR;


    @Override
    @RequestMapping(endpoint+APIConstants.ALL)
    public Page<DirectorDTO> getAll() {
        return null;
    }

    @Override
    @RequestMapping(endpoint+APIConstants.ID)
    public DirectorDTO getById(@RequestParam Long id) {
        return objectTransformer.toDTO(directorRepository.findById(id).orElseThrow(RuntimeException::new));
    }

}
