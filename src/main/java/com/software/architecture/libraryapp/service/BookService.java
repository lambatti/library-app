package com.software.architecture.libraryapp.service;

import com.software.architecture.libraryapp.model.Book;
import com.software.architecture.libraryapp.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {
    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public Optional<Book> findById(Integer id) {
        return repository.findById(id);
    }
}
