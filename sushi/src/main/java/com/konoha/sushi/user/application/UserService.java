package com.konoha.sushi.user.application;

import com.konoha.sushi.config.exception.ResourceNotFoundException;
import com.konoha.sushi.user.domain.IUserService;
import com.konoha.sushi.user.domain.User;
import com.konoha.sushi.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;

    public User update(User updateUser) {
        User user = userRepository.findById(updateUser.getId()).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        BeanUtils.copyProperties(updateUser, user, "role");
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
