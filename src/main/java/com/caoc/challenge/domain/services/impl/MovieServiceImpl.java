package com.caoc.challenge.domain.services.impl;

import com.caoc.challenge.domain.entity.Movie;
import com.caoc.challenge.domain.repository.MovieRepository;
import com.caoc.challenge.domain.services.MovieService;
import com.caoc.challenge.web.dto.MovieDTO;
import com.caoc.challenge.web.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private MovieMapper movieMapper;

    @Override
    public List<MovieDTO> getAll() {
        return movieMapper.movieListToMovieDTOList((List<Movie>) movieRepository.findAll());
    }

    @Override
    public Optional<MovieDTO> getById(Long id) {
        return movieRepository.findById(id).map(movieMapper::movieToMovieDTO);
    }

    @Override
    public MovieDTO create(MovieDTO movieDTO) {
        Movie movie = movieRepository.save(movieMapper.movieDTOToMovie(movieDTO));
        return movieMapper.movieToMovieDTO(movie);
    }

    @Override
    public Optional<MovieDTO> update(MovieDTO movieDTO) {
        Optional<Movie> movieSearch = movieRepository.findById(movieDTO.getId());
        if (movieSearch.isPresent()) {
            setMovieUpdate(movieDTO, movieSearch.get());
            Movie movie = movieRepository.save(movieSearch.get());
            return Optional.of(movieMapper.movieToMovieDTO(movie));
        }
        return Optional.empty();
    }

    private void setMovieUpdate(MovieDTO movieDTO, Movie movieSearch) {
        movieSearch.setImage(movieDTO.getImagen());
        movieSearch.setTitle(movieDTO.getTitulo());
        movieSearch.setCreationDate(movieDTO.getFechaCreacion());
        movieSearch.setRate(movieDTO.getCalificacion());
    }

    @Override
    public void delete(Long id) {
        movieRepository.deleteById(id);
    }
}
