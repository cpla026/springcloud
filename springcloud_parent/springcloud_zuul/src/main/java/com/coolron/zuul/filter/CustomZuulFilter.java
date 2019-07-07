package com.coolron.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: xf
 * @Date: 2018/12/26 21:25
 * @Description:  Zuul 过滤器
 */
@Component
public class CustomZuulFilter extends ZuulFilter {

    /**
     * 过滤器类型
     * pre: 请求被路由前调用
     * route：路由时调用
     * post：在route和error过滤器之后被调用  zuul自定义了许多过滤器
     * error：处理请求发送错误调用
     */
    @Override
    public String filterType() {
        return "pre";
    }
    // 多个过滤器执行顺序  优先级为0，数字越大，优先级越低
    @Override
    public int filterOrder() {
        return 0;
    }
    // 是否执行该过滤器，此处为true，说明需要过滤
    @Override
    public boolean shouldFilter() {
        return true;
    }
    // 过滤器执行的操作 返回任意Object 类型的值都表示继续执行
    @Override
    public Object run() throws ZuulException {
        System.out.println("zuul过滤器...");

        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String header = request.getHeader("Authorization");

        /**
         * 经过网关的请求会请求两次，
         * 1、内部负责分发的请求  方法：OPTIONS  此请求时不会携带  Authorization 头信息的 所以必须放行
         * 2、转发到微服务的请求  http://localhost:8082/article/1
         */
        if(request.getMethod().equals("OPTIONS")){
            System.out.println("options");
            return null;  // return null 表示放行
        }
        // 登录的请求 放行
        String url=request.getRequestURL().toString();
        if(url.indexOf("/admin/login")>0){
            System.out.println("登陆页面"+url);
            return null;
        }

        // 防止token被伪造，一般会在token前面加 约定好的字符串
        if(null != header && header.startsWith("Bearer ")){
            // 获取 token
            String token = header.substring(7);
            try{
                // 这里一般做解析 token 验证权限等信息操作
                // 方便测试，token固定 123
                if("123".equals(token)){
                    // token 验证通过 转发 header
                    requestContext.addZuulRequestHeader("Authorization", header);
                    return null;  // 放行
                }
            } catch (Exception e){
                // 禁止通行
                requestContext.setSendZuulResponse(false);
            }
        }
        requestContext.setResponseStatusCode(401);
        requestContext.setResponseBody("没有权限");
        requestContext.setSendZuulResponse(false);
//        requestContext.getResponse().setContentType("text/html;charset=UTF-8");
        // 返回json
        requestContext.getResponse().setContentType("application/json;charset=UTF-8");
        return null;
    }
}
