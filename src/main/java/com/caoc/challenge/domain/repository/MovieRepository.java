package com.caoc.challenge.domain.repository;

import com.caoc.challenge.domain.entity.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Long> {

}
