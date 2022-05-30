package com.caoc.challenge.domain.services.impl;

import com.caoc.challenge.domain.repository.CharacterRepository;
import com.caoc.challenge.domain.services.CharacterService;
import com.caoc.challenge.domain.entity.Character;
import com.caoc.challenge.web.dto.CharacterDTO;
import com.caoc.challenge.web.dto.CharacterParamDTO;
import com.caoc.challenge.web.mapper.CharacterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterServiceImpl implements CharacterService {
    @Autowired
    private CharacterRepository characterRepository;
    @Autowired
    private CharacterMapper characterMapper;

    @Override
    public Optional<CharacterDTO> getById(Long id) {
        Optional<Character> characterEntity = characterRepository.findById(id);
        return characterEntity.map(characterMapper::characterToCharacterDTO);
    }

    @Override
    public CharacterDTO create(CharacterDTO characterDTO) {
        Character character = characterMapper.characterToCharacterDTO(characterDTO);
        return characterMapper.characterToCharacterDTO(characterRepository.save(character));
    }

    @Override
    public Optional<CharacterDTO> update(CharacterDTO characterDTO) {
        Optional<Character> characterSearch = characterRepository.findById(characterDTO.getId());
        if (characterSearch.isPresent()) {
            setCharacterUpdate(characterDTO, characterSearch.get());
            Character character = characterRepository.save(characterSearch.get());
            return Optional.of(characterMapper.characterToCharacterDTO(characterRepository.save(character)));
        }
        return Optional.empty();
    }

    private void setCharacterUpdate(CharacterDTO characterDTO, Character characterSearch) {
        characterSearch.setImage(characterDTO.getImagen());
        characterSearch.setName(characterDTO.getNombre());
        characterSearch.setAge(characterDTO.getEdad());
        characterSearch.setWeight(characterDTO.getPeso());
        characterSearch.setHistory(characterDTO.getHistoria());
    }

    @Override
    public void delete(Long id) {
        characterRepository.deleteById(id);
    }

    @Override
    public List<CharacterParamDTO> getByParameters(String name, Integer age, Double weight, Long idMovie) {
        if (idMovie != null){
            return characterMapper.characterListToCharacterParamDTO(characterRepository.findByMoviesId(idMovie));
        }else if (name != null || age != null || weight != null){
            return characterMapper.characterListToCharacterParamDTO(characterRepository.findByNameOrAgeOrWeight(name, age, weight));
        }else{
            return characterMapper.characterListToCharacterParamDTO(characterRepository.findAll());
        }
    }

}
