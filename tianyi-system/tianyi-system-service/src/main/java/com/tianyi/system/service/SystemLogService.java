package com.tianyi.system.service;

import com.tianyi.system.entity.SystemLog;

import java.util.List;

/**
 * @author : LiYong
 * @program : SystemLogService
 * @description : 日志管理
 * @date : 2019/9/15 20:25
 */
public interface SystemLogService {

    /**
     * 保存日志
     * @param log 日志
     */
    void saveLog(SystemLog log);

    /**
     * 查询所有日志
     * @return 日志列表
     */
    List<SystemLog> listLog();
}
