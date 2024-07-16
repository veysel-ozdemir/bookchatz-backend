package com.internship.blog.dto;

public record UserResponseDto(
        String fullname,
        String email,
        String photoUrl,
        Integer userId
) {
}
