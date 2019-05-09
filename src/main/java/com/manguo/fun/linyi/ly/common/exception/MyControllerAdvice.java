package com.manguo.fun.linyi.ly.common.exception;

import com.manguo.fun.linyi.ly.common.LinYiException;
import com.manguo.fun.linyi.ly.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

/**
 * @author linyi
 */
@ControllerAdvice
@Slf4j
public class MyControllerAdvice {

    /**
     * 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
     *
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
    }

    /**
     * 把值绑定到Model中，使全局@RequestMapping可以获取到该值
     *
     * @param model
     */
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("author", "Magical Sam");
    }

    /**
     * 全局异常捕捉处理
     *
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Result errorHandler(Exception ex) {

        //除了自定义异常,都是系统异常  没毛病
        ex.printStackTrace();

        if (ex instanceof LinYiException) {
            return Result.error(9000, ex.getMessage());
        } else {
            return Result.error(9000, "系统异常");
        }
    }

}