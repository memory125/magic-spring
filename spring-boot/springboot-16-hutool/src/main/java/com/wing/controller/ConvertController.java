package com.wing.controller;

import cn.hutool.core.convert.Convert;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author memory125
 */
@Controller
public class ConvertController {

    public static final String HUTOOL_CONVERT = "Hutool Test ===> Convert: ";

    @RequestMapping("/c1")
    @ResponseBody
    public String test1() {
        int a = 1;
        //aStr为"1"
        String aStr = Convert.toStr(a);

        long[] b = {1,2,3,4,5};
        //bStr为："[1, 2, 3, 4, 5]"
        String bStr = Convert.toStr(b);

        String resultStr = HUTOOL_CONVERT + "Data Type---->" + bStr;

        return resultStr;
    }

    @RequestMapping("/c2")
    @ResponseBody
    public String test2() {
        String[] b = { "1", "2", "3", "4" };
        //结果为Integer数组
        Integer[] intArray = Convert.toIntArray(b);

        List<String> res1 = new ArrayList<>();

        Arrays.stream(intArray).forEach(a -> {
            res1.add(a.toString());
            System.out.println(a);
        });

        long[] c = {1,2,3,4,5};
        //结果为Integer数组
        Integer[] intArray2 = Convert.toIntArray(c);
        List<String> res2 = new ArrayList<>();
        Arrays.stream(intArray2).forEach(a -> {
            res2.add(a.toString());
            System.out.println(a);
        });

        String resultStr = HUTOOL_CONVERT + "String Array ---->" + res1.toString() + "\r\n Long Array ---->" + res2.toString();

        return resultStr;
    }

    @RequestMapping("/c3")
    @ResponseBody
    public String test3() {
        String a = "2017-05-06";
        Date dateValue = Convert.toDate(a);

        String resultStr = HUTOOL_CONVERT + "Date Type---->" + dateValue;

        return resultStr;
    }
}
