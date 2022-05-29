package com.caoc.challenge.web.mapper;

import com.caoc.challenge.domain.entity.Genre;
import com.caoc.challenge.web.dto.GenreDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
@Mapper(componentModel = "spring")
public interface GenreMapper {
    //Entity - DTO
    @Mappings({
            @Mapping(source="id", target="id"),
            @Mapping(source="name", target="nombre"),
            @Mapping(source="image", target="imagen")

    })
    GenreDTO toGenreDTO(Genre genre);
    List<GenreDTO> toGenresDTO(List<Genre> genres);

    @InheritInverseConfiguration
    Genre toGenre(GenreDTO genreDTO);
    List<Genre> toGenres(List<GenreDTO> genreDTOs);
}
