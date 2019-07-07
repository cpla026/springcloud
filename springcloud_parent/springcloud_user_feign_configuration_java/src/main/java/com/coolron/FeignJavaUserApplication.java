package com.coolron;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Auther: xf
 * @Date: 2018/12/23 10:24
 * @Description: feign 使用 java 配置 覆盖 Feign 的默认配置
 */
// 开启 feign支持
@EnableFeignClients
@EnableDiscoveryClient
@MapperScan("com.coolron.user.dao")
@SpringBootApplication
public class FeignJavaUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(FeignJavaUserApplication.class);
    }
}
