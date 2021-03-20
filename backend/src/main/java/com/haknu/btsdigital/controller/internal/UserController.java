package com.haknu.btsdigital.controller.internal;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.haknu.btsdigital.domain.User;
import com.haknu.btsdigital.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@Slf4j
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/api/user/profile/id", method = RequestMethod.POST)
    public User getUserProfile(@RequestBody String object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(object,User.class);
        return userService.getUserById(user.getId());
    }
    @RequestMapping(value = "/api/user/newUser", method = RequestMethod.POST)
    public  User addNewUser(@RequestBody String object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(object, User.class);
        return userService.addNewUser(user);
    }

    @RequestMapping(value = "/api/user/authUser", method = RequestMethod.POST)
    public ResponseEntity<?> authUser(@RequestBody String object) throws JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(object, User.class);
        if (userService.authUser(user).equals(HttpStatus.ACCEPTED)) {
            return ResponseEntity.ok(user);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
