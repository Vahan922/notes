package com.example.notes.service.request;

public class UserUpdateRequest {


    private final String email;
    private final String firstName;
    private final String lastname;

    public UserUpdateRequest(String email, String firstName, String lastname) {
        this.email = email;
        this.firstName = firstName;
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastname() {
        return lastname;
    }
}
