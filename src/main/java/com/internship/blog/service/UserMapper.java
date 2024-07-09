package com.internship.blog.service;

import com.internship.blog.dto.UserDto;
import com.internship.blog.dto.UserEditDto;
import com.internship.blog.dto.UserResponseDto;
import com.internship.blog.model.Post;
import com.internship.blog.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserMapper {

    public User toUser(UserDto userDto) {
        // create the user
        User user = new User();

        // set the fields of user
        user.setEmail(userDto.email());
        user.setPassword(userDto.password());
        user.setFullname(userDto.fullname());
        user.setPhotoUrl(userDto.photoUrl());
        user.setPosts(new ArrayList<Post>());

        return user;
    }

    public User toUpdatedUser(UserEditDto userEditDto, User presentUser) {
        // set the fields of user
        presentUser.setFullname(userEditDto.fullname());
        presentUser.setEmail(userEditDto.email());
        presentUser.setPassword(userEditDto.password());
        presentUser.setPhotoUrl(userEditDto.photoUrl());

        return presentUser;
    }

    public UserResponseDto toUserResponseDto(User user) {
        return new UserResponseDto(user.getFullname(), user.getPhotoUrl(), user.getId());
    }
}
