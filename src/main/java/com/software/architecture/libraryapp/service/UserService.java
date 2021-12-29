package com.software.architecture.libraryapp.service;

import com.software.architecture.libraryapp.adapter.SqlUserRepository;
import com.software.architecture.libraryapp.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class UserService implements UserDetailsService {

    private final SqlUserRepository userRepository;

    public UserService(SqlUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User tempUser = userRepository.findByEmail(email);

        if (tempUser == null) {
            throw new UsernameNotFoundException("User not found");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();

        tempUser.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role)));

        org.springframework.security.core.userdetails.User user =
                new org.springframework.security.core.userdetails.User(
                        tempUser.getEmail(), tempUser.getPassword(),
                        authorities);

        return user;
    }
}
