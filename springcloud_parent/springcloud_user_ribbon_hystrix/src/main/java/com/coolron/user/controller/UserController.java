package com.coolron.user.controller;

import com.coolron.common.utils.ApiResult;
import com.coolron.user.domain.Article;
import com.coolron.user.domain.User;
import com.coolron.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Auther: xf
 * @Date: 2018/12/18 20:34
 * @Description:
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("article/{id}")
    public ApiResult getArticle(@PathVariable("id") String id){
        ApiResult apiResult = this.restTemplate.getForObject("http://127.0.0.1:8082/article/" + id, ApiResult.class);
        return apiResult;
    }

    @GetMapping("article/list")
    public ApiResult getArticleList(){
        ApiResult apiResult = this.restTemplate.getForObject("http://127.0.0.1:8082/article/list", ApiResult.class);
        return apiResult;
    }

    @GetMapping("article/entityList")
    public ApiResult getArticleEntityList(){
        List<Article> list = this.restTemplate.getForObject("http://127.0.0.1:8082/article/entityList", List.class);
        return ApiResult.ok(list);
    }

    @GetMapping("/list")
    public ApiResult list(){
        List<User> list = userService.list();
        return ApiResult.ok(list);
    }

    @GetMapping("/{id}")
    public ApiResult getInfo(@PathVariable(value = "id") String id){
        User user = userService.getInfo(id);
        return ApiResult.ok(user);
    }


}
