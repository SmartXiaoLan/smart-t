package cn.smart.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 全局异常处理类--2
 * 好处代码复用集中式处理
 */
//@ControllerAdvice
public class GlobalException {

    /**
     * 自定义异常跳转--全局用法
     * @param e
     * @return
     */
    @ExceptionHandler(value = {java.lang.NullPointerException.class})
    public ModelAndView nullPointExceptionHandler(Exception e ){
        //必须这样写，不可以依赖注入
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("err",e.toString());
        modelAndView.setViewName("NullError");
        return modelAndView;
    }

    /**
     * 自定义全局算数异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = {java.lang.ArithmeticException.class})
    public ModelAndView arithmeticExceptionHandler(Exception e ){
        //必须这样写，不可以依赖注入
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("err",e.toString());
        modelAndView.setViewName("mathError");
        return modelAndView;
    }
}
