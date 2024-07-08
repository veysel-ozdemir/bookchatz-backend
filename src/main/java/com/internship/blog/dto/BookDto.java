package com.internship.blog.dto;

import com.internship.blog.enums.BookType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BookDto(
        @NotBlank(message = "title should not be empty")
        String title,
        @NotBlank(message = "author name should not be empty")
        String authorName,
        @NotNull(message = "book type should not be empty")
        BookType bookType,
        @NotBlank(message = "photo url should not be empty")
        String photoUrl
) {
}
