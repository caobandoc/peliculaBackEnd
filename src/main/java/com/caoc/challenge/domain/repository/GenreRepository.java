package com.caoc.challenge.domain.repository;

import com.caoc.challenge.domain.entity.Genre;
import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends CrudRepository<Genre, Long> {

}
