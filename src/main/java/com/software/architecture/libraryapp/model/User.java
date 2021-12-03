package com.software.architecture.libraryapp.model;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    // TODO: enum register question
    private Integer registerQuestion;
    // TODO: enum gender
    private Integer gender;
    private LocalDate birthDate;
    // TODO: how to insert it to table?
    private LocalDate createAccountDate = LocalDate.now();

    public User() {

    }

    public void setCreateAccountDate(LocalDate createAccountDate) {
        this.createAccountDate = createAccountDate;
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

    public Integer getRegisterQuestion() {
        return registerQuestion;
    }

    public Integer getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getCreateAccountDate() {
        return createAccountDate;
    }
}
