package com.example.notes.facade.request.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserUpdateRequestDto {

    @JsonProperty("email")
    private String email;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastname")
    private String lastname;

    public UserUpdateRequestDto() {
    }

    public UserUpdateRequestDto(String email, String firstName, String lastname) {
        this.email = email;
        this.firstName = firstName;
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
