CREATE SEQUENCE IF NOT EXISTS users_seq START 1;

CREATE TABLE IF NOT EXISTS users (
    user_id BIGINT DEFAULT nextval('users_seq') PRIMARY KEY,
    fullname VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    photo_url VARCHAR(255)
);