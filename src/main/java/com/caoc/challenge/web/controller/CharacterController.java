package com.caoc.challenge.web.controller;

import com.caoc.challenge.domain.services.CharacterService;
import com.caoc.challenge.web.dto.CharacterDTO;
import com.caoc.challenge.web.dto.CharacterParamDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @GetMapping("/{id}")
    public ResponseEntity<CharacterDTO> getById(@PathVariable Long id) {
        return characterService.getById(id)
                .map(characterDTO -> new ResponseEntity<>(characterDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/add")
    public ResponseEntity<CharacterDTO> create(@RequestBody CharacterDTO characterDTO) {
        return new ResponseEntity<>(characterService.create(characterDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<CharacterDTO> update(@RequestBody CharacterDTO characterDTO) {
        return characterService.update(characterDTO)
                .map(characterDTO1 -> new ResponseEntity<>(characterDTO1, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        characterService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("")
    public ResponseEntity<List<CharacterParamDTO>> getParameters(@RequestParam(required = false) String name,
                                                                 @RequestParam(required = false) Integer age,
                                                                 @RequestParam(required = false) Double weight,
                                                                 @RequestParam(required = false) Long idMovie) {
        return new ResponseEntity<>(characterService.getByParameters(name, age, weight, idMovie), HttpStatus.OK);

    }
}
