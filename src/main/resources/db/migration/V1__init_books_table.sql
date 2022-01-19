DROP TABLE IF EXISTS books;
CREATE TABLE books
(
    id               SERIAL PRIMARY KEY,
    cover_url        VARCHAR(200) NOT NULL,
    title            VARCHAR(200) NOT NULL,
    author           VARCHAR(200) NOT NULL,
    publication_date VARCHAR(200) NOT NULL,
    genre            VARCHAR(100) NOT NULL,
    is_hardcover     BOOLEAN      NOT NULL,
    count            INT,
    is_available     BOOLEAN,
    description      VARCHAR(500) NOT NULL
);