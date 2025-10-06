package com.konoha.sushi.user.infrastructure.repository;

import com.konoha.sushi.user.domain.User;
import com.konoha.sushi.user.domain.UserRepository;
import com.konoha.sushi.user.infrastructure.entity.UserEntity;
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
        UserEntity entity = userMap.userToUserEntity(userEntity);
        UserEntity saved = springUserRepository.save(entity);
        return userMap.userEntityToUser(saved);
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
    public Optional<User> findByUserName(String userName) {
        return springUserRepository.findByUserName(userName).map(userMap::userEntityToUser);
    }

    @Override
    public Boolean existsByUserName(String userName) {
        return springUserRepository.existsByUserName(userName);
    }

    @Override
    public void deleteById(Long id) {
        springUserRepository.deleteById(id);
    }
}
