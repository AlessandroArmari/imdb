package com.demo.imdb.service;

import com.demo.imdb.DTO.DirectorDTO;
import com.demo.imdb.entity.Director;
import com.demo.imdb.mapper.ObjectTransformer;
import com.demo.imdb.repository.DirectorRepository;
import com.demo.imdb.util.ErrorMessageBuilder;
import com.demo.imdb.util.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DirectorService {

    private final ObjectTransformer objectTransformer;
    private final DirectorRepository directorRepository;

    public DirectorDTO getById(Long id) {

        return objectTransformer.toDTO(directorRepository.findById(id).orElseThrow(() -> new NotFoundException(ErrorMessageBuilder.notFoundById(Director.class, id))));
    }
}
