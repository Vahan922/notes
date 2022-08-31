package com.example.notes.service;

import com.example.notes.model.User;
import com.example.notes.repository.UserRepository;
import com.example.notes.service.request.UserCreationRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;


@Service
public class UserService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User create(final UserCreationRequest request) {
        logger.trace("Creating User with request:{}", request);

        final User result = repository.save(accumulateUser(request));

        logger.debug("Done creating User with request:{}", request);
        return result;
    }

    public User get(long id) {
        logger.debug("Getting User with id:{}", id);

        final User user = repository.findById(id).orElseThrow(NoSuchElementException::new);

        logger.info("Done getting User with id:{}", id);
        return user;
    }

    private static User accumulateUser(UserCreationRequest request) {
        final User user = new User();
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastname());
        user.setPasswordHash(request.getPassword());

        return user;
    }
}
