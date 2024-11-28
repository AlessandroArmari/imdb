package com.demo.imdb.mapper;

import com.demo.imdb.DTO.DirectorDTO;
import com.demo.imdb.entity.Director;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ObjectTransformer {

    private final ModelMapper modelMapper;

    public DirectorDTO toDTO(Director directorDAO) {
        modelMapper.typeMap(Director.class, DirectorDTO.class).addMappings(mapper -> {
            mapper.map(src -> src.getCountry().getName(), DirectorDTO::setCountry);
        });

        return modelMapper.map(directorDAO, DirectorDTO.class);

    }
}
