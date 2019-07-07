package com.coolron.user.controller;

import com.coolron.common.utils.ApiResult;
import com.coolron.user.client.FeignArticleClient;
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

//    @Autowired
//    private FeignClient2 feignClient2;

    // 通过 id 获取文章信息
    @GetMapping(value = "/findArticleById/{id}")
    public ApiResult findArticleById(@PathVariable(value = "id") String id){
        ApiResult apiResult = feignArticleClient.getInfo(id);
        return apiResult;
    }

    // 获取文章列表
    @GetMapping(value = "findArticleList")
    public ApiResult findArticleList(){
        ApiResult apiResult = feignArticleClient.list();
        return apiResult;
    }

//    @GetMapping("/{serviceName}")
//    public String findServiceInfoFromEurekaByServiceName(@PathVariable String serviceName) {
//        return this.feignClient2.findServiceInfoFromEurekaByServiceName(serviceName);
//    }

}
