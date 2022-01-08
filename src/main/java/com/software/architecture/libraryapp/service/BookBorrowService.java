package com.software.architecture.libraryapp.service;

import com.software.architecture.libraryapp.adapter.SqlBookBorrowRepository;
import com.software.architecture.libraryapp.adapter.SqlBookRepository;
import com.software.architecture.libraryapp.model.Book;
import com.software.architecture.libraryapp.model.BookBorrow;
import com.software.architecture.libraryapp.model.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BookBorrowService {

    private final Integer PROLONGATE_DAYS = 30;

    private final SqlBookRepository bookRepository;
    private final SqlBookBorrowRepository bookBorrowRepository;

    public BookBorrowService(SqlBookRepository bookRepository, SqlBookBorrowRepository bookBorrowRepository) {
        this.bookRepository = bookRepository;
        this.bookBorrowRepository = bookBorrowRepository;
    }

    public BookBorrow borrowBook(User user, Integer bookId) {

        Book book = bookRepository.getById(bookId);

        // TODO: 08.01.2022 move it to bookService and update the controller
        if(!book.isAvailable()) {
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

        user.getBookSet().add(book);
        book.setUser(user);
        bookBorrowRepository.save(bookBorrow);

        // TODO: 08.01.2022 what to return? 
        return new BookBorrow();
    }

    public BookBorrow returnBook(User user, Integer bookId) {

        // the book must be in the users set
        // TODO: 08.01.2022 move this to bookService and update BookBorrowController

        Book book = bookRepository.getById(bookId);

        bookBorrowRepository.delete(user.getId(), bookId);
        user.getBookSet().remove(book);
        book.setCount(book.getCount() + 1);

        // TODO: 08.01.2022 update this when multiple books are supported
        book.setAvailable(true);
        book.setUser(null);

        // TODO: 08.01.2022 update BookRepository - add save @Override
        bookRepository.save(book);
        return new BookBorrow();
    }

    public BookBorrow prolongate(User user, Integer bookId) {

        // the book must be in the users set
        // TODO: 08.01.2022 move this to bookService and update BookBorrowController

        bookBorrowRepository.updateById(user.getId(), bookId, PROLONGATE_DAYS);
        return new BookBorrow();
    }
}
