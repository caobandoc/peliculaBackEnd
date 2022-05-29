package com.caoc.challenge.domain.services.impl;

import com.caoc.challenge.domain.entity.Genre;
import com.caoc.challenge.domain.repository.GenreRepository;
import com.caoc.challenge.domain.services.GenreService;
import com.caoc.challenge.web.dto.GenreDTO;
import com.caoc.challenge.web.mapper.GenreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private GenreMapper genreMapper;

    @Override
    public List<GenreDTO> getAll() {
        return genreMapper.toGenresDTO((List<Genre>) genreRepository.findAll());

    }

    @Override
    public Optional<GenreDTO> getById(Long id) {
        Optional<Genre> genreEntity = genreRepository.findById(id);
        return genreEntity.map(genreMapper::toGenreDTO);
        //return genreEntity.map(prod -> genreMapper.toGenreDTO(prod));
    }

    @Override
    public GenreDTO create(GenreDTO characterDTO) {
        Genre genre = genreRepository.save(genreMapper.toGenre(characterDTO));
        return genreMapper.toGenreDTO(genre);
    }

    @Override
    public GenreDTO update(GenreDTO characterDTO) {
        Genre genreSearch = genreRepository.findById(characterDTO.getId()).get();
        genreSearch.setName(characterDTO.getNombre());
        genreSearch.setImage(characterDTO.getImagen());
        Genre genre = genreRepository.save(genreSearch);
        return genreMapper.toGenreDTO(genre);
    }

    @Override
    public void delete(Long id) {
        genreRepository.deleteById(id);
    }
}
