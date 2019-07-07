package com.coolron.user.controller;

import com.coolron.common.utils.ApiResult;
import com.coolron.user.client.FeignArticleClient;
import com.coolron.user.domain.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: xf
 * @Date: 2018/12/23 11:20
 * @Description: 使用Feign 调用文章微服务
 */
@RestController
@RequestMapping(value = "/feign")
public class FeignController {

    // 引入Feign client文章微服务接口
    @Autowired
    private FeignArticleClient feignArticleClient;

    // 获取文章列表
    @GetMapping(value = "findArticleList")
    public ApiResult findArticleList(){
        ApiResult apiResult = feignArticleClient.list();
        return apiResult;
    }

    // 通过 id 获取文章信息
    @GetMapping(value = "/findArticleById/{id}")
    public ApiResult findArticleById(@PathVariable(value = "id") String id){
        ApiResult apiResult = feignArticleClient.getInfo(id);
        return apiResult;
    }

    // 测试 Feign get 请求多参数
    @GetMapping(value = "getArticle")
    public ApiResult getArticle(Article article){
        ApiResult apiResult = feignArticleClient.getArticle(article.getId(), article.getTitle(), article.getUserid());
        return apiResult;
    }

    // 测试 feign post 请求
    @GetMapping(value = "saveArticle")
    public ApiResult saveArticle(Article article){
        ApiResult apiResult = feignArticleClient.saveArticle(article);
        return apiResult;
    }

}
