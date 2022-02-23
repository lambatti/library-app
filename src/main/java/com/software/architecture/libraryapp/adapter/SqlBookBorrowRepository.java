package com.software.architecture.libraryapp.adapter;

import com.software.architecture.libraryapp.model.BookBorrow;
import com.software.architecture.libraryapp.repository.BookBorrowRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface SqlBookBorrowRepository extends BookBorrowRepository, JpaRepository<BookBorrow, Integer> {

    @Override
    BookBorrow save(BookBorrow bookBorrow);

    @Override
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM book_borrow WHERE user_id = ?1 AND book_id = ?2")
    void delete(Integer userId, Integer bookId);

    @Override
    @Query(nativeQuery = true, value = "SELECT return_date FROM book_borrow WHERE book_id = ?1")
    LocalDate getReturnDate(Integer bookId);

    @Override
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE book_borrow SET return_date = return_date+?3 WHERE user_id = ?1 AND book_id = ?2")
    void updateById(Integer userId, Integer bookId, Integer days);

    @Override
    @Query(nativeQuery = true, value = "SELECT * FROM book_borrow WHERE user_id = ?1 " +
            "ORDER BY return_date, ( SELECT MIN(title) FROM books WHERE book_borrow.book_id = books.id)")
    List<BookBorrow> getAllByUserId(Integer userId);

    @Override
    @Query(nativeQuery = true, value = "SELECT * FROM book_borrow WHERE user_id = ?1 AND book_id = ?2")
    Optional<BookBorrow> findById(Integer userId, Integer bookId);
}
