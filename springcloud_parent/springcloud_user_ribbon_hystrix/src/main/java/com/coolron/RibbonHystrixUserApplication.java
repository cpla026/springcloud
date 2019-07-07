package com.coolron;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: xf
 * @Date: 2018/12/18 20:24
 * @Description: 用户微服务
 *
 * 超时配置：
 *  https://priesttomb.github.io/%E5%88%86%E5%B8%83%E5%BC%8F/2018/09/19/Zuul-Ribbon-Feign-Hystrix-%E8%B6%85%E6%97%B6%E6%97%B6%E9%97%B4%E8%AE%BE%E7%BD%AE%E9%97%AE%E9%A2%98/
 */
// 基于spring-cloud-commons  可以采用其他作为注册中心
@EnableDiscoveryClient
// 基于spring-cloud-netflix  只能使用Eureka 作为注册中心
// @EnableEurekaClient
@MapperScan("com.coolron.user.dao")
@EnableCircuitBreaker
@SpringBootApplication
public class RibbonHystrixUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(RibbonHystrixUserApplication.class);
    }

    /**
     * @LoadBalanced 注解整合了 Ribbon
     * 使restTemplate 具备的Ribbon 客户端负载均衡的能力
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
