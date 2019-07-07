package com.coolron.user.controller;

import com.coolron.common.utils.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: xf
 * @Date: 2018/12/22 11:34
 * @Description:  Ribbon 请求文章微服务
 *
 * http://springcloud-article/article/ : 文章微服务地址
 * springcloud-article : 文章微服务名称 即 spring.application.name
 */
@Slf4j
@RestController
@RequestMapping(value = "/ribbon")
public class RibbonController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("article/{id}")
    public ApiResult getArticle(@PathVariable("id") String id) {

        ServiceInstance serviceInstance = this.loadBalancerClient.choose("springcloud-article");
        log.info(">>>>>>>>>>>>>文章服务端口号：" + serviceInstance.getPort() + " >>>>>>>>>>");

        ApiResult apiResult = this.restTemplate.getForObject("http://springcloud-article/article/" + id, ApiResult.class);
        return apiResult;
    }

    @GetMapping("article/list")
    public ApiResult getArticleList() {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("springcloud-article");
        log.info(">>>>>>>>>>>>>文章服务端口号：" + serviceInstance.getPort() + " >>>>>>>>>>");

        ApiResult apiResult = this.restTemplate.getForObject("http://springcloud-article/article/list", ApiResult.class);
        return apiResult;
    }
}
