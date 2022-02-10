package com.software.architecture.libraryapp.controller;

import com.software.architecture.libraryapp.model.dto.UserBorrowedBookDto;
import com.software.architecture.libraryapp.service.Actions;
import com.software.architecture.libraryapp.service.BookBorrowService;
import com.software.architecture.libraryapp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api")
public class BookBorrowController {

    private final BookBorrowService bookBorrowService;
    private final UserService userService;

    public BookBorrowController(BookBorrowService bookBorrowService, UserService userService) {
        this.bookBorrowService = bookBorrowService;
        this.userService = userService;
    }

    @GetMapping("/user/books")
    ResponseEntity<Set<UserBorrowedBookDto>> getUserBooks(@RequestHeader(name = "Authorization") String token) {
        return userService.getUserByToken(token).map(bookBorrowService::getBorrowedBooks)
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
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
