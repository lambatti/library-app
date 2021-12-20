package com.software.architecture.libraryapp.model;

import java.time.LocalDate;

public interface BookBorrowRepository {

    BookBorrow save(BookBorrow bookBorrow);

    BookBorrow updateById(String bookId, LocalDate returnDate);

    BookBorrow deleteById(String bookId);

    LocalDate getReturnDate(String bookId);
}
