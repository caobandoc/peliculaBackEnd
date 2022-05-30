package com.caoc.challenge.domain.services;

import com.caoc.challenge.domain.entity.UserLogin;
import com.caoc.challenge.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.StyledEditorKit;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserLoginDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserLogin userLogin = userRepository.findByUsername(username);
        if (userLogin == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new User(userLogin.getUsername(), "{bcrypt}"+userLogin.getPassword(), new ArrayList<>());
    }


    public Boolean save(UserLogin userLogin) {
        if (userRepository.findByUsername(userLogin.getUsername()) != null) {
            return false;
        }
        userLogin.setPassword(new BCryptPasswordEncoder().encode(userLogin.getPassword()));
        userRepository.save(userLogin);
        return true;
    }
}

