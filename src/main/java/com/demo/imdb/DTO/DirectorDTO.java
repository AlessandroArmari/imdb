package com.demo.imdb.DTO;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DirectorDTO {

    private String firstName;

    private String lastName;

    private String dob;

    private String country;


}
