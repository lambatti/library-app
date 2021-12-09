package com.software.architecture.libraryapp.model;

public enum RegistrationQuestions {
    ANIMAL("Jakie jest Twoje ulubione zwierzę?"),
    FRIENDS_NAME("Jakie jest imię Twojego przyjaciela z dzieciństwa?"),
    SANDWICH("Z czym najbardziej lubisz kanapki?");

    private final String question;

    RegistrationQuestions(String question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return question;
    }
}
