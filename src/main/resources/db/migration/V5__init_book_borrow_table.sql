DROP TABLE IF EXISTS book_borrow;
CREATE TABLE book_borrow
(
    id              SERIAL PRIMARY KEY,
    user_id         INT,
    book_id         INT,
    borrow_date     DATE,
    return_date     DATE,
    CONSTRAINT user_fk FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    CONSTRAINT book_fk FOREIGN KEY (book_id) REFERENCES books (id) ON DELETE CASCADE
);