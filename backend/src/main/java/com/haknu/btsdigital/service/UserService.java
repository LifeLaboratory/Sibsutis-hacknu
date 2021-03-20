package com.haknu.btsdigital.service;

import com.haknu.btsdigital.domain.User;
import com.haknu.btsdigital.domain.UserRole;
import com.haknu.btsdigital.dto.UserDto;
import com.haknu.btsdigital.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("User " + username + " cannot be found");
        return user;
    }

    public User createUser(UserDto dto) throws Exception {
        User u = new User();
        u.setIdAito(dto.getIdAito());
        u.setName(dto.getName());
        u.setSurname(dto.getSurname());
        u.setAvatarUrl(dto.getAvatarUrl());
        u.setRole(UserRole.USER);
        u.setActive(dto.isActive());
        u = userRepository.save(u);
        return u;
    }

    public UserDto getUserById(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return UserDto.of(user.get());
    }
}
