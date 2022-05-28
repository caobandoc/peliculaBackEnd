package com.caoc.challenge.domain.services.impl;

import com.caoc.challenge.domain.repository.CharacterRepository;
import com.caoc.challenge.domain.services.CharacterService;
import com.caoc.challenge.domain.entity.Character;
import com.caoc.challenge.web.dto.CharacterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterServiceImpl implements CharacterService {
    @Autowired
    private CharacterRepository characterRepository;

    @Override
    public List<CharacterDTO> getAll() {
        List<Character> charactersEntity = (List<Character>) characterRepository.findAll();
        return transformCharactersList(charactersEntity);
    }

    @Override
    public CharacterDTO create(CharacterDTO characterDTO) {
        Character character = characterRepository.save(Character.builder()
                .name(characterDTO.getNombre())
                .age(characterDTO.getEdad())
                .history(characterDTO.getHistoria())
                .image(characterDTO.getImagen())
                .build());

        return CharacterDTO.builder()
                .id(character.getId())
                .nombre(character.getName())
                .edad(character.getAge())
                .historia(character.getHistory())
                .imagen(character.getImage())
                .build();
    }

    @Override
    public CharacterDTO update(CharacterDTO characterDTO) {
        Character characterSearch = characterRepository.findById(characterDTO.getId()).get();
        characterSearch.setName(characterDTO.getNombre());
        characterSearch.setAge(characterDTO.getEdad());
        characterSearch.setHistory(characterDTO.getHistoria());
        characterSearch.setImage(characterDTO.getImagen());
        Character character = characterRepository.save(characterSearch);
        return CharacterDTO.builder()
                .id(character.getId())
                .nombre(character.getName())
                .edad(character.getAge())
                .historia(character.getHistory())
                .imagen(character.getImage())
                .build();
    }

    @Override
    public void delete(CharacterDTO characterDTO) {
        characterRepository.deleteById(characterDTO.getId());
    }

    private List<CharacterDTO> transformCharactersList(List<Character> charactersEntity) {
        List<CharacterDTO> charactersDTO = new ArrayList<>();
        for (Character character : charactersEntity) {
            CharacterDTO characterDTO = CharacterDTO.builder()
                    .id(character.getId())
                    .imagen(character.getImage())
                    .nombre(character.getName())
                    .edad(character.getAge())
                    .historia(character.getHistory())
                    .build();
            charactersDTO.add(characterDTO);
        }
        return charactersDTO;
    }

}
