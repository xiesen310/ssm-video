package top.xiesen.video.web.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/8/31.
 */
public class FrontInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.out.println("前端拦截器");
       /*if(request.getServletPath().equals("/front/user/login.action")){
            return true;
        }*/
        if(request.getSession().getAttribute("user")!= null || request.getSession().getAttribute("_front_user")!= null){
            return true;
        }
        request.getRequestDispatcher("/front/toIndex.action").forward(request,response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
