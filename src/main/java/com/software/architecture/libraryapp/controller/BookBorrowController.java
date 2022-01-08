package com.software.architecture.libraryapp.controller;

import com.software.architecture.libraryapp.model.Book;
import com.software.architecture.libraryapp.model.BookBorrow;
import com.software.architecture.libraryapp.model.User;
import com.software.architecture.libraryapp.model.dto.BookIdDto;
import com.software.architecture.libraryapp.model.dto.UserSummaryDto;
import com.software.architecture.libraryapp.service.BookBorrowService;
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
    private final UserService userService;
    private final JwtUtil jwtTokenUtil;

    public BookBorrowController(BookBorrowService bookBorrowService, JwtUtil jwtTokenUtil, UserService userService) {
        this.bookBorrowService = bookBorrowService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userService = userService;
    }

    @PostMapping("/book/borrow")
    ResponseEntity<BookBorrow> borrowBook(@RequestHeader(name="Authorization") String token, @RequestBody BookIdDto bookIdDto) {

        token = jwtTokenUtil.removeBearer(token);
        log.info("token: {}", token);
        String email = jwtTokenUtil.extractEmail(token);
        log.info("email: {}", email);

        Optional<User> user = userService.getUserByEmail(email);

        log.info(bookIdDto.toString());

        if(user.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        else {
            Integer id = bookIdDto.getId();
            BookBorrow bookBorrow = bookBorrowService.borrowBook(user.get(), id);
            return ResponseEntity.ok(bookBorrow);
        }


        //return ResponseEntity.ok().build();
    }


}
