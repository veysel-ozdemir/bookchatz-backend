package com.internship.blog.dto;

public record BookResponseDto(
        Integer bookId,
        String title,
        String authorName,
        String photoUrl
) {
}
