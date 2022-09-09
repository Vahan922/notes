package com.example.notes.facade.request.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserCreationRequestDto {

    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private String password;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastname")
    private String lastname;

    public UserCreationRequestDto() {
    }

    public UserCreationRequestDto(String email, String password, String firstName, String lastname) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
