package com.software.architecture.libraryapp.model.dto;

import com.software.architecture.libraryapp.model.Genders;
import com.software.architecture.libraryapp.model.RegistrationQuestions;

import java.time.LocalDate;

public class UserRegistrationDto {

    public UserRegistrationDto(String firstName, String lastName, String email, String password, Genders gender, LocalDate birthDate, RegistrationQuestions registrationQuestion, String registrationQuestionAnswer) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.birthDate = birthDate;
        this.registrationQuestion = registrationQuestion;
        this.registrationQuestionAnswer = registrationQuestionAnswer;
    }

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Genders gender;
    private LocalDate birthDate;
    private RegistrationQuestions registrationQuestion;
    private String registrationQuestionAnswer;

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
}
