package com.software.architecture.libraryapp.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Genres {
    FSF("fantasy, science fiction"),
    KST("kryminał, sensacja, thriller"),
    LOR("literatura obyczajowa, romans"),
    LM("literatura młodzieżowa"),
    LP("literatura piękna"),
    K("klasyka"),
    PH("powieść historyczna"),
    PP("powieść przygodowa");

    private final String text;

    Genres(final String text) {
        this.text = text;
    }

    @JsonValue
    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return text;
    }
}
