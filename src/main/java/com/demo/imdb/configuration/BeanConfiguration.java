package com.demo.imdb.configuration;

import com.demo.imdb.DTO.DirectorDTO;
import com.demo.imdb.entity.Director;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@Configuration
public class BeanConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        //Directort DAO -> DirectorDTO
        TypeMap<Director, DirectorDTO> typeMap = modelMapper.createTypeMap(Director.class, DirectorDTO.class);
        typeMap.addMappings(mapper -> {
            mapper.map(src -> Objects.nonNull(src.getName()) ? src.getName().split("_")[0] : null, DirectorDTO::setFirstName);
            mapper.map(src -> Objects.nonNull(src.getName()) ? src.getName().split("_")[1] : null, DirectorDTO::setLastName);
            mapper.map(src -> src.getCountry().getName(), DirectorDTO::setCountry);
        });


        return modelMapper;

    }


}
