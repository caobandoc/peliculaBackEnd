package com.caoc.challenge.web.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {
    private Long id;
    private String titulo;
    private Date fechaCreacion;
    private Integer calificacion;
    //private List<CharacterDTO> personajes;

}
