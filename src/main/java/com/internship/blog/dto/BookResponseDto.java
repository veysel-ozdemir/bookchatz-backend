package com.internship.blog.dto;

import com.internship.blog.enums.BookType;

public record BookResponseDto(
        Integer bookId,
        String title,
        String authorName,
        BookType bookType,
        String photoUrl
) {
}
