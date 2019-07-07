package com.config;

import feign.Contract;
import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: xf
 * @Date: 2018/12/23 19:28
 * @Description: Feign 的配置
 */
@Configuration
public class MyFeignConfiguration {
    /**
     * 契约   不配置则 使用 spring mvc 的契约
     */
    @Bean
    public Contract feignContract() {
        return new feign.Contract.Default();
    }

    /**
     * Feign 日志
     * 级别：NONE BASIC HEADERS FULL
     */
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("user", "password");
    }
}
