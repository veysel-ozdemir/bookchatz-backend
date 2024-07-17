package com.internship.blog.repository;

import com.internship.blog.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {
    Optional<Book> findBookByTitleIgnoreCaseAndAuthorNameIgnoreCase(String title, String authorName);

    @Query("SELECT b FROM Book b WHERE b.id IN (1,2,3,4,5,6,7,8,9,10,11,12,13)")
    List<Book> findTopBooks();
}
