package com.example.eurekaserviceinvoker;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.Scanner;

/**
 * @EnableDiscoveryClient 注解来修改启动类，该注解使得服务调用者，有能力去 Eureka 中发现服务
 * 注意:
 * @EnableEurekaClient 注解已经包含了@EnableDiscoveryClient 的功能，
 * 也就是说，一个 Eureka 客户端，本身就具有发现服务的能力。
 */
@SpringBootApplication
@EnableEurekaClient  //声明该应用是一个Eureka客户端
public class ProviderApplication {

    public static void main(String[] args) {
        //读取控制台输入的端口，避免端口冲突
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入prot:");
        String port = sc.nextLine();
        // 设置启动的服务器端口
        new SpringApplicationBuilder(ProviderApplication.class).properties( "server.port=" + port).run(args);
        //SpringApplication.run(ProviderApplication.class, args);
    }

}
