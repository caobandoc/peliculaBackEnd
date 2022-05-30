package com.caoc.challenge.web.mapper;

import com.caoc.challenge.domain.entity.Movie;
import com.caoc.challenge.web.dto.CharacterDTO;
import com.caoc.challenge.domain.entity.Character;
import com.caoc.challenge.web.dto.CharacterParamDTO;
import com.caoc.challenge.web.dto.MovieDTO;
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

    @Mappings({
            @Mapping(source="id", target="id"),
            @Mapping(source="image", target="imagen"),
            @Mapping(source="title", target="titulo"),
            @Mapping(source="creationDate", target="fechaCreacion"),
            @Mapping(source="rate", target="calificacion")

    })
    MovieDTO movieToMovieDTO(Movie movie);
    List<MovieDTO> movieListToMovieDTOList(List<Movie> movieList);

    @InheritInverseConfiguration
    Movie movieDTOToMovie(MovieDTO movieDTO);
    List<Movie> movieDTOListToMovieList(List<MovieDTO> movieDTOList);
}
