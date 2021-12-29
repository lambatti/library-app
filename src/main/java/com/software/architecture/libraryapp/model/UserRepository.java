package com.software.architecture.libraryapp.model;

public interface UserRepository {
    User findByEmail(String email);

    User save(User user);
}
