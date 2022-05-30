package com.caoc.challenge.domain.repository;

import com.caoc.challenge.domain.entity.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserLogin, Long> {
    UserLogin findByUsername(String username);
}
