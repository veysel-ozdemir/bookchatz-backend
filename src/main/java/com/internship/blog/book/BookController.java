package com.internship.blog.book;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    // create new book
    @PostMapping("/new-book")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Book createBook(@Valid @RequestBody BookDto bookDto) {
        return bookService.createBook(bookDto);
    }

    // get all books
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Book> getAllBooks() {
        return bookService.getBooks();
    }

    // get book by id
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Book getBookById(@PathVariable("id") Integer id) {
        return bookService.getBookById(id);
    }

    // delete book by id
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteBookById(@PathVariable("id") Integer id) {
        return bookService.deleteBookById(id);
    }

    // exception handler of invalid parameters
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        var errors = new HashMap<String, String>();
        exception.getBindingResult().getAllErrors().forEach(error -> {
            var fieldName = ((FieldError) error).getField();
            var errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
