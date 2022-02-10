package com.software.architecture.libraryapp.service;

import com.software.architecture.libraryapp.adapter.SqlUserRepository;
import com.software.architecture.libraryapp.model.RegistrationQuestions;
import com.software.architecture.libraryapp.model.User;
import com.software.architecture.libraryapp.model.dto.*;
import com.software.architecture.libraryapp.util.JwtUtil;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class UserService implements UserDetailsService {

    private final SqlUserRepository userRepository;
    private final BookBorrowService bookBorrowService;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public UserService(SqlUserRepository userRepository, BookBorrowService bookBorrowService,
                       PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.bookBorrowService = bookBorrowService;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<UserSummaryDto> createUserSummaryDto(String token) {

        Optional<User> user = getUserByToken(token);

        if (user.isPresent()) {
            User userData = user.get();
            return Optional.of(new UserSummaryDto(
                    userData.getFirstName(),
                    userData.getLastName(),
                    userData.getEmail(),
                    userData.getGender().toString(),
                    userData.getBirthDate(),
                    userData.getAccountCreationDate()
            ));
        }

        return Optional.empty();
    }

    public void registerUser(UserRegistrationDto userRegistrationDto) {

        Set<String> roles;

        if (userRegistrationDto.getRoles() != null) {
            roles = userRegistrationDto.getRoles();
        } else {
            roles = new HashSet<>();
        }

        roles.add("ROLE_USER");
        String rolesArrayInString = String.join(",", roles.toArray(new String[0]));

        String encodedPassword = passwordEncoder.encode(userRegistrationDto.getPassword());

        userRepository.save(
                userRegistrationDto.getFirstName(),
                userRegistrationDto.getLastName(),
                userRegistrationDto.getEmail(),
                encodedPassword,
                rolesArrayInString,
                userRegistrationDto.getRegistrationQuestion().name(),
                userRegistrationDto.getRegistrationQuestionAnswer(),
                userRegistrationDto.getGender().name(),
                userRegistrationDto.getBirthDate(),
                LocalDate.now()
        );
    }


    public User setPassword(User user, String newPassword) {
        String encodedPassword = passwordEncoder.encode(newPassword);
        userRepository.setPassword(user.getId(), encodedPassword);
        return userRepository.findById(user.getId()).get();
    }

    public boolean doesThePasswordMatch(String password, User user) {
        return passwordEncoder.matches(password, user.getPassword());
    }

    public void setQuestion(User user, RegistrationQuestions question, String answer) {
        userRepository.changeQuestion(user.getId(), question.name(), answer);
    }

    public Optional<Set<UserBorrowedBookDto>> getBorrowedBooks(String token) {

        Optional<User> user = getUserByToken(token);

        return user.map(bookBorrowService::getBorrowedBooks);
    }

    private String extractEmailFromToken(String token) {
        token = jwtUtil.removeBearer(token);
        return jwtUtil.extractEmail(token);
    }

    public Optional<User> getUserByToken(String token) {
        String email = extractEmailFromToken(token);
        return userRepository.findByEmail(email);
    }

    private boolean doesTheRegistrationQuestionMatch(User user, RegistrationQuestions question, String answer) {
        return user.getRegistrationQuestion().equals(question) && user.getRegistrationQuestionAnswer().equals(answer);
    }

    public boolean changeForgottenPassword(UserForgottenPasswordDto userForgottenPasswordDto) {

        String email = userForgottenPasswordDto.getEmail();
        Optional<User> user = getUserByEmail(email);

        if (user.isEmpty()
                || !userForgottenPasswordDto.getNewPassword()
                .equals(userForgottenPasswordDto.getNewPasswordConfirmation())
                || !doesTheRegistrationQuestionMatch(user.get(), userForgottenPasswordDto.getQuestion(),
                userForgottenPasswordDto.getAnswer())) {
            return false;
        }

        setPassword(user.get(), userForgottenPasswordDto.getNewPassword());
        return true;
    }

    public boolean changePassword(String token, UserChangePasswordDto userChangePasswordDto) {

        if (!userChangePasswordDto.getNewPassword().equals(userChangePasswordDto.getNewPasswordConfirmation())) {
            return false;
        }

        Optional<User> user = getUserByToken(token);

        if (user.isEmpty() || !doesThePasswordMatch(userChangePasswordDto.getOldPassword(), user.get())) {
            return false;
        }

        setPassword(user.get(), userChangePasswordDto.getNewPassword());
        return true;

    }

    public boolean changeQuestion(String token, UserChangeQuestionDto userChangeQuestionDto) {

        Optional<User> user = getUserByToken(token);

        if (user.isEmpty() || !doesThePasswordMatch(userChangeQuestionDto.getPassword(), user.get())) {
            return false;
        }

        setQuestion(user.get(), userChangeQuestionDto.getQuestion(), userChangeQuestionDto.getAnswer());
        return true;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> tempUser = userRepository.findByEmail(email);

        if (tempUser.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        } else {
            User user = tempUser.get();
            List<GrantedAuthority> authorities = new ArrayList<>();

            user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role)));

            return new org.springframework.security.core.userdetails.User(
                    user.getEmail(), user.getPassword(),
                    authorities);
        }
    }
}
