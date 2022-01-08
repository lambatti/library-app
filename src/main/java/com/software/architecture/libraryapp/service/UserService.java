package com.software.architecture.libraryapp.service;

import com.software.architecture.libraryapp.adapter.SqlBookBorrowRepository;
import com.software.architecture.libraryapp.adapter.SqlUserRepository;
import com.software.architecture.libraryapp.config.PasswordEncoderBean;
import com.software.architecture.libraryapp.model.Book;
import com.software.architecture.libraryapp.model.BookBorrow;
import com.software.architecture.libraryapp.model.RegistrationQuestions;
import com.software.architecture.libraryapp.model.User;
import com.software.architecture.libraryapp.model.dto.UserBorrowedBookDto;
import com.software.architecture.libraryapp.model.dto.UserRegistrationDto;
import com.software.architecture.libraryapp.model.dto.UserSummaryDto;
import com.software.architecture.libraryapp.util.JwtUtil;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class UserService implements UserDetailsService {

    private final SqlUserRepository userRepository;
    private final SqlBookBorrowRepository bookBorrowRepository;
    private final PasswordEncoderBean passwordEncoder;
    private final JwtUtil jwtUtil;

    public UserService(SqlUserRepository userRepository, SqlBookBorrowRepository bookBorrowRepository, PasswordEncoderBean passwordEncoder, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.bookBorrowRepository = bookBorrowRepository;
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

    public UserSummaryDto createUserSummaryDto(User user) {

        UserSummaryDto userDto = new UserSummaryDto(
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getGender().toString(),
                user.getBirthDate(),
                user.getAccountCreationDate()
        );

        return userDto;
    }

    public void registerUser(UserRegistrationDto userRegistrationDto) {

        // TODO: 06.01.2022 add support for user registration with different roles (admin, user, etc.)
        ArrayList<String> roles = new ArrayList<>();
        roles.add("ROLE_USER");
        String rolesArrayInString = String.join(",", roles.toArray(new String[0]));

        String encodedPassword = passwordEncoder.passwordEncoder().encode(userRegistrationDto.getPassword());

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

        //return userRepository.findByEmail(userRegistrationDto.getEmail());
    }


    public User changePassword(User user, String newPassword) {
        String encodedPassword = passwordEncoder.passwordEncoder().encode(newPassword);
        userRepository.changePassword(user.getId(), encodedPassword);
        return userRepository.findById(user.getId()).get();
    }

    public boolean doesThePasswordMatch(String password, User user) {
        return passwordEncoder.passwordEncoder().matches(password, user.getPassword());
    }

    // TODO: 07.01.2022 registration question is not refreshed with the return (but the function works)
    public User changeQuestion(User user, RegistrationQuestions question, String answer) {
        userRepository.changeQuestion(user.getId(), question.name(), answer);
        return userRepository.findById(user.getId()).get();
    }

    public Set<UserBorrowedBookDto> getBorrowedBooks(User user) {
        List<BookBorrow> bookBorrows = bookBorrowRepository.getAllByUserId(user.getId());

        Set<UserBorrowedBookDto> userBorrowedBooksSet = new HashSet<>();

        for ( BookBorrow bookBorrow : bookBorrows ) {
            Book book = bookBorrow.getBook();

            UserBorrowedBookDto userBorrowedBook = new UserBorrowedBookDto(
                    book.getCoverUrl(),
                    book.getTitle(),
                    book.getAuthor(),
                    book.getPublicationDate(),
                    book.getGenre().toString(),
                    book.isHardcover(),
                    bookBorrow.getBorrowDate().toString(),
                    bookBorrow.getReturnDate().toString()
                    );

            userBorrowedBooksSet.add(userBorrowedBook);
        }

        return userBorrowedBooksSet;
    }

    public String extractEmailFromToken(String token) {
        token = jwtUtil.removeBearer(token);
        return jwtUtil.extractEmail(token);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> tempUser = userRepository.findByEmail(email);

        if (tempUser.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }
        else {
            User user = tempUser.get();
            List<GrantedAuthority> authorities = new ArrayList<>();

            user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role)));

            return new org.springframework.security.core.userdetails.User(
                    user.getEmail(), user.getPassword(),
                    authorities);
        }
    }
}
