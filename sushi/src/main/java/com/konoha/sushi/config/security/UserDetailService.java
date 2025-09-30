package com.konoha.sushi.config.security;

import com.konoha.sushi.user.UserEntity;
import com.konoha.sushi.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUserName(username)
                .orElseThrow(()->new UsernameNotFoundException("usario no encontrado"));

        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();

       userEntity.getRole()
               .forEach(role->authorityList.add(new SimpleGrantedAuthority("ROLE_".concat(role.getRoleEnum().name()))));

       userEntity.getRole().stream()
                .flatMap(role -> role.getPermission().stream())
                .forEach(permissionEntity -> authorityList.add(new SimpleGrantedAuthority(permissionEntity.getName())));

        return new User(userEntity.getUserName(),
                userEntity.getPassword(),
                userEntity.isEnabled(),
                userEntity.isAccountNoExpired(),
                userEntity.isCredentialNoExpired(),
                userEntity.isAccountNoLocked(),
                authorityList);
    }
}
