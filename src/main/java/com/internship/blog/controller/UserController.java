package com.internship.blog.controller;

import com.internship.blog.model.User;
import com.internship.blog.dto.UserDto;
import com.internship.blog.dto.UserLoginDto;
import com.internship.blog.service.UserService;
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
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // post method with request body for register
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public User register(@Valid @RequestBody UserDto userDto) {
        return userService.register(userDto);
    }

    // post method with request body for login
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public boolean login(@Valid @RequestBody UserLoginDto userLoginDto) {
        return userService.login(userLoginDto);
    }

    // get all users
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<User> getUsers() {
        return userService.getUsers();
    }

    // get method with path variable
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public User getUserById(@PathVariable("id") Integer id) {
        return userService.getUserById(id);
    }

    // delete method with path variable
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteUserById(@PathVariable("id") Integer id) {
        return userService.deleteUserById(id);
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
