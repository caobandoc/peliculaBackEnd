package com.caoc.challenge.web.controller;

import com.caoc.challenge.domain.services.MovieService;
import com.caoc.challenge.web.dto.MovieDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("")
    public ResponseEntity<List<MovieDTO>> getAll() {
        return new ResponseEntity<>(movieService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> getById(@PathVariable Long id) {
        return movieService.getById(id)
                .map(movieDTO -> new ResponseEntity<>(movieDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/add")
    public ResponseEntity<MovieDTO> create(@RequestBody MovieDTO genreDTO) {
        return new ResponseEntity<>(movieService.create(genreDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<MovieDTO> update(@RequestBody MovieDTO genreDTO) {
        return new ResponseEntity<>(movieService.update(genreDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        movieService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
