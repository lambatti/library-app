package com.software.architecture.libraryapp.model.dto;

import java.time.LocalDate;

public class UserSummaryDto {

    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private LocalDate birthDate;
    private LocalDate accountCreationDate;

    public UserSummaryDto(String firstName, String lastName, String email, String gender, LocalDate birthDate, LocalDate accountCreationDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.birthDate = birthDate;
        this.accountCreationDate = accountCreationDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getAccountCreationDate() {
        return accountCreationDate;
    }
}
