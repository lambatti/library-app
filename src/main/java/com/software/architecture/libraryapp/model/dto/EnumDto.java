package com.software.architecture.libraryapp.model.dto;

public class EnumDto {

    private String key;
    private String value;

    public EnumDto(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
