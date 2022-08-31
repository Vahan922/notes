package com.example.notes.service.request;

public class UserCreateRequest {

    private final String email;
    private final String password;
    private final String firstName;
    private final String lastname;

    public UserCreateRequest(String email, String password, String firstName, String lastname) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastname() {
        return lastname;
    }
}
