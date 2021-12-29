package com.software.architecture.libraryapp.adapter;

import com.software.architecture.libraryapp.model.BookBorrow;
import com.software.architecture.libraryapp.repository.BookBorrowRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface SqlBookBorrowRepository extends BookBorrowRepository, JpaRepository<BookBorrow, Integer> {

    @Override
    @Query(nativeQuery = true, value="SELECT return_date FROM book_borrow WHERE book_borrow.book_id = ?1")
    LocalDate getReturnDate(String bookId);

    @Override
    @Query(nativeQuery = true, value="UPDATE book_borrow SET return_date = ?2 WHERE book_borrow.book_id = ?1")
    BookBorrow updateById(String bookId, LocalDate returnDate);
}
