package com.software.architecture.libraryapp.service;

import com.software.architecture.libraryapp.model.Genders;
import com.software.architecture.libraryapp.model.Genres;
import com.software.architecture.libraryapp.model.RegistrationQuestions;
import com.software.architecture.libraryapp.model.dto.EnumDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnumService {

    private List<EnumDto> createEnumDto(Enum[] values) {
        List<EnumDto> enumDto = new ArrayList<>();

        for (var e: values) {
            enumDto.add(new EnumDto(e.name(), e.toString()));
        }

        return enumDto;
    }

    public List<EnumDto> getAllGenders() {
        return createEnumDto(Genders.values());
    }

    public List<EnumDto> getAllGenres() {
        return createEnumDto(Genres.values());
    }

    public List<EnumDto> getAllRegistrationQuestions() {
        return createEnumDto(RegistrationQuestions.values());
    }
}
