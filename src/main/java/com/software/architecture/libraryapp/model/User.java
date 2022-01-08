package com.software.architecture.libraryapp.model;

import com.software.architecture.libraryapp.model.converter.ListToArrayConveter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Book> bookSet;

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @Column(name="roles", columnDefinition = "text[]")
    @Convert(converter = ListToArrayConveter.class)
    private List<String> roles;

    // TODO: enum register question DONE
    @Enumerated(EnumType.STRING)
    private RegistrationQuestions registrationQuestion;

    private String registrationQuestionAnswer;

    // TODO: enum gender DONE
    @Enumerated(EnumType.STRING)
    private Genders gender;

    private LocalDate birthDate;
    // TODO: how to insert it to table?
    private LocalDate accountCreationDate = LocalDate.now();

    public User() {

    }

    public void setAccountCreationDate(LocalDate createAccountDate) {
        this.accountCreationDate = createAccountDate;
    }

    public Integer getId() {
        return id;
    }

    public Set<Book> getBookSet() {
        return bookSet;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public RegistrationQuestions getRegistrationQuestion() {
        return registrationQuestion;
    }

    public String getRegistrationQuestionAnswer() {
        return registrationQuestionAnswer;
    }

    public Genders getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getAccountCreationDate() {
        return accountCreationDate;
    }
}
