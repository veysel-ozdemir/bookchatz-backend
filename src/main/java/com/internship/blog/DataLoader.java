package com.internship.blog;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.internship.blog.book.BookService;
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
                "http://www.john.dave/profile.jpg"
        );
        userService.register(userDto);

        // create 10 books
        String jsonList = """
                [
                    {
                        "title": "History of the World",
                        "authorName": "John Doe",
                        "bookType": "HISTORY",
                        "photoUrl": "http://example.com/photo1.jpg"
                    },
                    {
                        "title": "Adventures in the Jungle",
                        "authorName": "Jane Smith",
                        "bookType": "ADVENTURE",
                        "photoUrl": "http://example.com/photo2.jpg"
                    },
                    {
                        "title": "Personal Growth",
                        "authorName": "Emily Johnson",
                        "bookType": "PERSONAL",
                        "photoUrl": "http://example.com/photo3.jpg"
                    },
                    {
                        "title": "Science Facts",
                        "authorName": "Michael Brown",
                        "bookType": "SCIENCE",
                        "photoUrl": "http://example.com/photo4.jpg"
                    },
                    {
                        "title": "Thrilling Tales",
                        "authorName": "Chris Davis",
                        "bookType": "THRILLER",
                        "photoUrl": "http://example.com/photo5.jpg"
                    },
                    {
                        "title": "Horror Stories",
                        "authorName": "Patricia Wilson",
                        "bookType": "HORROR",
                        "photoUrl": "http://example.com/photo6.jpg"
                    },
                    {
                        "title": "Classic Literature",
                        "authorName": "Robert Moore",
                        "bookType": "CLASSIC",
                        "photoUrl": "http://example.com/photo7.jpg"
                    },
                    {
                        "title": "Humor and Laughs",
                        "authorName": "Mary Taylor",
                        "bookType": "HUMOR",
                        "photoUrl": "http://example.com/photo8.jpg"
                    },
                    {
                        "title": "Romantic Novels",
                        "authorName": "William Anderson",
                        "bookType": "ROMANCE",
                        "photoUrl": "http://example.com/photo9.jpg"
                    },
                    {
                        "title": "Religious Texts",
                        "authorName": "Linda Thomas",
                        "bookType": "RELIGION",
                        "photoUrl": "http://example.com/photo10.jpg"
                    }
                ]
            """;

        JsonFileService jsonToBookDtoService = new JsonFileService(new ObjectMapper(), bookService);
        try {
            jsonToBookDtoService.processJsonList(jsonList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("\n\nInitialized data from DataLoader.\n\n");
    }
}
