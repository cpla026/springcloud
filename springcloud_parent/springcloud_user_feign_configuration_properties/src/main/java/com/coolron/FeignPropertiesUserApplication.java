package com.coolron;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Auther: xf
 * @Date: 2018/12/23 10:24
 * @Description: feign
 */
// 开启 feign支持
@EnableFeignClients
@EnableDiscoveryClient
@MapperScan("com.coolron.user.dao")
@SpringBootApplication
public class FeignPropertiesUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(FeignPropertiesUserApplication.class);
    }
}
