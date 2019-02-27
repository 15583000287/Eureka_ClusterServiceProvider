package com.example.eurekaserviceinvoker.controller;

import com.example.eurekaserviceinvoker.entity.User;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/hello")
    public String hello(){
        return "Hello Ribbon !";
    }


    /**
     * 测试Feign编码：
     * @requestBody 可以将请求体中的JSON字符串绑定到相应的bean上，当然，也可以将其分别绑定到对应的字符串上。
     *  注意： JSON字符串中的key必须对应user中的属性名
     */
    @RequestMapping(value = "user/create",method = RequestMethod.POST)
    public String createUser(@RequestBody User user){
        System.out.println(user.getUsername() + "-" + user.getPassword());
        return "Success, Person Id: " + user.getId();
    }

}
