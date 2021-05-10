package com.wing.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wing.pojo.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author memory125
 */
@RestController
public class KafkaController {

    private Gson gson = new GsonBuilder().create();
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @RequestMapping("/send/{name}")
    public String send(@PathVariable("name") String name) {
        MessageInfo message = new MessageInfo();
        message.setId(System.currentTimeMillis());
        message.setMsg(name);
        message.setSendTime(new Date());
        System.out.println("+++++++++++++++++++++  message = {}"+ gson.toJson(message));
        //这里发送到那个消息topic（wing），并设置发送的数据
        kafkaTemplate.send("wing", gson.toJson(message));
        return "Hello, Kafka!" + name;
    }
}
