package com.caoc.challenge.domain.repository;

import org.springframework.data.repository.CrudRepository;
import com.caoc.challenge.domain.entity.Character;

public interface CharacterRepository extends CrudRepository<Character, Long> {

}
