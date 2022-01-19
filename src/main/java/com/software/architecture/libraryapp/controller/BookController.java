package com.software.architecture.libraryapp.controller;

import com.software.architecture.libraryapp.model.dto.BookDto;
import com.software.architecture.libraryapp.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/books")
class BookController {
    private final BookService service;

    BookController(final BookService service) {
        this.service = service;
    }

    @GetMapping(path = "/{id}")
    ResponseEntity<BookDto> readBook(@PathVariable Integer id) {
        return service.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    ResponseEntity<List<BookDto>> getBooks(
            @RequestParam(required = false, value = "title") String inputTitle,
            @RequestParam(required = false, value = "author") String inputAuthor,
            @RequestParam(required = false, value = "genre") String inputGenre) {
        if (inputTitle == null && inputAuthor == null && inputGenre == null) {
            return ResponseEntity.ok(
                    service.readAll()
            );
        } else {
            return ResponseEntity.ok(
                    service.readFilteredBooks(inputTitle, inputAuthor, inputGenre)
            );
        }
    }


    @GetMapping(path = "/available")
    ResponseEntity<List<BookDto>> getAvailableBooks(@RequestParam(defaultValue = "true") boolean state) {
        return ResponseEntity.ok(
                service.readAvailableBooks(state)
        );
    }
}
