package com.coolron.user.client;

import com.coolron.common.utils.ApiResult;
import com.coolron.user.domain.Article;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: xf
 * @Date: 2018/12/23 10:58
 * @Description:  文章微服务接口
 * FeignClient：指定从哪个服务中调用 api 服务名称不可以包含下划线
 */
@FeignClient(value = "springcloud-article")
public interface FeignArticleClient {

    // 文章列表
    @GetMapping("/article/list")
    public ApiResult list();

    /**
     * 根据id查询文章信息
     * @PathVariable(value = "id") 必须指定value参数，不然报错
     */
    @GetMapping("/article/{id}")
    public ApiResult getInfo(@PathVariable(value = "id") String id);

    /**
     * 当参数为实体类时 GET 请求会自动转换为 POST 请求
     * GET 多参数 可使用 @RequestParam("value") 接收， value 不可以省略
     */
//    @GetMapping("/article/saveArticle")
//    public ApiResult saveArticle(Article article);
    @GetMapping("/article/getArticle")
    public ApiResult getArticle(@RequestParam("id") String id, @RequestParam("title") String title, @RequestParam("userid") String userid);

    // 测试 Feign post 请求
    @PostMapping("/article/saveArticle")
    public ApiResult saveArticle(@RequestBody Article article);

}
