package com.internship.blog.controller;

import com.internship.blog.dto.UserDto;
import com.internship.blog.dto.UserEditDto;
import com.internship.blog.dto.UserLoginDto;
import com.internship.blog.model.User;
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
    public ResponseEntity<Object> register(@Valid @RequestBody UserDto userDto) {
        return userService.register(userDto);
    }

    // post method with request body for login
    @PostMapping("/login")
    public ResponseEntity<Object> login(@Valid @RequestBody UserLoginDto userLoginDto) {
        return userService.login(userLoginDto);
    }

    // edit user
    @PutMapping("/edit-user")
    public ResponseEntity<Object> updateUser(@Valid @RequestBody UserEditDto userEditDto) {
        return userService.updateUser(userEditDto);
    }

    // get all users
    @GetMapping("/all")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    // delete method with path variable
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteUserById(@PathVariable("id") Integer id) {
        return userService.deleteUserById(id);
    }

    // get method with path variable
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public User getUserById(@PathVariable("id") Integer id) {
        return userService.getUserById(id);
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
