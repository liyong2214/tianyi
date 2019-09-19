package com.tianyi.system.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @author : LiYong
 * @program : IpUtil
 * @description : ip工具
 * @date : 2019/9/15 20:46
 */
public class IpUtil {

    /**
     * 从request中获取请求方IP
     * @param request request
     * @return 真实ip地址
     */
    public static String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("X-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
