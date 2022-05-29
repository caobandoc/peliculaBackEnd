package com.caoc.challenge.domain.services;

import com.caoc.challenge.web.dto.CharacterDTO;

import java.util.List;
import java.util.Optional;

public interface CharacterService {
    List<CharacterDTO> getAll();
    Optional<CharacterDTO> getById(Long id);
    CharacterDTO create(CharacterDTO characterDTO);
    CharacterDTO update(CharacterDTO characterDTO);
    void delete(Long id);
}
