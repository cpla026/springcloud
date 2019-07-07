package com.coolron;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Auther: xf
 * @Date: 2018/12/18 20:24
 * @Description: 用户微服务
 */
// 基于spring-cloud-commons  可以采用其他作为注册中心
@EnableDiscoveryClient
// 基于spring-cloud-netflix  只能使用Eureka 作为注册中心
@EnableEurekaClient
@MapperScan("com.coolron.user.dao")
@SpringBootApplication
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class);
    }
}
