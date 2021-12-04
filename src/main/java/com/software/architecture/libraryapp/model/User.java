package com.software.architecture.libraryapp.model;

import javax.persistence.*;
import java.time.LocalDate;
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
    // TODO: enum register question DONE
    private RegistrationQuestions registrationQuestion;
    private String registrationQuestionAnswer;
    // TODO: enum gender DONE
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
