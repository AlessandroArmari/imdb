package com.demo.imdb.controller;

import com.demo.imdb.DTO.DirectorDTO;
import com.demo.imdb.DTO.MovieDTO;
import com.demo.imdb.constant.APIConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

interface Icontroller<T> {


    Page<T> getAll(Map<String, String> params, Pageable pageable);

    T getById(Long id);
}