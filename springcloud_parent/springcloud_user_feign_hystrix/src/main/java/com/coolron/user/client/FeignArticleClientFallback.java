package com.coolron.user.client;

import com.coolron.common.utils.ApiResult;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Auther: xf
 * @Date: 2018/12/24 23:30
 * @Description:  Feignclient 断路器回退
 */
@Component
public class FeignArticleClientFallback implements FeignArticleClient {
    @Override
    public ApiResult getInfo(@PathVariable(value = "id") String id) {
        return ApiResult.ok("hystrix 熔断");
    }

    @Override
    public ApiResult list() {
        return ApiResult.ok("hystrix 熔断");
    }
}
