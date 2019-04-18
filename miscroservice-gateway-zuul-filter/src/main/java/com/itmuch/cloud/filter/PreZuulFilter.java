package com.itmuch.cloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class PreZuulFilter extends ZuulFilter {

    private static final Logger logger = LoggerFactory.getLogger(PreZuulFilter.class);
    /*
    *执行的顺序
    * 返回的数组越大执行的顺序越靠后
    * */
    @Override
    public int filterOrder() {
        return 1; // run before PreDecoration
    }
    /*
    * 执行的类型
    * */
    @Override
    public String filterType() {
        return "pre";
    }
    /*
    * 判断是否走过滤器，false表示不走过滤器
    * */
    @Override
    public boolean shouldFilter() {
       return true;
    }
    /*
    * 执行过滤器的具体逻辑
    *
    * */
    @Override
    public Object run() {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        String host = request.getRemoteHost();
        logger.info("请求的host",host+"10101010");
        return null;
    }
}
