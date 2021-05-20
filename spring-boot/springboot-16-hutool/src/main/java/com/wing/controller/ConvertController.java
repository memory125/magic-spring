package com.wing.controller;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.CharsetUtil;
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

        String resultStr = HUTOOL_CONVERT + "String Array ---->" + res1.toString() + "  == Long Array ---->" + res2.toString();

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

    @RequestMapping("/c4")
    @ResponseBody
    public String test4() {
        Object[] a = {"a", "你", "好", "", 1};
       // List<?> list = Convert.convert(List.class, a);
        //从4.1.11开始可以这么用
        List<?> list = Convert.toList(a);

        String resultStr = HUTOOL_CONVERT + "List Type---->" + list.toString();

        return resultStr;
    }

    @RequestMapping("/c5")
    @ResponseBody
    public String test5() {
        String a = "123456789";

        //结果为："１２３４５６７８９"
        String sbc = Convert.toSBC(a);

        String b = "１２３４５６７８９";

        //结果为"123456789"
        String dbc = Convert.toDBC(b);

        String resultStr = HUTOOL_CONVERT + "SBC Type---->" + sbc + "  == DBC Type---->" + dbc;

        return resultStr;
    }

    @RequestMapping("/c6")
    @ResponseBody
    public String test6() {
        String a = "我是一个小小的可爱的字符串";

        //结果："e68891e698afe4b880e4b8aae5b08fe5b08fe79a84e58fafe788b1e79a84e5ad97e7aca6e4b8b2"
        String hex1 = Convert.toHex(a, CharsetUtil.CHARSET_UTF_8);

        String hex2 = "e68891e698afe4b880e4b8aae5b08fe5b08fe79a84e58fafe788b1e79a84e5ad97e7aca6e4b8b2";

        //注意：在4.1.11之后hexStrToStr将改名为hexToStr
        String raw = Convert.hexToStr(hex2, CharsetUtil.CHARSET_UTF_8);

        String resultStr = HUTOOL_CONVERT + "String to HEX Type---->" + hex1 + "  == HEX To String Type---->" + raw;;

        return resultStr;
    }

}
