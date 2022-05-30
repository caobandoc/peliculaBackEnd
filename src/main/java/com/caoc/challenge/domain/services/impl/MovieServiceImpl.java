package com.caoc.challenge.domain.services.impl;

import com.caoc.challenge.domain.entity.Character;
import com.caoc.challenge.domain.entity.Movie;
import com.caoc.challenge.domain.repository.CharacterRepository;
import com.caoc.challenge.domain.repository.MovieRepository;
import com.caoc.challenge.domain.services.MovieService;
import com.caoc.challenge.web.dto.MovieDTO;
import com.caoc.challenge.web.dto.MovieParamDTO;
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
    private CharacterRepository characterRepository;
    @Autowired
    private MovieMapper movieMapper;
    private static final String ASC = "ASC";
    private static final String DESC = "DESC";

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

    @Override
    public List<MovieParamDTO> getByParameters(String name, Long genre, String order) {
        //Todos los campos
        if(name != null && genre != null) {
            return getMovieParamDTOSAll(name, genre, order);
        }
        //Solo el nombre
        if(name != null && genre == null){
            return getMovieParamDTOSName(name, order);
        }
        //Solo el genero
        if(name == null && genre != null){
            return getMovieParamDTOSGenre(genre, order);
        }
        //Orden o todos
        return getMovieParamDTOSOrder(order);
    }

    @Override
    public Optional<MovieDTO> addCharacter(Long idMovie, Long idCharacter) {
        Optional<Movie> movieSearch = movieRepository.findById(idMovie);
        Optional<Character> characterSearch = characterRepository.findById(idCharacter);
        if (movieSearch.isPresent() && characterSearch.isPresent()) {
            movieSearch.get().getCharacters().add(characterSearch.get());
            Movie movie = movieRepository.save(movieSearch.get());
            return Optional.of(movieMapper.movieToMovieDTO(movie));
        }
        return Optional.empty();
    }

    @Override
    public Optional<MovieDTO> deleteCharacter(Long idMovie, Long idCharacter) {
        Optional<Movie> movieSearch = movieRepository.findById(idMovie);
        Optional<Character> characterSearch = characterRepository.findById(idCharacter);
        if (movieSearch.isPresent() && characterSearch.isPresent()) {
            movieSearch.get().getCharacters().remove(characterSearch.get());
            Movie movie = movieRepository.save(movieSearch.get());
            return Optional.of(movieMapper.movieToMovieDTO(movie));
        }
        return Optional.empty();
    }

    private List<MovieParamDTO> getMovieParamDTOSOrder(String order) {
        if(order != null) {
            if (order.equals(ASC)) {
                return movieMapper.movieListToMovieParamDTO(movieRepository.findAllByOrderByCreationDateAsc());
            } else if (order.equals(DESC)) {
                return movieMapper.movieListToMovieParamDTO(movieRepository.findAllByOrderByCreationDateDesc());
            }
        }
        return movieMapper.movieListToMovieParamDTO(movieRepository.findAll());
    }

    private List<MovieParamDTO> getMovieParamDTOSGenre(Long genre, String order) {
        if (order != null) {
            if (order.equals(ASC)) {
                return movieMapper.movieListToMovieParamDTO(movieRepository.findByGenresIdOrderByCreationDateAsc(genre));
            } else if (order.equals(DESC)) {
                return movieMapper.movieListToMovieParamDTO(movieRepository.findByGenresIdOrderByCreationDateDesc(genre));
            }
        }
        return movieMapper.movieListToMovieParamDTO(movieRepository.findByGenresId(genre));
    }

    private List<MovieParamDTO> getMovieParamDTOSName(String name, String order) {
        if (order != null) {
            if (order.equals(ASC)) {
                return movieMapper.movieListToMovieParamDTO(movieRepository.findByTitleOrderByCreationDateAsc(name));
            } else if (order.equals(DESC)) {
                return movieMapper.movieListToMovieParamDTO(movieRepository.findByTitleOrderByCreationDateDesc(name));
            }
        }
        return movieMapper.movieListToMovieParamDTO(movieRepository.findByTitle(name));
    }

    private List<MovieParamDTO> getMovieParamDTOSAll(String name, Long genre, String order) {
        if (order != null) {
            if(order.equals(ASC)) {
                return movieMapper.movieListToMovieParamDTO(movieRepository.findByTitleAndGenresIdOrderByCreationDateAsc(name, genre));
            }else if (order.equals(DESC)) {
                return movieMapper.movieListToMovieParamDTO(movieRepository.findByTitleAndGenresIdOrderByCreationDateDesc(name, genre));
            }
        }
        return movieMapper.movieListToMovieParamDTO(movieRepository.findByTitleAndGenresId(name, genre));
    }
}
