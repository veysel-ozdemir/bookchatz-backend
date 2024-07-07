package com.internship.blog.post;

import com.internship.blog.book.BookType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PostDto(
        @NotBlank(message = "book title should not be empty")
        String bookTitle,
        @NotBlank(message = "book review should not be empty")
        String bookReview,
        @NotNull(message = "book type should not be empty")
        BookType bookType, // todo: the selection of dropdown menu should provide only the enum values
        @NotBlank(message = "author name should not be empty")
        String authorName,
        @NotBlank(message = "book photo url should not be empty")
        String bookPhotoUrl,
        @NotNull(message = "user id should not be empty")
        Integer userId
) {
}
