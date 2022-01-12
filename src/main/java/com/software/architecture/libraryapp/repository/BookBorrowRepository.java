package com.software.architecture.libraryapp.repository;

import com.software.architecture.libraryapp.model.BookBorrow;

import java.time.LocalDate;
import java.util.List;

public interface BookBorrowRepository {

    BookBorrow save(BookBorrow bookBorrow);

    void updateById(Integer userId, Integer bookId, Integer days);

    void delete(Integer userId, Integer bookId);

    LocalDate getReturnDate(Integer bookId);

    List<BookBorrow> getAllByUserId(Integer userId);
}
