package com.software.architecture.libraryapp.model.dto;

import com.software.architecture.libraryapp.model.RegistrationQuestions;

public class UserForgottenPasswordDto {

    private String email;
    private RegistrationQuestions question;
    private String answer;
    private String newPassword;
    private String newPasswordConfirmation;

    public UserForgottenPasswordDto(String email, RegistrationQuestions question, String answer, String newPassword, String newPasswordConfirmation) {
        this.email = email;
        this.question = question;
        this.answer = answer;
        this.newPassword = newPassword;
        this.newPasswordConfirmation = newPasswordConfirmation;
    }

    public String getEmail() {
        return email;
    }

    public RegistrationQuestions getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public String getNewPasswordConfirmation() {
        return newPasswordConfirmation;
    }
}
