package com.coolron.user.client;

import com.coolron.common.utils.ApiResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Auther: xf
 * @Date: 2018/12/23 10:58
 * @Description:  文章微服务接口
 */
@FeignClient(name = "springcloud-article", fallbackFactory = FeignArticleClientFallbackFactory.class )
//@FeignClient(name = "springcloud-article", fallback = FeignArticleClientFallback.class )
public interface FeignArticleClient {
    /**
     * 根据id查询文章信息
     * @PathVariable(value = "id") 必须指定value参数，不然报错
     */
    @RequestMapping(value = "/article/{id}",method = RequestMethod.GET)
    public ApiResult getInfo(@PathVariable(value = "id") String id);

    // 文章列表
    @GetMapping("/article/list")
    public ApiResult list();
}
