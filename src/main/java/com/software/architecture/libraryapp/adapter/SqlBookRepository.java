package com.software.architecture.libraryapp.adapter;

import com.software.architecture.libraryapp.model.Book;
import com.software.architecture.libraryapp.repository.BookRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface SqlBookRepository extends BookRepository, JpaRepository<Book, Integer> {
    @Override
    @Query(nativeQuery = true, value = "SELECT COUNT(*) > 0 FROM books WHERE id = :id")
    boolean existsById(@Param("id") Integer id);

}