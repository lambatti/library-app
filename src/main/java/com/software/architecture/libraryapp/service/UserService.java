package com.software.architecture.libraryapp.service;

import com.software.architecture.libraryapp.adapter.SqlUserRepository;
import com.software.architecture.libraryapp.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final SqlUserRepository userRepository;

    public UserService(SqlUserRepository userRepository) {
        this.userRepository = userRepository;
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

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> tempUser = userRepository.findByEmail(email);

        if (tempUser == null) {
            throw new UsernameNotFoundException("User not found");
        }
        else {
            User user = tempUser.get();
            List<GrantedAuthority> authorities = new ArrayList<>();

            user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role)));

            org.springframework.security.core.userdetails.User userDetails =
                    new org.springframework.security.core.userdetails.User(
                            user.getEmail(), user.getPassword(),
                            authorities);

            return userDetails;
        }
    }
}
