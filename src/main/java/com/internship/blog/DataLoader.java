package com.internship.blog;

import com.internship.blog.book.BookDto;
import com.internship.blog.book.BookService;
import com.internship.blog.book.BookType;
import com.internship.blog.user.UserDto;
import com.internship.blog.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DataLoader implements CommandLineRunner {

    private final BookService bookService;
    private final UserService userService;

    @Override
    public void run(String... args) throws Exception {
        // create 1 user
        UserDto userDto = new UserDto(
                "John Dave",
                "123",
                "john.dave@mail.com",
                "https://www.foo.bar/baz"
        );
        userService.register(userDto);

        // create 10 books
        for (int i = 1; i <= 10; i++) {
            BookDto bookDto = new BookDto(
                    "Title " + i,
                    "Author " + i,
                    BookType.values()[i % BookType.values().length], // Pick a book type cyclically
                    "https://example.com/book" + i + ".jpg"
            );
            bookService.createBook(bookDto);
        }
        System.out.println("\n\nInitialized data from DataLoader.\n\n");
    }
}
