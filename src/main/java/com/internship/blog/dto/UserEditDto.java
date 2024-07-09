package com.internship.blog.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserEditDto(
        @NotBlank(message = "fullname should not be empty")
        String fullname,
        @NotBlank(message = "email should not be empty")
        String password,
        @NotBlank(message = "password should not be empty")
        @Email(message = "improper mail format")
        String email,
        @NotBlank(message = "photo url should not be empty")
        String photoUrl,
        @NotNull(message = "user id should not be empty")
        Integer userId
) {
}
