package com.tianyi.system.log.annotation;

import java.lang.annotation.*;

/**
 * @author : LiYong
 * @program : SystemServiceLog
 * @description : 系统级别的service层自定义注解
 * @date : 2019/9/15 20:12
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})  // 作用于参数或方法上
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemServiceLog {
    String description() default "";
}
