package com.internship.blog.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserDto(
        @NotBlank(message = "fullname should not be empty")
        String fullname,
        @NotBlank(message = "email should not be empty")
        String password,
        @NotBlank(message = "password should not be empty")
        @Email(message = "improper mail format")
        String email,
        @NotBlank(message = "photo url should not be empty")
        String photoUrl
) {
}
