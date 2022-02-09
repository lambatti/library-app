package com.software.architecture.libraryapp.service;

import com.software.architecture.libraryapp.adapter.SqlBookBorrowRepository;
import com.software.architecture.libraryapp.adapter.SqlBookRepository;
import com.software.architecture.libraryapp.model.Book;
import com.software.architecture.libraryapp.model.BookBorrow;
import com.software.architecture.libraryapp.model.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class BookBorrowService {

    private final Integer PROLONGATE_DAYS = 30;

    private final SqlBookRepository bookRepository;
    private final SqlBookBorrowRepository bookBorrowRepository;

    private final BookService bookService;
    private final UserService userService;

    public BookBorrowService(SqlBookRepository bookRepository, SqlBookBorrowRepository bookBorrowRepository,
                             BookService bookService, UserService userService) {
        this.bookRepository = bookRepository;
        this.bookBorrowRepository = bookBorrowRepository;
        this.bookService = bookService;
        this.userService = userService;
    }

    public BookBorrow borrowBook(User user, Integer bookId) {

        Book book = bookRepository.getById(bookId);

        // TODO: 08.01.2022 move it to bookService and update the controller
        if (!book.isAvailable()) {
            throw new IllegalArgumentException("Book is not available");
        }

        book.setAvailable(false);
        // TODO: 08.01.2022 update this when multiple books are supported
        book.setCount(0);

        BookBorrow bookBorrow = new BookBorrow(user, book, LocalDate.now(), LocalDate.now().plusDays(30));

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

    public boolean prolongate(User user, Integer bookId) {

        if (doesTheUserHasTheBook(user, bookId)) {
            bookBorrowRepository.updateById(user.getId(), bookId, PROLONGATE_DAYS);
            return true;
        }

        return false;
    }

    private boolean doesTheUserHasTheBook(User user, Integer bookId) {
        return bookBorrowRepository.findById(user.getId(), bookId).isPresent();
    }

    public boolean handleBookBorrowAction(String token, Integer bookId, Actions action) {

        Optional<User> user = userService.getUserByToken(token);

        if (user.isPresent() && doesTheUserHasTheBook(user.get(), bookId) && bookService.findById(bookId).isPresent()) {

            switch (action) {
                case BORROW: {
                    borrowBook(user.get(), bookId);
                    break;
                }
                case RETURN: {
                    returnBook(user.get(), bookId);
                    break;
                }
                case PROLONGATE: {
                    return prolongate(user.get(), bookId);
                }
                default: {
                    throw new IllegalArgumentException("Action is not supported");
                }
            }
            return true;
        }
        return false;
    }
}
