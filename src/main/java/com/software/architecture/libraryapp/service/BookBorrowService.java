package com.software.architecture.libraryapp.service;

import com.software.architecture.libraryapp.adapter.SqlBookBorrowRepository;
import com.software.architecture.libraryapp.adapter.SqlBookRepository;
import com.software.architecture.libraryapp.model.Book;
import com.software.architecture.libraryapp.model.BookBorrow;
import com.software.architecture.libraryapp.model.User;
import com.software.architecture.libraryapp.model.dto.UserBorrowedBookDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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

    private void prolongate(User user, Integer bookId) {
        bookBorrowRepository.updateById(user.getId(), bookId, PROLONGATE_DAYS);
    }

    private boolean doesTheUserHasTheBook(User user, Integer bookId) {
        return bookBorrowRepository.findById(user.getId(), bookId).isPresent();
    }

    public boolean handleBookBorrowAction(String token, Integer bookId, Actions action) {

        // TODO: 09.02.2022 handle all actions with return

        Optional<User> user = userService.getUserByToken(token);

        if (user.isPresent() && bookService.findById(bookId).isPresent()) {

            switch (action) {
                case BORROW: {
                    if (!doesTheUserHasTheBook(user.get(), bookId)) {
                        borrowBook(user.get(), bookId);
                        return true;
                    }
                    break;
                }
                case RETURN: {
                    if (doesTheUserHasTheBook(user.get(), bookId)) {
                        returnBook(user.get(), bookId);
                        return true;
                    }
                    break;
                }
                case PROLONGATE: {
                    if (doesTheUserHasTheBook(user.get(), bookId)) {
                        prolongate(user.get(), bookId);
                        return true;
                    }
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Action is not supported");
                }
            }
        }
        return false;
    }

    public List<UserBorrowedBookDto> getBorrowedBooks(User user) {
        List<BookBorrow> bookBorrows = bookBorrowRepository.getAllByUserId(user.getId());

        List<UserBorrowedBookDto> userBorrowedBooksSet = new ArrayList<>();

        for (BookBorrow bookBorrow : bookBorrows) {
            Book book = bookBorrow.getBook();

            UserBorrowedBookDto userBorrowedBook = new UserBorrowedBookDto(
                    book.getId(),
                    book.getCoverUrl(),
                    book.getTitle(),
                    book.getAuthor(),
                    book.getPublicationDate(),
                    book.getGenre().toString(),
                    book.isHardcover(),
                    bookBorrow.getBorrowDate().toString(),
                    bookBorrow.getReturnDate().toString()
            );

            userBorrowedBooksSet.add(userBorrowedBook);
        }

        return userBorrowedBooksSet;
    }
}
