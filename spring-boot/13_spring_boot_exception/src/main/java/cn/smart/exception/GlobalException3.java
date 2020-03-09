package cn.smart.exception;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义全局异常处理--4
 * 需要实现HandlerExceptionResolver接口
 */
@Configuration
public class GlobalException3 implements HandlerExceptionResolver {


    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) {
        ModelAndView view = new ModelAndView();
        //判断不同异常类型，做不同试图跳转
        if (e instanceof NullPointerException){
            view.setViewName("NullError3");
        }
        if (e instanceof ArithmeticException){
            view.setViewName("mathError3");
        }
        //............
        view.addObject("err",e.toString());
        return view;
    }
}
