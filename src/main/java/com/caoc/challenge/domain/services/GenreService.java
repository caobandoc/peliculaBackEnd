package com.caoc.challenge.domain.services;

import com.caoc.challenge.web.dto.GenreDTO;

import java.util.List;
import java.util.Optional;

public interface GenreService {
    List<GenreDTO> getAll();
    Optional<GenreDTO> getById(Long id);
    GenreDTO create(GenreDTO characterDTO);
    GenreDTO update(GenreDTO characterDTO);
    void delete(Long id);
}
