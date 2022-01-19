package com.software.architecture.libraryapp.model.dto;

import com.software.architecture.libraryapp.model.RegistrationQuestions;

public class UserChangeQuestionDto {

    private String password;
    private RegistrationQuestions question;
    private String answer;

    public UserChangeQuestionDto(String password, RegistrationQuestions question, String answer) {
        this.password = password;
        this.question = question;
        this.answer = answer;
    }

    public String getPassword() {
        return password;
    }

    public RegistrationQuestions getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}
