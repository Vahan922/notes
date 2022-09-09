package com.example.notes.service;

import com.example.notes.model.User;
import com.example.notes.repository.UserRepository;
import com.example.notes.service.request.UserCreateRequest;
import com.example.notes.service.request.UserUpdateRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

import static org.springframework.util.Assert.notNull;


@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User create(final UserCreateRequest request) {
        notNull(request, "request cannot be null");
        logger.trace("Creating User with request:{}", request);

        final User result = repository.save(accumulateCreateUser(request));

        logger.debug("Done creating User with request:{}", request);
        return result;
    }

    public User update(final long id, final UserUpdateRequest request) {
        notNull(request, "request cannot be null");
        logger.trace("Updating User with request:{}", request);

        final User user = get(id);
        final User result = repository.save(accumulateUpdateUser(request, user));

        logger.debug("Done updating User with request:{}", request);
        return result;
    }

    public User get(final long id) {
        logger.debug("Getting User with id:{}", id);

        final User user = repository.findById(id).orElseThrow(NoSuchElementException::new);

        logger.info("Done getting User with id:{}", id);
        return user;
    }

    private static User accumulateCreateUser(final UserCreateRequest request) {
        final User result = new User();
        result.setEmail(request.getEmail());
        result.setFirstName(request.getFirstName());
        result.setLastName(request.getLastname());
        result.setPasswordHash(request.getPassword());
        result.setPhoneNumber(result.getPhoneNumber());

        return result;
    }

    private static User accumulateUpdateUser(final UserUpdateRequest request, final User user) {
        final User result = new User();
        result.setEmail(request.getEmail());
        result.setFirstName(request.getFirstName());
        result.setLastName(request.getLastname());
        result.setPasswordHash(user.getPasswordHash());
        result.setPhoneNumber(user.getPhoneNumber());

        return result;
    }
}
