package com.internship.blog.user;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getUsersByFullname(String fullname) {
        return userRepository.findAllByFullnameContains(fullname);
    }

    public String deleteUserById(Integer id) {
        userRepository.deleteById(id);
        return "User with id " + id + " was deleted";
    }

}
