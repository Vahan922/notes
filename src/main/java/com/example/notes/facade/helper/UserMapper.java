package com.example.notes.facade.helper;

import com.example.notes.facade.request.UserCreationRequestDto;
import com.example.notes.facade.request.UserUpdateRequestDto;
import com.example.notes.facade.response.UserDto;
import com.example.notes.model.User;
import com.example.notes.service.request.UserCreateRequest;
import com.example.notes.service.request.UserUpdateRequest;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto accumulateUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName()
        );
    }

    public UserCreateRequest accumulateCreateRequest(UserCreationRequestDto requestDto) {
        return new UserCreateRequest(
                requestDto.getEmail(),
                requestDto.getPassword(),
                requestDto.getFirstName(),
                requestDto.getLastname()
        );
    }

    public UserUpdateRequest accumulateUpdateRequest(UserUpdateRequestDto requestDto) {
        return new UserUpdateRequest(
                requestDto.getEmail(),
                requestDto.getFirstName(),
                requestDto.getLastname()
        );
    }
}
