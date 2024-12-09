package com.demo.imdb.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DirectorDTO {

    @NotBlank
    @NotNull(message = "firstName may not be null")
    private String firstName;

    @NotBlank
    @NotNull(message = "lastName may not be null")
    private String lastName;

    @NotBlank
    @NotNull(message = "dob may not be null")
    private String dob;

    @NotBlank
    @NotNull(message = "country may not be null")
    private String country;

}
