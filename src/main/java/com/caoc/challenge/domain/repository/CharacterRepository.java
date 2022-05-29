package com.caoc.challenge.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.caoc.challenge.domain.entity.Character;

import java.util.List;

public interface CharacterRepository extends JpaRepository<Character, Long> {
    List<Character> findByNameOrAgeOrWeight(String name, Integer age, Double weight);
    List<Character> findByMoviesId(Long idMovie);
}
