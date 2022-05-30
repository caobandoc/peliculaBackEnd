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
    CharacterDTO characterToCharacterDTO(Character character);
    List<CharacterDTO> characterListToCharacterDTOList(List<Character> characterList);

    @InheritInverseConfiguration
    Character characterToCharacterDTO(CharacterDTO characterDTO);
    List<Character> characterDTOListToCharacterList(List<CharacterDTO> characterDTOList);

    @Mappings({
            @Mapping(source="image", target="imagen"),
            @Mapping(source="name", target="nombre")
    })
    CharacterParamDTO characterToCharacterParamDTO(Character character);
    List<CharacterParamDTO> characterListToCharacterParamDTO(List<Character> characterList);

}
