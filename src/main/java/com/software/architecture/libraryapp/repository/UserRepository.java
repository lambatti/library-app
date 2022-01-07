package com.software.architecture.libraryapp.repository;

import com.software.architecture.libraryapp.model.User;

import java.time.LocalDate;
import java.util.Optional;

public interface UserRepository {

    Optional<User> findByEmail(String email);

    void save(String firstName, String lastName, String email, String password, String roles,
              String registrationQuestion, String registrationQuestionAnswer,
              String gender, LocalDate birthDate, LocalDate accountCreationDate);

    void changePassword(Integer id, String newPassword);

    void changeQuestion(Integer id, String registrationQuestion, String registrationQuestionAnswer);
}
