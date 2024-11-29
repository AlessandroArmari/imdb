package com.demo.imdb.service;

import com.demo.imdb.DTO.DirectorDTO;
import com.demo.imdb.entity.Director;
import com.demo.imdb.mapper.ObjectTransformer;
import com.demo.imdb.repository.DirectorRepository;
import com.demo.imdb.util.ErrorMessageBuilder;
import com.demo.imdb.util.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@AllArgsConstructor
public class DirectorService {

    private final ObjectTransformer objectTransformer;
    private final DirectorRepository directorRepository;

    public Page<DirectorDTO> getAll(Map<String, String> params, Pageable pageable) {
        return directorRepository.findAll(pageable)
                .map(objectTransformer::toDTO);
    }

    public DirectorDTO getById(Long id) {
        return objectTransformer.toDTO(directorRepository.findById(id)
                .orElseThrow(() -> NotFoundException.builder()
                        .message(ErrorMessageBuilder.notFoundById(Director.class, id))
                        .build()));
    }


}
