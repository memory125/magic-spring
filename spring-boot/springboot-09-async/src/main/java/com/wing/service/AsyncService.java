package com.wing.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author memory125
 */
@Service
public class AsyncService {

    // 告知Spring这是一个异步的方法
    @Async
    public void delayTest() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("数据正在处理.......");
    }
}
