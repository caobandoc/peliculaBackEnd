package com.caoc.challenge.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenreDTO {
    private Long id;
    private String nombre;
    private String imagen;
    //private List<MovieDTO> peliculas;
}
