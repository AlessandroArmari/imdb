package com.demo.imdb.controller;

import com.demo.imdb.DTO.DirectorDTO;
import com.demo.imdb.constant.APIConstants;
import com.demo.imdb.service.DirectorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
public class DirectorController implements Icontroller<DirectorDTO> {

    private final String endpoint = APIConstants.API + APIConstants.DIRECTOR;
    private final DirectorService directorService;

    @Override
    @PostMapping(endpoint+APIConstants.SAVE)
    public DirectorDTO save(@Valid @RequestBody DirectorDTO directorDTO) {
        return directorService.save(directorDTO);
    }

    @Override
    @GetMapping(endpoint+APIConstants.ALL)
    public Page<DirectorDTO> getAll(Map<String, String> params, Pageable pageable) {
        return directorService.getAll(null ,pageable);
    }

    @Override
    @GetMapping(endpoint+APIConstants.ID)
    public DirectorDTO getById(@RequestParam Long id) {
        return directorService.getById(id);
    }

}
