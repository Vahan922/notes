package com.example.notes.facade;

import com.example.notes.facade.helper.UserMapper;
import com.example.notes.facade.request.user.UserCreationRequestDto;
import com.example.notes.facade.request.user.UserUpdateRequestDto;
import com.example.notes.facade.response.UserDto;
import com.example.notes.model.User;
import com.example.notes.service.UserService;
import com.example.notes.service.request.UserCreateRequest;
import com.example.notes.service.request.UserUpdateRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import static org.springframework.util.Assert.notNull;

@Tag(
        name = "Notes API for Users",
        description = "This API allows to maintain users by given requests."
)
@RequestMapping(path = "/users")
@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserService userService;
    private final UserMapper mapper;

    public UserController(UserService userService, UserMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @Operation(
            summary = "Create User",
            description = "Creates User by given request"
    )
    @PostMapping()
    public UserDto create(@RequestBody final UserCreationRequestDto requestDto) {
        notNull(requestDto, "requestDto cannot not be null");
        logger.debug("Creating User with request:{}", requestDto);

        final UserCreateRequest request = mapper.accumulateCreateRequest(requestDto);
        final User user = userService.create(request);
        final UserDto result = mapper.accumulateUserDto(user);

        logger.info("Done creating User with request:{}", requestDto);
        return result;
    }

    @Operation(
            summary = "Update User",
            description = "Updates User by given request"
    )
    @PutMapping("/{id}")
    public UserDto update(@PathVariable("id") final long id, @RequestBody final UserUpdateRequestDto requestDto) {
        notNull(requestDto, "requestDto cannot not be null");
        logger.debug("Updating User:{} with request:{}", id, requestDto);

        final UserUpdateRequest request = mapper.accumulateUpdateRequest(requestDto);
        final User user = userService.update(id, request);
        final UserDto result = mapper.accumulateUserDto(user);

        logger.info("Done creating User with request:{}", requestDto);
        return result;
    }

    @Operation(
            summary = "Get User",
            description = "Get User by id"
    )
    @GetMapping("/{id}")
    public UserDto get(@PathVariable("id") final long id) {
        logger.debug("Getting User with id:{}", id);

        final User user = userService.get(id);
        final UserDto result = mapper.accumulateUserDto(user);

        logger.info("Done getting User with id:{}", id);
        return result;
    }
}
