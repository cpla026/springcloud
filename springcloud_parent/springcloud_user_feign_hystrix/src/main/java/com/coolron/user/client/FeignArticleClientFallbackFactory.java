package com.coolron.user.client;

import com.coolron.common.utils.ApiResult;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Auther: xf
 * @Date: 2018/12/24 23:45
 * @Description:  Feignclient 断路器回退  factory 获取异常信息
 */
@Slf4j
@Component
public class FeignArticleClientFallbackFactory implements FallbackFactory<FeignArticleClient> {
    @Override
    public FeignArticleClient create(Throwable throwable) {
        return new FeignArticleClient() {
            @Override
            public ApiResult getInfo(String id) {
               // return new Hello("fallback; reason was: " + cause.getMessage());
                log.info(">>>>throwable, {}", throwable.getMessage());
                return ApiResult.ok("fallback; reason was: " + throwable.toString() + " : "+ throwable.getMessage());
            }

            @Override
            public ApiResult list() {
                log.info(">>>>throwable, {}", throwable.getMessage());
                return ApiResult.ok("fallback; reason was: " + throwable.toString() + " : "+ throwable.getMessage());
            }
        };
    }
}
