package com.example.notes.facade.response;

import com.example.notes.model.User;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Time;

public class UserDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("email")
    private String email;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastname;

    public UserDto(Long id, String email, String firstName, String lastname) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastname = lastname;
    }

    public UserDto(User user, long id, String title, String note, Time creatTime, Time updateTime) {
    }
}
