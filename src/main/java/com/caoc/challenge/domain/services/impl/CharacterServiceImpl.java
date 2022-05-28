package com.caoc.challenge.domain.services.impl;

import com.caoc.challenge.domain.repository.CharacterRepository;
import com.caoc.challenge.domain.services.CharacterService;
import com.caoc.challenge.domain.entity.Character;
import com.caoc.challenge.web.dto.CharacterDTO;
import com.caoc.challenge.web.mapper.CharacterMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterServiceImpl implements CharacterService {
    @Autowired
    private CharacterRepository characterRepository;
    @Autowired
    private CharacterMapper characterMapper;

    @Override
    public List<CharacterDTO> getAll() {
        List<Character> charactersEntity = (List<Character>) characterRepository.findAll();
        return characterMapper.toCharactersDTO(charactersEntity);
    }

    @Override
    public CharacterDTO create(CharacterDTO characterDTO) {
        Character character = characterRepository.save(characterMapper.toCharacter(characterDTO));

        return characterMapper.toCharacterDTO(character);
    }

    @Override
    public CharacterDTO update(CharacterDTO characterDTO) {
        Character characterSearch = characterRepository.findById(characterDTO.getId()).get();
        characterSearch.setName(characterDTO.getNombre());
        characterSearch.setAge(characterDTO.getEdad());
        characterSearch.setHistory(characterDTO.getHistoria());
        characterSearch.setImage(characterDTO.getImagen());
        Character character = characterRepository.save(characterSearch);
        return characterMapper.toCharacterDTO(character);
    }

    @Override
    public void delete(Long id) {
        characterRepository.deleteById(id);
    }

}
