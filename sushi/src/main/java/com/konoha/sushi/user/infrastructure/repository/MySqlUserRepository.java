package com.konoha.sushi.user.infrastructure.repository;

import com.konoha.sushi.user.domain.User;
import com.konoha.sushi.user.domain.UserRepository;
import com.konoha.sushi.user.infrastructure.mapper.UserMap;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MySqlUserRepository implements UserRepository {

    private final SpringUserRepository springUserRepository;
    private final UserMap userMap;

    @Override
    public User save(User userEntity) {
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        return springUserRepository.findById(id).map(userMap::userEntityToUser);
    }

    @Override
    public List<User> findAll() {
        return springUserRepository.findAll().stream().map(userMap::userEntityToUser).toList();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return springUserRepository.findByEmail(email).map(userMap::userEntityToUser);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return springUserRepository.existsByEmail(email);
    }

    @Override
    public void deleteById(Long id) {
        springUserRepository.deleteById(id);
    }
}
