package com.wing.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author memory125
 */
@Service
public class SecheduleService {

    // 在一个特定的时间执行这个方法 - Timer
    // Cron表达式
    /*
        格式： 秒 | 分 | 时 | 日 | 月 | 周几
              0/5  *   *    *   *    ?            从0秒开始，每5秒执行一次
              30  15   10   *   *    ?            每天10点15分30秒执行一次
              30 0/5 10,18 *    *    ?            每天10点和18点，每隔5分钟执行一次
              0   15  10   ?   *     1-6          每个月的周一到周六 10：15分执行
     */
    @Scheduled(cron = "0/5 * * * * ? ")
    public void scheduleTest() {
        System.out.println(this.getClass().getName() + "： 现在执行了！");
    }
}
