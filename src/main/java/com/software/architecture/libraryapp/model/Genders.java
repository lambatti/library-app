package com.software.architecture.libraryapp.model;

public enum Genders {
    M("mężczyzna"),
    F("kobieta"),
    U("nieokreślona");

    private final String gender;

    Genders(String gender){
        this.gender = gender;
    }

    @Override
    public String toString() {
        return gender;
    }
}
