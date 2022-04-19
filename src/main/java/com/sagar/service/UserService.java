package com.sagar.service;

import com.sagar.entity.User;
import com.sagar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String createUser(User user) {
        userRepository.save(user);
        return "user created...";
    }

    public String createMultipleUsers(List<User> users) {
        userRepository.saveAll(users);
        return "users created...";
    }

    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(User user) {
        Optional<User> optionalUser = userRepository.findById(user.getId());
        if (optionalUser.isPresent()) {
            User oldUser = optionalUser.get();
            oldUser.setName(user.getName());
            oldUser.setAddress(user.getAddress());
            return userRepository.save(oldUser);
        } else {
            return new User();
        }
    }

    public String deleteUserById(int id) {
        userRepository.deleteById(id);
        return "User deleted...";
    }
}
