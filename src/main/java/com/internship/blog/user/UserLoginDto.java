package com.internship.blog.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserLoginDto(
        @NotBlank(message = "email should not be empty")
        String password,
        @NotBlank(message = "password should not be empty")
        @Email(message = "improper mail format")
        String email
) {
}
