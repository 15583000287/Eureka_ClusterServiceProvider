package com.example.eurekaserviceinvoker.controller;

import com.example.eurekaserviceinvoker.entity.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
public class FistController {
    @RequestMapping("/user/{userId}")
    public User findUser(@PathVariable("userId") Integer id, HttpServletRequest request){
        User user = new User();
        user.setId(id);
        user.setUsername("root");
        user.setPassword("123");
        user.setMessage(request.getRequestURL().toString());
        return user;
    }
}
