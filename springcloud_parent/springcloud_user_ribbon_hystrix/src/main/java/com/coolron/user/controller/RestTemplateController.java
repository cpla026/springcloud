package com.coolron.user.controller;

import com.coolron.common.utils.ApiResult;
import com.coolron.user.domain.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Auther: xf
 * @Date: 2018/12/22 9:30
 * @Description: 使用 RestTemplate 调用文章微服务 api
 *
 * http://127.0.0.1:8082/article/ ：文章微服务地址
 */
@RestController
@RequestMapping(value = "/restTemplate")
public class RestTemplateController {

    // 引入 RestTemplate
    @Autowired
    private RestTemplate restTemplate;

    // 根据文章 id 获取文章信息
    @GetMapping("article/{id}")
    public ApiResult getArticle(@PathVariable("id") String id){
        ApiResult apiResult = this.restTemplate.getForObject("http://127.0.0.1:8082/article/" + id, ApiResult.class);
        return apiResult;
    }

    // 文章列表
    @GetMapping("article/list")
    public ApiResult getArticleList(){
        ApiResult apiResult = this.restTemplate.getForObject("http://127.0.0.1:8082/article/list", ApiResult.class);
        return apiResult;
    }

    // 文章列表
    @GetMapping("article/entityList")
    public ApiResult getArticleEntityList(){
        List<Article> list = this.restTemplate.getForObject("http://127.0.0.1:8082/article/entityList", List.class);
        return ApiResult.ok(list);
    }
}
