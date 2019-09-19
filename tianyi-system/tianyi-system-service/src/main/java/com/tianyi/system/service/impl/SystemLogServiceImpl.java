package com.tianyi.system.service.impl;

import com.tianyi.system.entity.SystemLog;
import com.tianyi.system.mapper.SystemLogMapper;
import com.tianyi.system.service.SystemLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author : LiYong
 * @program : SystemLogServiceImpl
 * @description :
 * @date : 2019/9/15 20:25
 */
@Service
@Transactional
public class SystemLogServiceImpl implements SystemLogService {

    @Autowired
    private SystemLogMapper systemLogMapper;

    /**
     * 保存日志
     *
     * @param log 日志
     */
    @Override
    public void saveLog(SystemLog log) {
        if (log == null) {
            return;
        }
        systemLogMapper.insert(log);
    }

    /**
     * 查询所有日志
     *
     * @return 日志列表
     */
    @Override
    public List<SystemLog> listLog() {
        return systemLogMapper.selectByExample(null);
    }
}
