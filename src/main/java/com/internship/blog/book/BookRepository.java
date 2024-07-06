package com.internship.blog.book;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {
    Optional<Book> findBookByTitleContainingIgnoreCaseAndAuthorNameContainingIgnoreCase(String title, String authorName);
}
