package com.internship.blog.dto;

public record PostResponseDto(
        Integer postId,
        String review,
        String postDate,
        Integer userId,
        String userFullname,
        String userPhotoUrl,
        String bookTitle,
        String bookAuthorName,
        String bookPhotoUrl,
        String bookType
) {
}
