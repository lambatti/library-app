package com.software.architecture.libraryapp.model.dto;

import com.software.architecture.libraryapp.model.Genders;
import com.software.architecture.libraryapp.model.RegistrationQuestions;

import java.time.LocalDate;
import java.util.Set;

public class UserRegistrationDto {

    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;
    private final Genders gender;
    private final LocalDate birthDate;
    private final RegistrationQuestions registrationQuestion;
    private final String registrationQuestionAnswer;
    private final Set<String> roles;

    public UserRegistrationDto(String firstName, String lastName, String email, String password, Genders gender,
                               LocalDate birthDate, RegistrationQuestions registrationQuestion,
                               String registrationQuestionAnswer, Set<String> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.birthDate = birthDate;
        this.registrationQuestion = registrationQuestion;
        this.registrationQuestionAnswer = registrationQuestionAnswer;
        this.roles = roles;
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

    public String getPassword() {
        return password;
    }

    public Genders getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public RegistrationQuestions getRegistrationQuestion() {
        return registrationQuestion;
    }

    public String getRegistrationQuestionAnswer() {
        return registrationQuestionAnswer;
    }

    public Set<String> getRoles() {
        return roles;
    }
}
