package com.tianyi.system.interceptor;

import org.apache.http.client.utils.DateUtils;
import org.apache.log4j.Logger;
import org.springframework.core.NamedThreadLocal;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * @author : LiYong
 * @program : LogInterceptor
 * @description : 日志拦截器
 * @date : 2019/9/15 17:28
 */
public class LogInterceptor implements HandlerInterceptor {

    public static final Logger LOGGER = Logger.getLogger(LogInterceptor.class);

    private static final ThreadLocal<Long> startTimeThreadLocal = new NamedThreadLocal<>("ThreadLocal StartTime");

    private String getParamString(Map<String, String[]> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String[]> entry : map.entrySet()) {
            sb.append(entry.getKey()).append("=");
            final String[] value = entry.getValue();
            if (value!=null && value.length == 1) {
                sb.append(value[0]).append("\t");
            } else {
                sb.append(Arrays.toString(value)).append("\t");
            }
        }
        return sb.toString();
    }


    public static String getStackTraceAsString(Throwable e) {
        if (e==null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        e.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        final long startTime = System.currentTimeMillis();
        request.setAttribute("startTime",startTime);
        startTimeThreadLocal.set(startTime);  // 线程绑定变量（该数据只有当前请求的线程可见）
        if (handler instanceof HandlerMethod) {
            StringBuilder sb = new StringBuilder(1000);
            sb.append("\n-------------------------开始计时：").append(new SimpleDateFormat("hh:mm:ss.SSS").format(startTime))
                    .append("-----------------------------\n");
            HandlerMethod method = (HandlerMethod) handler;
            sb.append("Controller: ").append(method.getBean().getClass().getName()).append("\n");
            sb.append("Method    : ").append(method.getMethod().getName()).append("\n");
            sb.append("Params    : ").append(getParamString(request.getParameterMap())).append("\n");
            sb.append("URI       : ").append(request.getRequestURI()).append("\n");
            LOGGER.info(sb.toString());
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long startTime = (long) request.getAttribute("startTime");
        long endTime = System.currentTimeMillis();
        long executeTime = endTime - startTime;
        if (handler instanceof HandlerMethod) {
            StringBuilder sb = new StringBuilder(1000);
            sb.append("CostTime : ").append(executeTime).append("ms").append("\n");
            sb.append("------------------------------------------------------------------------------------");
            LOGGER.info(sb.toString());
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 打印JVM信息
        if (LOGGER.isInfoEnabled()) {
            long beginTime = startTimeThreadLocal.get();  // 得到线程绑定的局部表里（开始时间）
            long endTime = System.currentTimeMillis();   // 结束时间

            // 如果controller报错，则记录异常错误
            if (ex != null) {
                LOGGER.info("Controller异常：" + getStackTraceAsString(ex));
            }

            Date date = new Date();
            date.setTime(endTime - beginTime);

            /*LOGGER.info("计时结束：" + new SimpleDateFormat("hh:mm:ss.SSS").format(endTime) + "耗时：" +
                    DateUtils.formatDate(date) + " URI: " + request.getRequestURI()+ " 最大内存：" + Runtime.getRuntime().maxMemory()/1024/1024+
                    "m 以分配内存：" +Runtime.getRuntime().totalMemory()/1024/1024 + "m 已分配内存中的剩余空间：" +
                    Runtime.getRuntime().freeMemory()/1024/1024 + "m 最大可用内存：" +
                    (Runtime.getRuntime().maxMemory() - Runtime.getRuntime().totalMemory() + Runtime.getRuntime().freeMemory())/1024/1024 + "m");*/
            startTimeThreadLocal.remove();
        }
    }
}
