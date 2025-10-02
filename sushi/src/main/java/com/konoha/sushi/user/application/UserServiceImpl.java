package com.konoha.sushi.user.application;


import com.konoha.sushi.config.exception.ResourceNotFoundException;
import com.konoha.sushi.user.domain.UserService;
import com.konoha.sushi.user.domain.User;
import com.konoha.sushi.user.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User update(Long id, User updateUser) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        user.setUserName(updateUser.getUserName());
        user.setEmail(updateUser.getEmail());
        user.setPassword(updateUser.getPassword());

        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
