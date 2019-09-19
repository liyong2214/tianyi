package com.tianyi.system.controller;

import com.tianyi.system.entity.SystemLog;
import com.tianyi.system.log.annotation.SystemControllerLog;
import com.tianyi.system.service.SystemLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author : LiYong
 * @program : SystemLogController
 * @description : 日志
 * @date : 2019/9/16 9:35
 */
@Controller
@CrossOrigin
@RequestMapping("sys/log")
public class SystemLogController {

    @Autowired
    private SystemLogService systemLogService;

    @GetMapping("listLog")
    @SystemControllerLog(description = "查看日志")
    public ResponseEntity<List<SystemLog>> listLog() {
        return ResponseEntity.ok(systemLogService.listLog());
    }
}
