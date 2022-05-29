package com.caoc.challenge.domain.services;

import com.caoc.challenge.web.dto.GenreDTO;

import java.util.List;

public interface GenreService {
    List<GenreDTO> getAll();
    GenreDTO getById(Long id);
    GenreDTO create(GenreDTO characterDTO);
    GenreDTO update(GenreDTO characterDTO);
    void delete(Long id);
}
