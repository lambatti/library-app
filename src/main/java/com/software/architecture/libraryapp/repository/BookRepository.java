package com.software.architecture.libraryapp.repository;

import com.software.architecture.libraryapp.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    List<Book> findAll();

    Optional<Book> findById(Integer id);

    boolean existsById(Integer id);
}
