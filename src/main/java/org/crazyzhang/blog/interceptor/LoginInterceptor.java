package org.crazyzhang.blog.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登陆拦截器----->一定要记着在SpringMVC中注册拦截器
 */
public class LoginInterceptor extends HandlerInterceptorAdapter{

    // 预处理回调方法，若方法返回值为true，请求继续（调用下一个拦截器或处理器方法）；
    // 若方法返回值为false，请求处理流程中断，不会继续调用其他的拦截器或处理器方法，此时需要通过response产生响应；
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getSession().getAttribute("root") != null) {
            return true;// 表示放行，不拦截
        }

        // 没有登录，进行拦截
        response.sendRedirect(request.getContextPath()+"/login?next=".concat(request.getRequestURI()));// 这一步太巧妙了啊，登陆完成后返回之前的页面
        return false;
    }
}
