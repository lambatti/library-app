package com.software.architecture.libraryapp.controller;

import com.software.architecture.libraryapp.model.Book;
import com.software.architecture.libraryapp.model.User;
import com.software.architecture.libraryapp.model.dto.UserChangePasswordDto;
import com.software.architecture.libraryapp.model.dto.UserChangeQuestionDto;
import com.software.architecture.libraryapp.model.dto.UserRegistrationDto;
import com.software.architecture.libraryapp.model.dto.UserSummaryDto;
import com.software.architecture.libraryapp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    ResponseEntity<Optional<User>> getUserById(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping("/user/books")
    ResponseEntity<Set<Book>> getUserBooks(@RequestHeader(name="Authorization") String token) {

        String email = userService.extractEmailFromToken(token);

        Optional<User> user = userService.getUserByEmail(email);

        if(user.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        else {
            return ResponseEntity.ok(user.get().getBookSet());
        }
    }

    @GetMapping("/user/summary")
    ResponseEntity<UserSummaryDto> getUserSummary(@RequestHeader(name="Authorization") String token) {

        String email = userService.extractEmailFromToken(token);

        Optional<User> user = userService.getUserByEmail(email);

        if(user.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        else {
            User userData = user.get();
            UserSummaryDto userDto = userService.createUserSummaryDto(userData);
            return ResponseEntity.ok(userDto);
        }
    }

    @PostMapping("/register")
    ResponseEntity<?> registerUser(@RequestBody UserRegistrationDto userRegistrationDto) {

        String email = userRegistrationDto.getEmail();

        Optional<User> user = userService.getUserByEmail(email);

        if(user.isPresent()) {
            return ResponseEntity.badRequest().build();
        }

        // TODO: 06.01.2022 - add support for ResponseEntity<User> or <UserRegistrationDto>
        userService.registerUser(userRegistrationDto);

        return ResponseEntity.ok().build();
    }

    @PatchMapping("/user/changePassword")
    ResponseEntity<User> changePassword(@RequestHeader(name="Authorization") String token, @RequestBody UserChangePasswordDto userChangePasswordDto) {

        if(!userChangePasswordDto.getNewPassword().equals(userChangePasswordDto.getNewPasswordConfirmation())) {
            return ResponseEntity.badRequest().build();
        }

        String email = userService.extractEmailFromToken(token);

        Optional<User> user = userService.getUserByEmail(email);

        if(user.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        else {
            User userData = user.get();

            boolean doesPasswordMatch = userService.doesThePasswordMatch(
                    userChangePasswordDto.getOldPassword(), userData);

            if (!doesPasswordMatch) {
                return ResponseEntity.badRequest().build();
            }
            else {
                User userWithNewPassword = userService.changePassword(userData, userChangePasswordDto.getNewPassword());
                return ResponseEntity.ok(userWithNewPassword);
            }
        }
    }

    @PatchMapping("/user/changeQuestion")
    ResponseEntity<User> changeQuestion(@RequestHeader(name="Authorization") String token, @RequestBody UserChangeQuestionDto userChangeQuestionDto) {

        String email = userService.extractEmailFromToken(token);

        Optional<User> user = userService.getUserByEmail(email);

        if(user.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        else {
            User userData = user.get();
            boolean doesPasswordMatch = userService.doesThePasswordMatch(userChangeQuestionDto.getPassword(), userData);

            if (!doesPasswordMatch) {
                return ResponseEntity.badRequest().build();
            }
            else {
                User userWithNewQuestion = userService.changeQuestion(userData, userChangeQuestionDto.getQuestion(), userChangeQuestionDto.getAnswer());
                return ResponseEntity.ok(userWithNewQuestion);
            }
        }
    }
}
