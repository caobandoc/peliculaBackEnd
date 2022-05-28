package com.caoc.challenge.domain.services;

import com.caoc.challenge.web.dto.CharacterDTO;

import java.util.List;

public interface CharacterService {
    List<CharacterDTO> getAll();
    CharacterDTO create(CharacterDTO characterDTO);
    CharacterDTO update(CharacterDTO characterDTO);
    void delete(CharacterDTO characterDTO);
}
