package com.internship.blog.service;

import com.internship.blog.dto.BookDto;
import com.internship.blog.model.Book;
import com.internship.blog.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public Book getBookByTitleAndAuthorName(String title, String authorName) {
        return bookRepository.findBookByTitleIgnoreCaseAndAuthorNameIgnoreCase(title, authorName).orElse(null);
    }

    public Book createBook(BookDto bookDto) {
        Book book = bookMapper.toBook(bookDto);
        bookRepository.save(book);
        return book;
    }

    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    public ResponseEntity<Object> getBooks() {
        return ResponseEntity.ok(bookRepository.findAll().stream().map(bookMapper::toBookResponseDto));
    }

    public Book getBookById(Integer id) {
        return bookRepository.findById(id).orElse(null);
    }

    public String deleteBookById(Integer id) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book == null) {
            return "Book not found with id: " + id;
        }
        bookRepository.deleteById(id);
        return "Book with id " + id + " was deleted";
    }
}
