package com.internship.blog.book;

import jakarta.validation.constraints.NotBlank;

public record BookDto(
        @NotBlank(message = "title should not be empty")
        String title,
        @NotBlank(message = "author name should not be empty")
        String authorName,
        @NotBlank(message = "book type should not be empty")
        BookType bookType,
        @NotBlank(message = "photo url should not be empty")
        String photoUrl
) {
}
