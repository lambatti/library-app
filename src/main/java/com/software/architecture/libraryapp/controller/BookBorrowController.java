package com.software.architecture.libraryapp.controller;

import com.software.architecture.libraryapp.model.BookBorrow;
import com.software.architecture.libraryapp.model.User;
import com.software.architecture.libraryapp.service.Actions;
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

    public BookBorrowController(BookBorrowService bookBorrowService) {
        this.bookBorrowService = bookBorrowService;
    }

    @PostMapping("/user/borrowBook/{id}")
    ResponseEntity<BookBorrow> borrowBook(@RequestHeader(name="Authorization") String token, @PathVariable Integer id) {

        if (bookBorrowService.handleAction(token, id, Actions.BORROW)) {
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/user/returnBook/{id}")
    ResponseEntity<?> returnBook(@RequestHeader(name="Authorization") String token, @PathVariable Integer id) {

        if (bookBorrowService.handleAction(token, id, Actions.RETURN)) {
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();
    }

    @PatchMapping("/user/prolongate/{id}")
    ResponseEntity<?> prolongate(@RequestHeader(name="Authorization") String token, @PathVariable Integer id) {

        if (bookBorrowService.handleAction(token, id, Actions.PROLONGATE)) {
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();
    }
}
