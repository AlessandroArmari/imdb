package com.demo.imdb.repository;

import com.demo.imdb.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long> {
}
