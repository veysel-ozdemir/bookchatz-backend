package com.internship.blog.data;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // post method with request body
    @PostMapping("/new-user")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public User postReqBody(@Valid @RequestBody User user) {
        return userService.saveUser(user);
    }

    // get all users
    @GetMapping("/all-users")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<User> getUsers() {
        return userService.getUsers();
    }

    // get method with path variable
    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public User getUserById(@PathVariable("id") Integer id) {
        return userService.getUserById(id);
    }

    // get method with request parameters
    @GetMapping("/users")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<User> getUsersByFullname(@RequestParam("fullname") String fullname) {
        return userService.getUsersByFullname(fullname);
    }

    // delete method with path variable
    @DeleteMapping("/users/delete/{id}")
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
