package com.software.architecture.libraryapp.controller;

import com.software.architecture.libraryapp.model.Book;
import com.software.architecture.libraryapp.model.User;
import com.software.architecture.libraryapp.service.UserService;
import com.software.architecture.libraryapp.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api")
@Slf4j
public class UserController {

    private final UserService userService;
    private final JwtUtil jwtTokenUtil;

    public UserController(UserService userService, JwtUtil jwtTokenUtil) {
        this.userService = userService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping("/user/books")
    public ResponseEntity<Set<Book>> getUserBooks(@RequestHeader(name="Authorization") String token) {

        token = jwtTokenUtil.removeBearer(token);
        log.info("token: {}", token);
        String email = jwtTokenUtil.extractEmail(token);
        log.info("email: {}", email);

        Optional<User> user = userService.getUserByEmail(email);

        if(user.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        else {
            return ResponseEntity.ok(user.get().getBookSet());
        }
    }

}
