package com.example.notes.facade;

import com.example.notes.facade.request.UserCreationRequestDto;
import com.example.notes.facade.response.UserDto;
import com.example.notes.model.User;
import com.example.notes.service.UserService;
import com.example.notes.service.request.UserCreationRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "/users")
@RestController
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public UserDto create(final UserCreationRequestDto requestDto) {
        logger.debug("Creating User with request:{}", requestDto);

        final UserCreationRequest request = accumulateRequest(requestDto);
        final User user = userService.create(request);
        final UserDto result = accumulateUserDto(user);

        logger.info("Done creating User with request:{}", requestDto);
        return result;
    }

    @GetMapping("/{id}")
    public UserDto get(@PathVariable("id") final long id) {
        logger.debug("Getting User with id:{}", id);

        final User user = userService.get(id);
        final UserDto result = accumulateUserDto(user);

        logger.info("Done getting User with id:{}", id);
        return result;
    }

    private static UserDto accumulateUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getEmail(),
                user.getPasswordHash(),
                user.getFirstName(),
                user.getLastName()
        );
    }

    private static UserCreationRequest accumulateRequest(UserCreationRequestDto requestDto) {
        return new UserCreationRequest(
                requestDto.getEmail(),
                requestDto.getPassword(),
                requestDto.getFirstName(),
                requestDto.getLastname()
        );
    }
}
