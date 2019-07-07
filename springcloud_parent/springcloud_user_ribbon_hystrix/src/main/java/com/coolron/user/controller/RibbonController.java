package com.coolron.user.controller;

import com.coolron.common.utils.ApiResult;
import com.coolron.user.domain.Article;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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

    /**
     * Hystrix 断路器
     */
    @HystrixCommand(fallbackMethod = "getArticleFallback",
            commandProperties = {
                @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000") // 超时时间默认一秒
            })
    //@HystrixCommand(fallbackMethod = "getArticleFallback")
    @GetMapping("article/{id}")
    public ApiResult getArticle(@PathVariable("id") String id) {
        ApiResult apiResult = this.restTemplate.getForObject("http://springcloud-article/article/" + id, ApiResult.class);
        return apiResult;
    }

    /**
     * Hystrix fallback 回退方法
     * 参数和返回值要和作用的方法一致 方法名称自定义
     */
    public ApiResult getArticleFallback(String id) {
        return ApiResult.ok(id);
    }

    /**
     * 设置超时时间不同于 commandProperties 的方式   定义 @HystrixCommand 中的 commandKey ，然后在 yml 中分别设置
     * 不同的 commandKey 对应的超时时间不同  相同的 commandKey 超时时间相同
     *
     */
    @HystrixCommand(fallbackMethod = "getArticleListFallback",commandKey = "ribbon-article")
    @GetMapping("article/list")
    public ApiResult getArticleList() {
        ApiResult apiResult = this.restTemplate.getForObject("http://springcloud-article/article/list", ApiResult.class);
        return apiResult;
    }
    public ApiResult getArticleListFallback(){
        return ApiResult.ok("hystrix 回退");
    }

    /**
     * 文章列表
     */
    @HystrixCommand(fallbackMethod = "getArticleListFallback",commandKey = "ribbon-article")
    @GetMapping("article/entityList")
    public ApiResult getArticleEntityList(){
        List<Article> list = this.restTemplate.getForObject("http://springcloud-article/article/entityList", List.class);
        return ApiResult.ok(list);
    }

}
