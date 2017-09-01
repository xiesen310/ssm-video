package top.xiesen.video.web.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/8/31.
 */
public class AdminInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("后台拦截器。。。。。。");
       if(request.getServletPath().equals("/admin/login.action")){
            return true;
        }
        if(request.getServletPath().equals("/admin/exitLogin.action")){
            return true;
        }
        if(request.getServletPath().equals("/admin/dologin.action")){
            return true;
        }

        if(request.getSession().getAttribute("admin")!= null){
            return true;
        }
        request.getRequestDispatcher("/admin/login.action").forward(request,response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
