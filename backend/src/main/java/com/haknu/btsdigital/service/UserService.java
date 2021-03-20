package com.haknu.btsdigital.service;

import com.haknu.btsdigital.domain.User;
import com.haknu.btsdigital.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;


@Slf4j
@Component
public class UserService {

    private final UserRepository userRepository;


    @Transactional
    public User getUserById(Long id) {
        if(userRepository.existsUserById(id)) {
            return userRepository.findUserById(id);
        }else{
            return null;
        }
    }

    @Transactional
    public User addNewUser(User user) {
        if(userRepository.existsUserById(user.getId())) {
            return null;
        }else{
            userRepository.save(user);
            return userRepository.findUserById(user.getId());
        }
    }

    @Transactional
    public HttpStatus authUser(User user) {
        if(userRepository.existsUserById(user.getId())) {
            return HttpStatus.ACCEPTED;
        }else{
            return HttpStatus.NOT_FOUND;
        }
    }

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
