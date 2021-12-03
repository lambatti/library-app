DROP TABLE IF EXISTS users;
CREATE TABLE users
(
    id                  SERIAL PRIMARY KEY,
    first_name          VARCHAR(100) NOT NULL,
    last_name           VARCHAR(100) NOT NULL,
    email               VARCHAR(100) NOT NULL,
    register_question   INT          NOT NULL,
    gender              INT          NOT NULL,
    birth_date          DATE         NOT NULL,
    create_account_date DATE
);

ALTER TABLE books
    ADD COLUMN user_id INT NULL;
ALTER TABLE books
    ADD FOREIGN KEY (user_id) REFERENCES users (id);