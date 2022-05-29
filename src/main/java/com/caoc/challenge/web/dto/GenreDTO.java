package com.caoc.challenge.web.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GenreDTO {
    private Long id;
    private String nombre;
    private String imagen;
    //private List<MovieDTO> peliculas;
}
