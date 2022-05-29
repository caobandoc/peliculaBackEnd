package com.caoc.challenge.web.controller;

import com.caoc.challenge.domain.services.CharacterService;
import com.caoc.challenge.web.dto.CharacterDTO;
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

    @GetMapping("")
    public ResponseEntity<List<CharacterDTO>> getAll() {
        return new ResponseEntity<>(characterService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CharacterDTO> getById(@PathVariable Long id) {
        return new ResponseEntity<>(characterService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<CharacterDTO> create(@RequestBody CharacterDTO characterDTO) {
        return new ResponseEntity<>(characterService.create(characterDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<CharacterDTO> update(@RequestBody CharacterDTO characterDTO) {
        return new ResponseEntity<>(characterService.update(characterDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        characterService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    /*
    @GetMapping("/{name}")
    public ResponseEntity<List<CharacterDTO>> getName(@PathVariable("name") String name){
        return new ResponseEntity<>(characterService.getName(name), HttpStatus.OK);
    }

    @GetMapping("/{age}")
    public ResponseEntity<List<CharacterDTO>> getAge(@PathVariable("age") String age){
        return new ResponseEntity<>(characterService.getAge(age), HttpStatus.OK);
    }

    @GetMapping("/{movies}")
    public ResponseEntity<List<CharacterDTO>> getMovies(@PathVariable("movies") String movies){
        return new ResponseEntity<>(characterService.getMovies(movies), HttpStatus.OK);
    }*/
}
