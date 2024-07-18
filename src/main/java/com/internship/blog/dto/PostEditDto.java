package com.internship.blog.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PostEditDto(
        @NotBlank(message = "book title should not be empty")
        String bookTitle,
        @NotBlank(message = "book review should not be empty")
        String bookReview,
        @NotNull(message = "book type should not be empty")
        String bookType, // todo: the selection of dropdown menu should provide only the enum values
        @NotBlank(message = "author name should not be empty")
        String authorName,
        @NotBlank(message = "book photo url should not be empty")
        String bookPhotoUrl,
        @NotNull(message = "user id should not be empty")
        Integer userId,
        @NotNull(message = "post id should not be empty")
        Integer postId
) {
}
