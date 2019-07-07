//package com.config;
//
//import feign.Feign;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Scope;
//
////@Configuration
//public class Configuration2 {
//
//  /**
//   * To disable Hystrix support on a per-client basis create a vanilla Feign.Builder with the "prototype" scope
//   * 禁用 feign 的 Hystrix 的支持
//   */
//  @Bean
//  @Scope("prototype")
//  public Feign.Builder feignBuilder() {
//    // Feign.Builder feignBuilder: HystrixFeign.Builder  默认为 Feign.Builder feignBuilder: HystrixFeign.Builder
//    // 此处改为 Feign.builder() 禁用了 Feign 的 Hystrix
//    return Feign.builder();
//
//  }
//}
