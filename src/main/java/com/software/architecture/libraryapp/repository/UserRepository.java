package com.software.architecture.libraryapp.repository;

import com.software.architecture.libraryapp.model.User;

public interface UserRepository {
    User findByEmail(String email);

    User save(User user);
}
