package com.coolron.user.client;

import com.config.MyFeignConfiguration;
import com.coolron.common.utils.ApiResult;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Auther: xf
 * @Date: 2018/12/23 10:58
 * @Description:  文章微服务接口
 * FeignClient：指定从哪个服务中调用 api 服务名称不可以包含下划线
 */
@FeignClient(name = "springcloud-article", configuration = MyFeignConfiguration.class )
public interface FeignArticleClient {

    /**
     * 文章列表
     * MyFeignConfiguration 中契约已经改为 Feign 的
     * 参看 ：https://github.com/OpenFeign/feign
     */
    //@GetMapping("/article/list")
    @RequestLine("GET /article/list")
    public ApiResult list();

    @RequestLine("GET /article/{id}")
    public ApiResult getInfo(@Param(value = "id") String id);

    /**
     * 根据id查询文章信息
     * @PathVariable(value = "id") 必须指定value参数，不然报错
     */
//    @GetMapping("/article/{id}")
//    public ApiResult getInfo(@PathVariable(value = "id") String id);

}
