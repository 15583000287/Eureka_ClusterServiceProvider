package com.example.eurekaserviceinvoker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 测试Hystrix  提供的两个测试服务
 */
@RestController
public class HystrixController {
    @GetMapping("/normalHello")
    public String normalHello(HttpServletRequest request) {
        return "Hello World";
    }

    /**
     * 调用的“errorHello”服务，会阻塞 10 秒才有返回。
     * 默认情况下，如果调用的 Web 服务无法在 1 秒内完成，那么将会触发回退。
     */
    @GetMapping("/errorHello")
    public String errorHello(HttpServletRequest request) throws Exception {
        //模拟需要处理10秒
        Thread.sleep(10000);
        return "Error Hello Word";
    }

}
