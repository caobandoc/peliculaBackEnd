package com.caoc.challenge.web.mapper;

import com.caoc.challenge.domain.entity.Movie;
import com.caoc.challenge.web.dto.MovieDTO;
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
            @Mapping(source="title", target="titulo"),
            @Mapping(source="creationDate", target="fechaCreacion"),
            @Mapping(source="rate", target="calificacion")

    })
    MovieDTO toMovieDTO(Movie movie);
    List<MovieDTO> toMoviesDTO(List<Movie> movie);

    @InheritInverseConfiguration
    Movie toMovie(MovieDTO movieDTO);
    List<Movie> toMovies(List<MovieDTO> movieDTOs);
}