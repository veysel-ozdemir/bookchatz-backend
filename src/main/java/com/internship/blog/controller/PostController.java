package com.internship.blog.controller;

import com.internship.blog.dto.PostDto;
import com.internship.blog.dto.PostEditDto;
import com.internship.blog.model.Post;
import com.internship.blog.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    // create new post
    @PostMapping("/new-post")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Object> createPost(@Valid @RequestBody PostDto postDto) {
        return postService.createPost(postDto);
    }

    // edit post
    @PutMapping("/edit-post")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Object> updatePost(@Valid @RequestBody PostEditDto postEditDto) {
        return postService.updatePost(postEditDto);
    }

    // get all posts
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Object> getAllPosts() {
        return postService.getPosts();
    }

    // get post by id
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Post getPostById(@PathVariable("id") Integer id) {
        return postService.getPostById(id);
    }

    // delete post by id
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deletePostById(@PathVariable("id") Integer id) {
        return postService.deletePostById(id);
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

