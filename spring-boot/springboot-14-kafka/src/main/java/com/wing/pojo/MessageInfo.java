package com.wing.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author memory125
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageInfo {
    private Long id;    //id

    private String msg; //消息

    private Date sendTime;  //时间戳
}
