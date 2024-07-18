DO $$
BEGIN
CREATE SEQUENCE post_seq START 1;

CREATE TABLE IF NOT EXISTS post (
    post_id INT DEFAULT nextval('post_seq') PRIMARY KEY,
    user_id INTEGER NOT NULL,
    book_id INTEGER NOT NULL,
    review TEXT,
    commit_date DATE,
    CONSTRAINT fk_user
        FOREIGN KEY(user_id)
        REFERENCES users(user_id)
        ON DELETE CASCADE,
    CONSTRAINT fk_book
        FOREIGN KEY(book_id)
        REFERENCES book(book_id)
        ON DELETE CASCADE
    );
EXCEPTION
    WHEN duplicate_object THEN null;
END $$;
