package com.internship.blog.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.internship.blog.dto.BookDto;
import com.internship.blog.dto.PostDto;
import com.internship.blog.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class JsonFileService {

    private final ObjectMapper objectMapper;
    private final BookService bookService;
    private final UserService userService;
    private final PostService postService;

    public List<BookDto> convertJsonToBookDtoList(String jsonList) throws Exception {
        TypeReference<List<BookDto>> typeRef = new TypeReference<>() {
        };
        return objectMapper.readValue(jsonList, typeRef);
    }

    public void processBookJsonList(String jsonList) throws Exception {
        List<BookDto> bookDtoList = convertJsonToBookDtoList(jsonList);
        bookDtoList.forEach(bookService::createBook);
    }

    public List<UserDto> convertJsonToUserDtoList(String jsonList) throws Exception {
        TypeReference<List<UserDto>> typeRef = new TypeReference<>() {
        };
        return objectMapper.readValue(jsonList, typeRef);
    }

    public void processUserJsonList(String jsonList) throws Exception {
        List<UserDto> userDtoList = convertJsonToUserDtoList(jsonList);
        userDtoList.forEach(userService::register);
    }

    public List<PostDto> convertJsonToPostDtoList(String jsonList) throws Exception {
        TypeReference<List<PostDto>> typeRef = new TypeReference<>() {
        };
        return objectMapper.readValue(jsonList, typeRef);
    }

    public void processPostJsonList(String jsonList) throws Exception {
        List<PostDto> postDtoList = convertJsonToPostDtoList(jsonList);
        postDtoList.forEach(postService::createPost);
    }
}
