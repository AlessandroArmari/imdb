package com.demo.imdb.mapper;

import com.demo.imdb.DTO.DirectorDTO;
import com.demo.imdb.constant.UtilConstants;
import com.demo.imdb.entity.Director;
import lombok.AllArgsConstructor;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class ObjectTransformer {

    private final ModelMapper modelMapper;

    public DirectorDTO toDTO(Director directorDAO) {

        modelMapper.addConverter(fromUsaToEuFormat);
        modelMapper.typeMap(Director.class, DirectorDTO.class)
                .addMappings(mapper -> mapper.map(src -> src.getCountry().getName(), DirectorDTO::setCountry));

        return modelMapper.map(directorDAO, DirectorDTO.class);
    }

    public Director toDAO(DirectorDTO directorDTO) {

        modelMapper.addConverter(fromEuToUsaFormat);
        //modelMapper.typeMap(DirectorDTO.class, Director.class)
        //        .addMappings(mapper -> mapper.map(DirectorDTO::getCountry, (director, o) -> director.getCountry().setName(o)));

        return modelMapper.map(directorDTO, Director.class);
    }

    //Converter
    private final Converter<LocalDate, String> fromUsaToEuFormat = new AbstractConverter<>() {
        @Override
        protected String convert(LocalDate usaDate) {
            return usaDate.format(UtilConstants.formatterEU);
        }
    };

    private final Converter<String, LocalDate> fromEuToUsaFormat = new AbstractConverter<>() {

        @Override
        protected LocalDate convert(String euDate) {
            return LocalDate.parse(euDate, UtilConstants.formatterEU);
        }

    };

}
