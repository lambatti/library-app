package com.software.architecture.libraryapp.model.dto;

import com.software.architecture.libraryapp.model.Genders;

import java.time.LocalDate;

public class UserSummaryDto {

    public UserSummaryDto(String firstName, String lastName, String email, Genders gender, LocalDate birthDate, LocalDate accountCreationDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.birthDate = birthDate;
        this.accountCreationDate = accountCreationDate;
    }

    private String firstName;
    private String lastName;
    private String email;
    private Genders gender;
    private LocalDate birthDate;
    private LocalDate accountCreationDate;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Genders getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getAccountCreationDate() {
        return accountCreationDate;
    }
}
