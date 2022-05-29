package com.caoc.challenge.web.controller;

import com.caoc.challenge.domain.services.GenreService;
import com.caoc.challenge.web.dto.GenreDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenreController {
    @Autowired
    private GenreService genreService;

    @GetMapping("")
    public ResponseEntity<List<GenreDTO>> getAll() {
        return new ResponseEntity<>(genreService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenreDTO> getById(@PathVariable Long id) {
        return genreService.getById(id)
                .map(genreDTO -> new ResponseEntity<>(genreDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/add")
    public ResponseEntity<GenreDTO> create(@RequestBody GenreDTO genreDTO) {
        return new ResponseEntity<>(genreService.create(genreDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<GenreDTO> update(@RequestBody GenreDTO genreDTO) {
        return new ResponseEntity<>(genreService.update(genreDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        genreService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
