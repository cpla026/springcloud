package com.coolron.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @Auther: xf
 * @Date: 2018/12/19 21:57
 * @Description: hystrix dashboard 只能实现单个微服务的监控，可
 * 是一般项目中是微服务是以集群的形式搭建
 */
@EnableTurbine
@EnableDiscoveryClient
@SpringBootApplication
public class HystrixTurbineApplication {
    public static void main(String[] args) {
        SpringApplication.run(HystrixTurbineApplication.class);
    }
}
