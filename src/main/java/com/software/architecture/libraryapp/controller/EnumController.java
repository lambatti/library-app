package com.software.architecture.libraryapp.controller;

import com.software.architecture.libraryapp.model.dto.EnumDto;
import com.software.architecture.libraryapp.service.EnumService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EnumController {

    private final EnumService enumService;

    public EnumController(EnumService enumService) {
        this.enumService = enumService;
    }

    @GetMapping("/enum/genders")
    ResponseEntity<List<EnumDto>> getAllGenders() {
        return ResponseEntity.ok(enumService.getAllGenders());
    }

    @GetMapping("/enum/genres")
    ResponseEntity<List<EnumDto>> getAllGenres() {
        return ResponseEntity.ok(enumService.getAllGenres());
    }

    @GetMapping("/enum/registrationQuestions")
    ResponseEntity<List<EnumDto>> getAllRegistrationQuestions() {
        return ResponseEntity.ok(enumService.getAllRegistrationQuestions());
    }
}
