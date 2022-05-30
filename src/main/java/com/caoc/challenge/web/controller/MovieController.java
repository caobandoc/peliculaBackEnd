package com.caoc.challenge.web.controller;

import com.caoc.challenge.domain.services.MovieService;
import com.caoc.challenge.web.dto.MovieDTO;
import com.caoc.challenge.web.dto.MovieParamDTO;
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
        return movieService.update(genreDTO)
                .map(movieDTO1 -> new ResponseEntity<>(movieDTO1, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        movieService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<MovieParamDTO>> getParameters(@RequestParam(required = false) String name,
                                                             @RequestParam(required = false) Long genre,
                                                             @RequestParam(required = false) String order) {
        return new ResponseEntity<>(movieService.getByParameters(name, genre, order), HttpStatus.OK);
    }
}
