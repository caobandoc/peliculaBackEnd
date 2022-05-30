package com.caoc.challenge.domain.services;

import com.caoc.challenge.web.dto.MovieDTO;
import com.caoc.challenge.web.dto.MovieParamDTO;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<MovieDTO> getAll();
    Optional<MovieDTO> getById(Long id);
    MovieDTO create(MovieDTO movieDTO);
    Optional<MovieDTO> update(MovieDTO movieDTO);
    void delete(Long id);

    List<MovieParamDTO> getByParameters(String name, Long genre, String order);
}
