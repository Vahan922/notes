package com.example.notes.facade.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("email")
    private String email;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastname")
    private String lastname;

    public UserDto(Long id, String email, String firstName, String lastname) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastname = lastname;
    }

    public UserDto() {
    }
}
