package com.software.architecture.libraryapp.repository;

import com.software.architecture.libraryapp.model.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByEmail(String email);
    User save(User user);
}
