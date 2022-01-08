package com.software.architecture.libraryapp.adapter;

import com.software.architecture.libraryapp.model.BookBorrow;
import com.software.architecture.libraryapp.repository.BookBorrowRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.time.LocalDate;

public interface SqlBookBorrowRepository extends BookBorrowRepository, JpaRepository<BookBorrow, Integer> {

    @Override
    BookBorrow save(BookBorrow bookBorrow);

    @Override
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value="DELETE FROM book_borrow WHERE user_id = ?1 AND book_id = ?2")
    void delete(Integer userId, Integer bookId);

    @Override
    @Query(nativeQuery = true, value="SELECT return_date FROM book_borrow WHERE book_id = ?1")
    LocalDate getReturnDate(Integer bookId);

    @Override
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value="UPDATE book_borrow SET return_date = return_date+?3 WHERE user_id = ?1 AND book_id = ?2")
    void updateById(Integer userId, Integer bookId, Integer days);
}
