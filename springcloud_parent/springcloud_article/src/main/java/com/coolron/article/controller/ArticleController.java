package com.coolron.article.controller;

import com.coolron.article.domain.Article;
import com.coolron.article.service.ArticleService;
import com.coolron.common.utils.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: xf
 * @Date: 2018/12/18 21:05
 * @Description:
 */
@Slf4j
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/list")
    public ApiResult list(){
        List<Article> list = articleService.list();
        return ApiResult.ok(list);
    }

    @GetMapping("/entityList")
    public List<Article> entityList(){
        List<Article> list = articleService.list();
        return list;
    }

    @GetMapping("/{id}")
    public ApiResult getInfo(@PathVariable(value = "id") String id){
        Article article = articleService.getInfo(id);
        log.info(">>>>文章微服务>>>被调用>>>");
        //int i = 1/0;
        return ApiResult.ok(article);
    }

    // 测试 Feign get 请求多参数
    @GetMapping("/getArticle")
    public ApiResult getArticle(Article article){
        return ApiResult.ok(article);
    }

    // 测试 Feign post 请求
    @PostMapping("/saveArticle")
    public ApiResult saveArticle(@RequestBody Article article){
        return ApiResult.ok(article);
    }


}
