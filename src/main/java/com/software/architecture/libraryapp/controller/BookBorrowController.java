package com.software.architecture.libraryapp.controller;

import com.software.architecture.libraryapp.service.Actions;
import com.software.architecture.libraryapp.service.BookBorrowService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BookBorrowController {

    private final BookBorrowService bookBorrowService;

    public BookBorrowController(BookBorrowService bookBorrowService) {
        this.bookBorrowService = bookBorrowService;
    }

    @PostMapping("/user/borrowBook/{bookId}")
    ResponseEntity<?> borrowBook(@RequestHeader(name = "Authorization") String token, @PathVariable Integer bookId) {

        if (bookBorrowService.handleBookBorrowAction(token, bookId, Actions.BORROW)) {
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/user/returnBook/{bookId}")
    ResponseEntity<?> returnBook(@RequestHeader(name = "Authorization") String token, @PathVariable Integer bookId) {

        if (bookBorrowService.handleBookBorrowAction(token, bookId, Actions.RETURN)) {
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();
    }

    @PatchMapping("/user/prolongate/{bookId}")
    ResponseEntity<?> prolongate(@RequestHeader(name = "Authorization") String token, @PathVariable Integer bookId) {

        if (bookBorrowService.handleBookBorrowAction(token, bookId, Actions.PROLONGATE)) {
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();
    }
}
