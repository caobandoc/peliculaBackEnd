package com.caoc.challenge.web.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CharacterDTO {
    private Long id;
    private String imagen;
    private String nombre;
    private Integer edad;
    private String historia;

}
