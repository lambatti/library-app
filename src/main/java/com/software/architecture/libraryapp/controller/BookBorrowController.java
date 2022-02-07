package com.software.architecture.libraryapp.controller;

import com.software.architecture.libraryapp.model.BookBorrow;
import com.software.architecture.libraryapp.model.User;
import com.software.architecture.libraryapp.service.BookBorrowService;
import com.software.architecture.libraryapp.service.BookService;
import com.software.architecture.libraryapp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BookBorrowController {

    private final BookBorrowService bookBorrowService;
    private final BookService bookService;
    private final UserService userService;

    public BookBorrowController(BookBorrowService bookBorrowService, BookService bookService, UserService userService) {
        this.bookBorrowService = bookBorrowService;
        this.bookService = bookService;
        this.userService = userService;
    }

    @PostMapping("/user/borrowBook/{id}")
    ResponseEntity<BookBorrow> borrowBook(@RequestHeader(name="Authorization") String token, @PathVariable Integer id) {

        Optional<User> user = userService.getUserByToken(token);

        if(user.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        if(bookService.findById(id).isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        else {
            BookBorrow bookBorrow = bookBorrowService.borrowBook(user.get(), id);

            // TODO: 08.01.2022 - return bookBorrow (probably with DTO) or the book
            //return ResponseEntity.ok(bookBorrow);

            return ResponseEntity.ok().build();
        }
    }

    @DeleteMapping("/user/returnBook/{id}")
    ResponseEntity<BookBorrow> returnBook(@RequestHeader(name="Authorization") String token, @PathVariable Integer id) {

        Optional<User> user = userService.getUserByToken(token);

        if(user.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        if(bookService.findById(id).isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        else {
            BookBorrow bookBorrow = bookBorrowService.returnBook(user.get(), id);

            // TODO: 08.01.2022 - return bookBorrow (probably with DTO) or the book
            //return ResponseEntity.ok(bookBorrow);

            return ResponseEntity.ok().build();
        }
    }

    @PatchMapping("/user/prolongate/{id}")
    ResponseEntity<BookBorrow> prolongate(@RequestHeader(name="Authorization") String token, @PathVariable Integer id) {

        Optional<User> user = userService.getUserByToken(token);

        if (user.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        if (bookService.findById(id).isEmpty()) {
            return ResponseEntity.badRequest().build();
        } else {
            BookBorrow bookBorrow = bookBorrowService.prolongate(user.get(), id);

            // TODO: 08.01.2022 - return bookBorrow (probably with DTO)
            //return ResponseEntity.ok(bookBorrow);

            return ResponseEntity.ok().build();

        }
    }
}
