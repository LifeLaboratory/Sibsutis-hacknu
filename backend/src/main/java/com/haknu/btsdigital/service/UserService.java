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
        //   log.debug(">> Looking for the user {}", username);
        User user = userRepository.findByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("User " + username + " cannot be found");
        return user;
    }

    public User createUser(UserDto dto) throws Exception {
//        if (userRepository.findByUsername(dto.getEmail()) != null)
//            throw new UserAlreadyExistException("User with the given email already exists" + dto.getEmail());

        User u = new User();
        u.setName(dto.getName());
        u.setUsername(dto.getEmail());
        u.setRole(UserRole.USER);
        u.setPhone(dto.getPhone());
        u.setActive(dto.isActive());
        u = userRepository.save(u);
        return u;
    }

    public User updateUser(UserDto dto) {

        User u = (User) loadUserByUsername(dto.getEmail());
        u.setName(dto.getName());
        u.setUsername(dto.getEmail());
        u.setPhone(dto.getPhone());
        u.setActive(dto.isActive());
        u = userRepository.save(u);
        return u;
    }

    public User createTestUser(User user) {
        user = userRepository.save(user);
        log.debug(">> Creating of the system user: {}", user);
        return user;
    }

    public UserDto getUserById(Long userId) {
        Optional<User> user = userRepository.findById(userId);
//        if (!user.isPresent())
//            throw new UserNotFoundException("User cannot be found by ID " + userId);

        return UserDto.of(user.get());
    }
}
