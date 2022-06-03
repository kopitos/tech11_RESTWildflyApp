package com.example.tech11;

import java.time.LocalDate;

public class UserDTO {

    private String email;
    private String firstName;
    private String lastName;
    private LocalDate birthday;

    public String getEmail() { return email;}

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public UserDTO(String email, String firstName, String lastName, LocalDate birthday) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
    }
}
