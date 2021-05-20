package com.wing.controller;

import cn.hutool.core.date.ChineseDate;
import cn.hutool.core.date.DateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Calendar;
import java.util.Date;

/**
 * @author memory125
 */
@Controller
public class DateController {
    public static final String HUTOOL_DATE = "Hutool Date ===> Convert: ";

    @RequestMapping("/d1")
    @ResponseBody
    public String test1() {
        //当前时间
        Date date1 = DateUtil.date();
        //当前时间
        Date date2 = DateUtil.date(Calendar.getInstance());
        //当前时间
        Date date3 = DateUtil.date(System.currentTimeMillis());
        //当前时间字符串，格式：yyyy-MM-dd HH:mm:ss
        String now = DateUtil.now();
        //当前日期字符串，格式：yyyy-MM-dd
        String today= DateUtil.today();

        String resultStr = HUTOOL_DATE + "Date Type1---->" + date1 + " ==Date Type2---->" + date2 + " ==Date Type3---->" + date3 + "  == Date To Now Type---->" + now + "  == Date To Today Type---->" + today;

        return resultStr;
    }

    @RequestMapping("/d2")
    @ResponseBody
    public String test2() {
        String dateStr = "2017-03-01";
        Date date = DateUtil.parse(dateStr);

        //结果 2017/03/01
        String format = DateUtil.format(date, "yyyy/MM/dd");

        //常用格式的格式化，结果：2017-03-01
        String formatDate = DateUtil.formatDate(date);

        //结果：2017-03-01 00:00:00
        String formatDateTime = DateUtil.formatDateTime(date);

        //结果：00:00:00
        String formatTime = DateUtil.formatTime(date);

        String resultStr = HUTOOL_DATE + "Date Format ---->" + format + " ==Date FormatDate---->" + formatDate + " ==Date FormatDateTime---->" + formatDateTime + "  == Date FormatTime---->" + formatTime;

        return resultStr;
    }

    @RequestMapping("/d3")
    @ResponseBody
    public String test3() {
        //通过公历构建
        ChineseDate date = new ChineseDate(DateUtil.parseDate("2020-01-25"));
        // 一月
        date.getChineseMonth();
        // 正月
        date.getChineseMonthName();
        // 初一
        date.getChineseDay();
        // 庚子
        date.getCyclical();
        // 生肖：鼠
        date.getChineseZodiac();
        // 传统节日（部分支持，逗号分隔）：春节
        date.getFestivals();
        // 庚子鼠年 正月初一
        date.toString();

        String resultStr = HUTOOL_DATE + "ChineseDate getChineseMonth---->" + date.getChineseMonth()
                + " ==ChineseDate getChineseMonthName---->" + date.getChineseMonthName()
                + " ==ChineseDate getChineseDay---->" + date.getChineseDay()
                + "  == ChineseDate getCyclical---->" +  date.getCyclical()
                + " ==ChineseDate getCyclical---->" + date.getCyclical()
                + " ==ChineseDate getChineseZodiac---->" + date.getChineseZodiac()
                + " ==ChineseDate toString---->" +  date.toString();

        return resultStr;
    }
}
