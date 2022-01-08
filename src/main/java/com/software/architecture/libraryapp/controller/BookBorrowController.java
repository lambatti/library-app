package com.software.architecture.libraryapp.controller;

import com.software.architecture.libraryapp.model.Book;
import com.software.architecture.libraryapp.model.BookBorrow;
import com.software.architecture.libraryapp.model.User;
import com.software.architecture.libraryapp.model.dto.UserSummaryDto;
import com.software.architecture.libraryapp.service.BookBorrowService;
import com.software.architecture.libraryapp.service.BookService;
import com.software.architecture.libraryapp.service.UserService;
import com.software.architecture.libraryapp.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@Slf4j
public class BookBorrowController {

    private final BookBorrowService bookBorrowService;
    private final BookService bookService;
    private final UserService userService;
    private final JwtUtil jwtTokenUtil;

    public BookBorrowController(BookBorrowService bookBorrowService, BookService bookService, UserService userService, JwtUtil jwtTokenUtil) {
        this.bookBorrowService = bookBorrowService;
        this.bookService = bookService;
        this.userService = userService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PostMapping("/user/borrowBook")
    ResponseEntity<BookBorrow> borrowBook(@RequestHeader(name="Authorization") String token, @RequestBody Integer id) {

        token = jwtTokenUtil.removeBearer(token);
        log.info("token: {}", token);
        String email = jwtTokenUtil.extractEmail(token);
        log.info("email: {}", email);

        Optional<User> user = userService.getUserByEmail(email);

        if(user.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        if(bookService.findById(id).isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        else {
            BookBorrow bookBorrow = bookBorrowService.borrowBook(user.get(), id);
            return ResponseEntity.ok(bookBorrow);
        }


        //return ResponseEntity.ok().build();
    }


}
