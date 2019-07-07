package com.coolron.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Auther: xf
 * @Date: 2018/12/25 22:43
 * @Description: zuul 服务网关
 */
//@EnableDiscoveryClient
@EnableZuulProxy
@SpringBootApplication
public class ZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class);
    }

    /**
     * 路由正则表达
     * 1、指定用户微服务名称：springcloud-user-v1
     * 2、访问 http://127.0.0.1:8050/v1/springcloud-article/article/3
     */
  /*  @Bean
    public PatternServiceRouteMapper serviceRouteMapper() {
        return new PatternServiceRouteMapper(
                "(?<name>^.+)-(?<version>v.+$)",
                "${version}/${name}");
    }*/

}
