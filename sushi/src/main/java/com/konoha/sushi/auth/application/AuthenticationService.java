package com.konoha.sushi.auth.application;

import com.konoha.sushi.auth.infrastructure.AuthenticationRequest;
import com.konoha.sushi.auth.infrastructure.AuthenticationResponse;
import com.konoha.sushi.config.application.JwtService;
import com.konoha.sushi.exception.domain.ResourceNotFoundException;
import com.konoha.sushi.user.domain.Role;
import com.konoha.sushi.user.domain.User;
import com.konoha.sushi.user.domain.UserRepository;
import com.konoha.sushi.user.infrastructure.entity.UserEntity;
import com.konoha.sushi.user.infrastructure.mapper.UserMap;
import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserMap userMapper;

    public AuthenticationResponse register(User user) {

        if (userRepository.findByUserName(user.getUserName()).isPresent()) throw new ResourceNotFoundException("error");

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);

        User saved = userRepository.save(user);
        UserEntity userEntity = userMapper.userToUserEntity(saved);

        String jwtToken = jwtService.generateToken(userEntity);

        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));

        User user = userRepository.findByUserName(request.getUserName()).orElseThrow(() -> new ResourceNotFoundException("User not found"));

        UserEntity userEntity = userMapper.userToUserEntity(user);

        String jwtToken = jwtService.generateToken(userEntity);

        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
