package com.internship.blog.dto;

import com.internship.blog.enums.BookType;

public record PostQueryDto(
        String bookTitle,
        String bookAuthorName,
        BookType bookType,
        String bookPhotoUrl,
        String review,
        Integer postId
) {
}
