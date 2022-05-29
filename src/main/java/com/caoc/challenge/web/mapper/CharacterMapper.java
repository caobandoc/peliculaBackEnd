package com.caoc.challenge.web.mapper;

import com.caoc.challenge.web.dto.CharacterDTO;
import com.caoc.challenge.domain.entity.Character;
import com.caoc.challenge.web.dto.CharacterParamDTO;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {MovieMapper.class})
public interface CharacterMapper {
    //Entity - DTO
    @Mappings({
            @Mapping(source="id", target="id"),
            @Mapping(source="image", target="imagen"),
            @Mapping(source="name", target="nombre"),
            @Mapping(source="age", target="edad"),
            @Mapping(source="weight", target="peso"),
            @Mapping(source="history", target="historia"),
            @Mapping(source="movies", target="peliculas")
    })
    CharacterDTO toCharacterDTO(Character character);
    List<CharacterDTO> toCharactersDTO(List<Character> characters);

    @InheritInverseConfiguration
    Character toCharacter(CharacterDTO characterDTO);
    List<Character> toCharacters(List<CharacterDTO> characterDTOs);

    @Mappings({
            @Mapping(source="image", target="imagen"),
            @Mapping(source="name", target="nombre")
    })
    CharacterParamDTO toCharacterParamDTO(Character character);
    List<CharacterParamDTO> toCharactersParamDTO(List<Character> characters);

}
