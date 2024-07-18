DO $$
BEGIN
CREATE SEQUENCE book_seq START 1;

CREATE TYPE booktype AS ENUM (
        'HISTORY',
        'ADVENTURE',
        'PERSONAL',
        'SCIENCE',
        'THRILLER',
        'HORROR',
        'CLASSIC',
        'HUMOR',
        'ROMANCE',
        'RELIGION'
    );

CREATE CAST (varchar AS booktype) WITH INOUT AS IMPLICIT;

EXCEPTION
    WHEN duplicate_object THEN null;
END $$;

CREATE TABLE IF NOT EXISTS book (
    book_id INT DEFAULT nextval('book_seq') PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author_name VARCHAR(255) NOT NULL,
    book_type booktype NOT NULL,
    photo_url VARCHAR(255)
);
