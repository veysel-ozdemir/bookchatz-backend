package com.internship.blog.repository;

import com.internship.blog.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {
    Optional<Book> findBookByTitleIgnoreCaseAndAuthorNameIgnoreCase(String title, String authorName);
}
