package com.software.architecture.libraryapp.repository;

import com.software.architecture.libraryapp.model.BookBorrow;

import java.time.LocalDate;

public interface BookBorrowRepository {

    BookBorrow save(BookBorrow bookBorrow);

    BookBorrow updateById(String bookId, LocalDate returnDate);

    void delete(Integer userId, Integer bookId);

    LocalDate getReturnDate(String bookId);
}
