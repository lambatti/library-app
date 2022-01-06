package com.software.architecture.libraryapp.service;

import com.software.architecture.libraryapp.adapter.SqlUserRepository;
import com.software.architecture.libraryapp.config.PasswordEncoderBean;
import com.software.architecture.libraryapp.model.Genders;
import com.software.architecture.libraryapp.model.RegistrationQuestions;
import com.software.architecture.libraryapp.model.User;
import com.software.architecture.libraryapp.model.dto.UserRegistrationDto;
import com.software.architecture.libraryapp.model.dto.UserSummaryDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService implements UserDetailsService {

    private final SqlUserRepository userRepository;
    private final PasswordEncoderBean passwordEncoder;

    public UserService(SqlUserRepository userRepository, PasswordEncoderBean passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
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

        log.info(
                userRegistrationDto.getRegistrationQuestion().name()
        );

        log.info(
                userRegistrationDto.getFirstName() + " " +
                userRegistrationDto.getLastName() + " " +
                userRegistrationDto.getEmail() + " " +
                encodedPassword + " " +
                rolesArrayInString + " " +
                userRegistrationDto.getRegistrationQuestion().name() + " " +
                userRegistrationDto.getRegistrationQuestionAnswer() + " " +
                userRegistrationDto.getGender().name() + " " +
                userRegistrationDto.getBirthDate()  + " " +
                LocalDate.now()
        );

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
