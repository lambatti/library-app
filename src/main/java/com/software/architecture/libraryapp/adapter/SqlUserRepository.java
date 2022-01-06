package com.software.architecture.libraryapp.adapter;

import com.software.architecture.libraryapp.model.User;
import com.software.architecture.libraryapp.repository.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SqlUserRepository extends UserRepository, JpaRepository<User,Integer> {

    @Override
    Optional<User> findByEmail(String email);

    @Override
    User save(User user);
}
