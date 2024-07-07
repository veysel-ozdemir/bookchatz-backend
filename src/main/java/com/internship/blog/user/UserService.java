package com.internship.blog.user;

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
