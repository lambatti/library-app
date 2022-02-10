package com.software.architecture.libraryapp.controller;

import com.software.architecture.libraryapp.model.User;
import com.software.architecture.libraryapp.model.dto.*;
import com.software.architecture.libraryapp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/user/{id}")
    ResponseEntity<User> getUserById(@PathVariable Integer id) {
        return userService.getUserById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/books")
    ResponseEntity<Set<UserBorrowedBookDto>> getUserBooks(@RequestHeader(name = "Authorization") String token) {
        return userService.getBorrowedBooks(token).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/summary")
    ResponseEntity<UserSummaryDto> getUserSummary(@RequestHeader(name = "Authorization") String token) {

        Optional<User> user = userService.getUserByToken(token);

        if (user.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(userService.createUserSummaryDto(user.get()));
    }

    @PostMapping("/register")
    ResponseEntity<?> registerUser(@RequestBody(required = false) UserRegistrationDto userRegistrationDto) {

        Optional<User> user = userService.getUserByEmail(userRegistrationDto.getEmail());

        if (user.isPresent()) {
            return ResponseEntity.badRequest().build();
        }

        userService.registerUser(userRegistrationDto);

        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().build().toUri()).build();
    }

    @PatchMapping("/user/forgottenPassword")
    ResponseEntity<?> forgottenPassword(@RequestBody UserForgottenPasswordDto userForgottenPasswordDto) {

        if (userService.changeForgottenPassword(userForgottenPasswordDto)) {
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();
    }

    @PatchMapping("/user/changePassword")
    ResponseEntity<?> changePassword(@RequestHeader(name = "Authorization") String token, @RequestBody UserChangePasswordDto userChangePasswordDto) {

        if (userService.changePassword(token, userChangePasswordDto)) {
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();
    }

    @PatchMapping("/user/changeQuestion")
    ResponseEntity<?> changeQuestion(@RequestHeader(name = "Authorization") String token, @RequestBody UserChangeQuestionDto userChangeQuestionDto) {

        if (userService.changeQuestion(token, userChangeQuestionDto)) {
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();
    }
}
