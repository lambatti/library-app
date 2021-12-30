package com.software.architecture.libraryapp.model;

public enum Genders {
    M("Male"),
    F("Female"),
    U("Unspecified");

    private final String gender;

    Genders(String gender){
        this.gender = gender;
    }

    @Override
    public String toString() {
        return gender;
    }
}
