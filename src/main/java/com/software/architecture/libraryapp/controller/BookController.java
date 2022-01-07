package com.software.architecture.libraryapp.controller;

import com.software.architecture.libraryapp.model.Book;
import com.software.architecture.libraryapp.repository.BookRepository;
import com.software.architecture.libraryapp.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/books")
class BookController {
    private static final Logger logger = LoggerFactory.getLogger(BookController.class);
    private final BookService service;
    private final BookRepository repository;

    BookController(final BookService service, BookRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @GetMapping(path = "/{id}")
    ResponseEntity<Book> readBook(@PathVariable Integer id) {
        return service.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    ResponseEntity<List<Book>> getBooks(
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
    ResponseEntity<List<Book>> getAvailableBooks(@RequestParam(defaultValue = "true") boolean state) {
        return ResponseEntity.ok(
                service.readAvailableBooks(state)
        );
    }


}
