package com.software.architecture.libraryapp.adapter;

import com.software.architecture.libraryapp.model.Book;
import com.software.architecture.libraryapp.repository.BookRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface SqlBookRepository extends BookRepository, JpaRepository<Book, Integer> {
    @Override
    @Query(nativeQuery = true, value = "SELECT COUNT(*) > 0 FROM books WHERE id = :id")
    boolean existsById(@Param("id") Integer id);

    @Override
    List<Book> findByIsAvailable(boolean available);

    @Override
    Optional<Book> findById(Integer id);
}