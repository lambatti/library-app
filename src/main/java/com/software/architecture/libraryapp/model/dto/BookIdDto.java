package com.software.architecture.libraryapp.model.dto;

import lombok.ToString;

@ToString
public class BookIdDto {
    private Integer id;

    public BookIdDto(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
