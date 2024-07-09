package com.internship.blog.dto;

public record UserResponseDto(
        String fullname,
        String photoUrl,
        Integer userId
) {
}
