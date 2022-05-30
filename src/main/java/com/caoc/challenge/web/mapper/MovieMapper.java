package com.caoc.challenge.web.mapper;

import com.caoc.challenge.domain.entity.Character;
import com.caoc.challenge.domain.entity.Genre;
import com.caoc.challenge.domain.entity.Movie;
import com.caoc.challenge.web.dto.CharacterDTO;
import com.caoc.challenge.web.dto.GenreDTO;
import com.caoc.challenge.web.dto.MovieDTO;
import com.caoc.challenge.web.dto.MovieParamDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    //Entity - DTO
    @Mappings({
            @Mapping(source="id", target="id"),
            @Mapping(source="image", target="imagen"),
            @Mapping(source="title", target="titulo"),
            @Mapping(source="creationDate", target="fechaCreacion"),
            @Mapping(source="rate", target="calificacion"),
            @Mapping(source="characters", target="personajes"),
            @Mapping(source="genres", target="generos")

    })
    MovieDTO movieToMovieDTO(Movie movie);
    List<MovieDTO> movieListToMovieDTOList(List<Movie> movieList);

    @InheritInverseConfiguration
    Movie movieDTOToMovie(MovieDTO movieDTO);
    List<Movie> movieDTOListToMovieList(List<MovieDTO> movieDTOList);

    @Mappings({
            @Mapping(source="id", target="id"),
            @Mapping(source="image", target="imagen"),
            @Mapping(source="name", target="nombre"),
            @Mapping(source="age", target="edad"),
            @Mapping(source="weight", target="peso"),
            @Mapping(source="history", target="historia")
    })
    CharacterDTO characterToCharacterDTO(Character character);
    @InheritInverseConfiguration
    Character characterDTOToCharacter(CharacterDTO characterDTO);

    @Mappings({
            @Mapping(source="id", target="id"),
            @Mapping(source="name", target="nombre"),
            @Mapping(source="image", target="imagen")
    })
    GenreDTO genreDTOToGenre(Genre genre);
    @InheritInverseConfiguration
    Genre genreToGenreDTO(GenreDTO genreDTO);


    @Mappings({
            @Mapping(source="image", target="imagen"),
            @Mapping(source="title", target="titulo"),
            @Mapping(source="creationDate", target="fechaCreacion")
    })
    MovieParamDTO movieToMovieParamDTO(Movie movie);
    List<MovieParamDTO> movieListToMovieParamDTO(List<Movie> movieList);
}