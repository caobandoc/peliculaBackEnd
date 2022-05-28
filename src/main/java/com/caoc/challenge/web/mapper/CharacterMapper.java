package com.caoc.challenge.web.mapper;

import com.caoc.challenge.web.dto.CharacterDTO;
import com.caoc.challenge.domain.entity.Character;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CharacterMapper {
    //Entity - DTO
    @Mappings({
            @Mapping(source="id", target="id"),
            @Mapping(source="image", target="imagen"),
            @Mapping(source="name", target="nombre"),
            @Mapping(source="age", target="edad"),
            @Mapping(source="history", target="historia")
    })
    CharacterDTO toCharacterDTO(Character character);
    List<CharacterDTO> toCharactersDTO(List<Character> characters);

    @InheritInverseConfiguration
    Character toCharacter(CharacterDTO characterDTO);
    List<Character> toCharacters(List<CharacterDTO> characterDTOs);
}
