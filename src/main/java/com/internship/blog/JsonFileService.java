package com.internship.blog;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.internship.blog.book.BookDto;
import com.internship.blog.book.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class JsonFileService {

    private final ObjectMapper objectMapper;
    private final BookService bookService;

    public List<BookDto> convertJsonToBookDtoList(String jsonList) throws Exception {
        TypeReference<List<BookDto>> typeRef = new TypeReference<>() {};
        return objectMapper.readValue(jsonList, typeRef);
    }

    public void processJsonList(String jsonList) throws Exception {
        List<BookDto> bookDtoList = convertJsonToBookDtoList(jsonList);
        bookDtoList.forEach(bookService::createBook);
    }
}
