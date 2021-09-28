package cn.lili.common.context;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * request response 填充
 *
 * @author Chopper
 * @version v4.0
 * @since 2020/12/9 10:44
 */
public class ThreadContextHolderInterceptorAdapter extends HandlerInterceptorAdapter {


    /**
     * 拦截request和response并放到上下文中
     *
     * @param request 请求
     * @param response 响应
     * @param handler 处理程序
     * @return 处理结果
     * @throws Exception 未知异常
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        ThreadContextHolder.setHttpResponse(response);
        ThreadContextHolder.setHttpRequest(request);

        return super.preHandle(request, response, handler);
    }


    /**
     * 从上下文中移除 request 和response
     *
     * @param request 请求
     * @param response 响应
     * @param handler 处理程序
     * @param ex 异常
     * @throws Exception 完成之前处理异常
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        ThreadContextHolder.remove();

        super.afterCompletion(request, response, handler, ex);
    }
}
