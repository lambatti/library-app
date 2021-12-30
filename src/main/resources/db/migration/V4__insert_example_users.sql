INSERT INTO users (first_name, last_name, email, password, roles, registration_question, registration_question_answer, gender, birth_date, account_creation_date)
VALUES ('Adam', 'Nowak', 'adam@gmail.com', '$2a$12$eDfafkZsp934IWSEOEe3VeHVkFjJMUPHz8C3ZWz..TNkxY9SMpyo2', ARRAY ['ROLE_ADMIN', 'ROLE_USER'], 'ANIMAL', 'kot', 'M', '1973-06-21', '2021-12-04'),
       ('Kate', 'Smith', 'kate@wp.pl', '$2a$12$P9zsBulZNVm7YpVpEHRe/.zeqYbLg84YAXHOADl5uuXKCW3LWBjrS', ARRAY ['ROLE_USER'], 'FRIENDS_NAME', 'Jan', 'F', '2000-05-19', '2021-11-02'),
       ('John', 'Holmes', 'holmes454@gmail.com', '$2a$12$R.D0Xh39q9rG.B2bl56QHO1tmENoGfCpKSlZgH8fjz7fDWoxZhUJ6', ARRAY ['ROLE_USER'], 'SANDWICH', 'ser', 'U', '1992-06-02', '2021-09-04')
