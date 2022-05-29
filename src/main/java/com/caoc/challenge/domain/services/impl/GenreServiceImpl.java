package com.caoc.challenge.domain.services.impl;

import com.caoc.challenge.domain.entity.Genre;
import com.caoc.challenge.domain.repository.GenreRepository;
import com.caoc.challenge.domain.services.GenreService;
import com.caoc.challenge.web.dto.GenreDTO;
import com.caoc.challenge.web.mapper.GenreMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
    public GenreDTO getById(Long id) {
        Genre genreEntity = genreRepository.findById(id).orElse(null);
        return genreMapper.toGenreDTO(genreEntity);
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
