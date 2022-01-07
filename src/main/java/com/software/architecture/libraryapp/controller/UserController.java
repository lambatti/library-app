package com.software.architecture.libraryapp.controller;

import com.software.architecture.libraryapp.config.PasswordEncoderBean;
import com.software.architecture.libraryapp.model.Book;
import com.software.architecture.libraryapp.model.User;
import com.software.architecture.libraryapp.model.dto.UserChangePasswordDto;
import com.software.architecture.libraryapp.model.dto.UserChangeQuestionDto;
import com.software.architecture.libraryapp.model.dto.UserRegistrationDto;
import com.software.architecture.libraryapp.model.dto.UserSummaryDto;
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
    private final PasswordEncoderBean passwordEncoder;

    public UserController(UserService userService, JwtUtil jwtTokenUtil, PasswordEncoderBean passwordEncoder) {
        this.userService = userService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.passwordEncoder = passwordEncoder;
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

    @GetMapping("/user/summary")
    public ResponseEntity<UserSummaryDto> getUserSummary(@RequestHeader(name="Authorization") String token) {

        token = jwtTokenUtil.removeBearer(token);
        log.info("token: {}", token);
        String email = jwtTokenUtil.extractEmail(token);
        log.info("email: {}", email);

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
    public ResponseEntity<?> registerUser(@RequestBody UserRegistrationDto userRegistrationDto) {
        // TODO: 06.01.2022 - add support for ResponseEntity<User> or <UserRegistrationDto>
        userService.registerUser(userRegistrationDto);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/user/changePassword")
    public ResponseEntity<User> changePassowrd(@RequestHeader(name="Authorization") String token, @RequestBody UserChangePasswordDto userChangePasswordDto) {

        log.info(userChangePasswordDto.getOldPassword() + " " + userChangePasswordDto.getNewPassword() + " "
        + userChangePasswordDto.getNewPasswordConfirmation());

        if(!userChangePasswordDto.getNewPassword().equals(userChangePasswordDto.getNewPasswordConfirmation())) {
            log.info("new password and new password confirmation do not match");
            return ResponseEntity.badRequest().build();
        }

        token = jwtTokenUtil.removeBearer(token);
        log.info("token: {}", token);
        String email = jwtTokenUtil.extractEmail(token);
        log.info("email: {}", email);

        Optional<User> user = userService.getUserByEmail(email);

        if(user.isEmpty()) {
            log.info("user not found");
            return ResponseEntity.badRequest().build();
        }
        else {
            User userData = user.get();

            //boolean doesPassswordMatch = passwordEncoder.passwordEncoder().matches(
            //        userChangePasswordDto.getOldPassword(), userData.getPassword());

            boolean doesPasswordMatch = userService.doesThePasswordMatch(
                    userChangePasswordDto.getOldPassword(), userData);

            if (!doesPasswordMatch) {
                log.info("old password does not match");
                return ResponseEntity.badRequest().build();
            }
            else {
                User userWithNewPassword = userService.changePassword(userData, userChangePasswordDto.getNewPassword());
                return ResponseEntity.ok(userWithNewPassword);
            }
        }
    }

    @PatchMapping("/user/changeQuestion")
    public ResponseEntity<User> changeQuestion(@RequestHeader(name="Authorization") String token, @RequestBody UserChangeQuestionDto userChangeQuestionDto) {

        token = jwtTokenUtil.removeBearer(token);
        log.info("token: {}", token);
        String email = jwtTokenUtil.extractEmail(token);
        log.info("email: {}", email);

        log.info(userChangeQuestionDto.getPassword() + " " + userChangeQuestionDto.getQuestion() + " " + userChangeQuestionDto.getAnswer());

        Optional<User> user = userService.getUserByEmail(email);

        if(user.isEmpty()) {
            log.info("user not found");
            return ResponseEntity.badRequest().build();
        }
        else {
            User userData = user.get();
            boolean doesPasswordMatch = userService.doesThePasswordMatch(userChangeQuestionDto.getPassword(), userData);

            log.info("doesPasswordMatch: {}", doesPasswordMatch);

            if (!doesPasswordMatch) {
                log.info("password does not match");
                return ResponseEntity.badRequest().build();
            }
            else {
                User userWithNewQuestion = userService.changeQuestion(userData, userChangeQuestionDto.getQuestion(), userChangeQuestionDto.getAnswer());
                return ResponseEntity.ok(userWithNewQuestion);
            }
        }
    }


}
