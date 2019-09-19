package com.tianyi.system.log.acpect;

import com.tianyi.system.entity.SystemLog;
import com.tianyi.system.entity.User;
import com.tianyi.system.log.annotation.SystemControllerLog;
import com.tianyi.system.log.annotation.SystemServiceLog;
import com.tianyi.system.service.SystemLogService;
import com.tianyi.system.util.IpUtil;
import com.tianyi.system.util.OJsonUtil;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Objects;

/**
 * @author : LiYong
 * @program : SystemLogAspect
 * @description : 日志管理切入点类
 * @date : 2019/9/15 20:15
 */
@Component
@Aspect
public class SystemLogAspect {
    // 注入Sevice用于把日志保存数据库
    @Autowired
    private SystemLogService systemLogService;
    // 本地异常日志记录对象
    private static final Logger LOGGER = Logger.getLogger(SystemLogService.class);

    // controller层切入点
    @Pointcut("@annotation(com.tianyi.system.log.annotation.SystemControllerLog)")
    public void controllerAspect() {
    }

    // sevice层切入点
    @Pointcut("@annotation(com.tianyi.system.log.annotation.SystemServiceLog)")
    public void serviceAspect() {
    }

    /**
     * 前置通知 用于拦截Controller层操作
     * @param joinPoint 切入点
     */
    @Before("controllerAspect()")
    public void doBefore(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes()))
                .getRequest();
        // 获取登陆用户信息
        String userStr = (String) request.getSession().getAttribute("currentUser");
        User user = OJsonUtil.toBean(userStr, User.class);
        if (Objects.isNull(user)) {
            return;
        }

        /*Object principal = SecurityUtils.getSubject().getPrincipal();
        String userName = "";
        if (principal instanceof String) {
            userName = (String) principal;
        }*/

        // 获取请求ip
        String ip = IpUtil.getClientIp(request);
        try {
            /* =========控制台输出============= */
            System.out.println("========前置通知开始==========");
            System.out.println("请求方法：" + (joinPoint.getTarget().getClass().getName() + "." +
                    joinPoint.getSignature().getName() + "()"));
            System.out.println("方法描述：" + getControllerMethodDescription(joinPoint));
            System.out.println("请求人：" + user.getUserName());
            System.out.println("请求IP：" + ip);
            /* ===========数据库日志=========== */
            SystemLog log = new SystemLog();
            log.setCreateAccount(user.getUserAccount());
            log.setCreateUser(user.getUserName());
            log.setRequestUrl(request.getRequestURL().toString());
            log.setRequestIp(ip);
            log.setRequestTime(new Date());
            log.setLogDes(getControllerMethodDescription(joinPoint));
            log.setLogMethod((joinPoint.getTarget().getClass().getName() + "." +
                    joinPoint.getSignature().getName() + "()"));
            // 保存数据库
            systemLogService.saveLog(log);
            System.out.println("=========前置通知结束========");
        } catch (Exception e) {
            // 记录本地异常日志
            LOGGER.error("==前置通知异常==");
            LOGGER.error("异常信息：{}", e);
        }
    }

    /**
     * 异常通知，用于拦截service层记录异常日志
     *
     * @param joinPoint 切入点
     * @param e         异常
     */
    @AfterThrowing(pointcut = "serviceAspect()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
        HttpServletRequest request =
                ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        // 获取登陆用户信息
        String userStr = (String) request.getSession().getAttribute("currentUser");
        User user = OJsonUtil.toBean(userStr, User.class);
        if (Objects.isNull(user)) {
            return;
        }
        // 获取请求ip
        String ip = IpUtil.getClientIp(request);
        // 获取用户请求方法的参数并序列化为 JSON 格式字符串
        String params = "";
        Object[] args = joinPoint.getArgs();
        if (args != null) {
            params = OJsonUtil.toString(args);
        }
        try {
            /* ==========控制台输出========== */
            System.out.println("=============异常通知开始=============");
            System.out.println("异常代码：" + e.getClass().getName());
            System.out.println("异常信息：" + e.getMessage());
            System.out.println("异常方法：" + (joinPoint.getTarget().getClass().getName() + "." +
                    joinPoint.getSignature().getName() + "()"));
            System.out.println("方法描述：" + getServiceMethodDescription(joinPoint));
            System.out.println("请求人：" + user.getUserName());
            System.out.println("请求IP：" + ip);
            System.out.println("请求参数：" + params);
            /* ===========数据库日志============ */
            SystemLog log = new SystemLog();
            log.setCreateAccount(user.getUserAccount());
            log.setCreateUser(user.getUserName());
            log.setRequestUrl(request.getRequestURL().toString());
            log.setRequestIp(ip);
            log.setRequestTime(new Date());
            log.setLogDes(getServiceMethodDescription(joinPoint));
            log.setLogMethod((joinPoint.getTarget().getClass().getName() + "." +
                    joinPoint.getSignature().getName() + "()"));
            log.setExceptionCode(e.getClass().getName());
            log.setExceptionDetail(e.getMessage());
            // 保存数据库
            systemLogService.saveLog(log);
            System.out.println("========异常通知结束=========");
        } catch (Exception ex) {
            // 记录本地异常日志
            LOGGER.error("==异常通知异常==");
            LOGGER.error("异常信息：{}", ex);
        }
    }

    public static String getServiceMethodDescription(JoinPoint joinPoint) throws ClassNotFoundException {
        // 获取目标类名
        String targetName = joinPoint.getTarget().getClass().getName();
        // 获取方法名
        String methodName = joinPoint.getSignature().getName();
        // 获取相关参数
        Object[] args = joinPoint.getArgs();
        // 生成类对象
        Class targetClass = Class.forName(targetName);
        // 获取该类中的方法
        Method[] methods = targetClass.getMethods();

        String description = "";

        for (Method method : methods) {
            if (!method.getName().equals(methodName)) {
                continue;
            }
             Class[] classes = method.getParameterTypes();
            if (classes.length != args.length) {
                continue;
            }
            description = method.getAnnotation(SystemServiceLog.class).description();
        }

        return description;
    }

    /**
     * 获取注解中对方法的描述信息，用于Controller层注解
     *
     * @param joinPoint 切点
     * @return 方法描述
     * @throws ClassNotFoundException 没找到
     */
    public static String getControllerMethodDescription(JoinPoint joinPoint) throws ClassNotFoundException {
        // 获取目标类名
        String targetName = joinPoint.getTarget().getClass().getName();
        // 获取方法名
        String methodName = joinPoint.getSignature().getName();
        // 获取相关参数
        Object[] args = joinPoint.getArgs();
        // 生成类对象
        Class targetClass = Class.forName(targetName);
        // 获取类中的方法
        Method[] methods = targetClass.getMethods();

        String description = "";

        for (Method method : methods) {
            if (!method.getName().equals(methodName)) {
                continue;
            }
            Class[] classes = method.getParameterTypes();
            if (classes.length != args.length) {
                continue;
            }
            description = method.getAnnotation(SystemControllerLog.class).description();
        }

        return description;
    }
}
