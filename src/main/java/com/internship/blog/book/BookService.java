package com.internship.blog.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public Book getBookByTitleAndAuthorName(String title, String authorName) {
        return bookRepository.findBookByTitleContainingIgnoreCaseAndAuthorNameContainingIgnoreCase(title, authorName).orElse(null);
    }

    public Book createBook(BookDto bookDto) {
        Book book = bookMapper.toBook(bookDto);
        bookRepository.save(book);
        return book; // todo: change the return data later (ResponseDto)
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
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
