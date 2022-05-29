package com.caoc.challenge.domain.services;

import com.caoc.challenge.web.dto.CharacterDTO;
import com.caoc.challenge.web.dto.CharacterParamDTO;

import java.util.List;
import java.util.Optional;

public interface CharacterService {
    Optional<CharacterDTO> getById(Long id);
    CharacterDTO create(CharacterDTO characterDTO);
    Optional<CharacterDTO> update(CharacterDTO characterDTO);
    void delete(Long id);
    List<CharacterParamDTO> getByParameters(String name, Integer age, Double weight, Long idMovie);
}
