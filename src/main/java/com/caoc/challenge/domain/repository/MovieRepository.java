package com.caoc.challenge.domain.repository;

import com.caoc.challenge.domain.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByTitleAndGenresId(String title, Long genre);
    List<Movie> findByTitleAndGenresIdOrderByCreationDateAsc(String title, Long genre);
    List<Movie> findByTitleAndGenresIdOrderByCreationDateDesc(String title, Long genre);
    List<Movie> findByTitle(String title);
    List<Movie> findByTitleOrderByCreationDateAsc(String title);
    List<Movie> findByTitleOrderByCreationDateDesc(String title);
    List<Movie> findByGenresId(Long genre);
    List<Movie> findByGenresIdOrderByCreationDateAsc(Long genre);
    List<Movie> findByGenresIdOrderByCreationDateDesc(Long genre);
    List<Movie> findAllByOrderByCreationDateAsc();
    List<Movie> findAllByOrderByCreationDateDesc();

}
