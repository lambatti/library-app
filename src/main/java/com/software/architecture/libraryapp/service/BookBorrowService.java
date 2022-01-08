package com.software.architecture.libraryapp.service;

import com.software.architecture.libraryapp.adapter.SqlBookBorrowRepository;
import com.software.architecture.libraryapp.adapter.SqlBookRepository;
import com.software.architecture.libraryapp.adapter.SqlUserRepository;
import com.software.architecture.libraryapp.model.Book;
import com.software.architecture.libraryapp.model.BookBorrow;
import com.software.architecture.libraryapp.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@Slf4j
public class BookBorrowService {

    private final SqlBookRepository bookRepository;
    private final SqlUserRepository userRepository;
    private final SqlBookBorrowRepository bookBorrowRepository;

    public BookBorrowService(SqlBookRepository bookRepository, SqlUserRepository userRepository, SqlBookBorrowRepository bookBorrowRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
        this.bookBorrowRepository = bookBorrowRepository;
    }

    public BookBorrow borrowBook(User user, Integer bookId) {

        Book book = bookRepository.getById(bookId);

        if(!book.isAvailable()) {
            log.info("Book is not available");
            throw new IllegalArgumentException("Book is not available");
        }

        book.setAvailable(false);
        // TODO: 08.01.2022 update this when multiple books are supported
        book.setCount(0);

        BookBorrow bookBorrow = BookBorrow.builder()
                .user(user)
                .book(book)
                .borrowDate(LocalDate.now())
                .returnDate(LocalDate.now().plusDays(30))
                .build();

        log.info("Book " + book);

        user.getBookSet().add(book);
        book.setUser(user);
        bookBorrowRepository.save(bookBorrow);

        // TODO: 08.01.2022 what to return? 
        return new BookBorrow();

    }
}
