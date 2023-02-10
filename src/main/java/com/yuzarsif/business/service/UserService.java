package com.yuzarsif.business.service;

import com.yuzarsif.business.exception.UserNotFoundException;
import com.yuzarsif.business.model.User;
import com.yuzarsif.business.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    protected User findByEmail(String email) {
        return userRepository
                .findByEmail(email)
                .orElseThrow(
                        () -> new UserNotFoundException("Could not find User by email : " + email));
    }
}
