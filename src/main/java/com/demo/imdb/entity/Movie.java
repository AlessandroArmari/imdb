package com.demo.imdb.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Movie implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "dor", nullable = false)
    private LocalDate dor;

    @Column(name= "running_time", nullable = false)
    private Integer runningTime;

    @ManyToOne(fetch = FetchType.EAGER)
    private Director director;

    @ManyToOne(fetch = FetchType.EAGER)
    private Country country;


}
