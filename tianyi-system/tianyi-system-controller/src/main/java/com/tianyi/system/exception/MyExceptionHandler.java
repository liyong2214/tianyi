package com.tianyi.system.exception;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.tianyi.system.enumModule.StatusMessageEnum;
import com.tianyi.system.vo.ExceptionBean;
import org.apache.shiro.ShiroException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author : LiYong
 * @program : MyExceptionHandler
 * @description : 异常处理
 * @date : 2019/9/12 17:22
 */
@ControllerAdvice
public class MyExceptionHandler {


    /**
     * Shiro异常
     * @param e 异常
     * @return 异常信息
     */
    @ExceptionHandler(ShiroException.class)
    @ResponseBody
    public String whatever(ShiroException e) {
        return e.getMessage();
    }

    /**
     * 自定义异常
     * @param e 异常
     * @return 异常实体类
     */
    @ExceptionHandler(MyException.class)
    public ExceptionBean responseException(MyException e){
        StatusMessageEnum messageEnum = e.getStatusMessageEnum();
        return new ExceptionBean(messageEnum.getCode(),messageEnum.getMessage());
    }


    /**
     * 数据库异常
     * @param e 异常
     * @return 异常信息
     */
    @ExceptionHandler(MySQLIntegrityConstraintViolationException.class)
    @ResponseBody
    public String jdbc(Exception e) {
        return e.getMessage();
    }


    /**
     * 运行时异常
     * @param e
     * @return
     */
    /*@ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public StackTraceElement[] runtime(Exception e) {
        return e.getStackTrace();
    }*/

}
