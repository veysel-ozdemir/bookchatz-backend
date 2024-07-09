package com.internship.blog.service;

import com.internship.blog.dto.UserDto;
import com.internship.blog.dto.UserEditDto;
import com.internship.blog.dto.UserLoginDto;
import com.internship.blog.model.User;
import com.internship.blog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public boolean login(UserLoginDto userLoginDto) {
        User loginUser = userRepository.findByEmailAndPassword(
                userLoginDto.email(),
                userLoginDto.password()
        ).orElse(null);
        return loginUser != null; // todo: change the return data later (ResponseDto)
    }

    public User register(UserDto userDto) {
        User user = userMapper.toUser(userDto);
        userRepository.save(user);
        return user; // todo: change the return data later (ResponseDto)
    }

    public User updateUser(UserEditDto userEditDto) {
        // get present user
        User presentUser = userRepository.findById(userEditDto.userId()).orElse(null);
        // create an assertion whether the user exists
        assert presentUser != null : "User not found with provided id" + userEditDto.userId();
        // check whether the entered email is available
        if (userRepository.findByEmail(userEditDto.email()).isEmpty()) {
            // map the entity
            User updatedUser = userMapper.toUpdatedUser(userEditDto, presentUser);
            // save the changes
            userRepository.save(updatedUser);
            return updatedUser; // todo: change the return data later (ResponseDto)
        }
        return null;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public String deleteUserById(Integer id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return "User not found with id: " + id;
        }
        userRepository.deleteById(id);
        return "User with id " + id + " was deleted";
    }

}
