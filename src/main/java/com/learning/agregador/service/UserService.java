package com.learning.agregador.service;

import com.learning.agregador.controller.dto.CreateUserDTO;
import com.learning.agregador.entity.User;
import com.learning.agregador.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserService() {}

    public UUID createUser(CreateUserDTO createUserDTO) {
        //DTO -> Entity
        var entity = new User(
                UUID.randomUUID(),
                createUserDTO.username(),
                createUserDTO.email(),
                createUserDTO.password(),
                Instant.now(),
                null);

        var userSaved = userRepository.save(entity);

        return userSaved.getId();
    }
}
