package com.wing.controller;

import com.wing.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author memory125
 */
@RestController
public class AsyncController {
    @Autowired
    AsyncService asyncService;

    @RequestMapping("/delay")
    public String deleyT() {
        // 停止3秒，转圈。。。
        asyncService.delayTest();
        return "OK";
    }
}
