package com.wzszy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 消息生产者
 */
@RestController
public class QueueController {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @GetMapping("send")
    public String send(String text) {
        jmsMessagingTemplate.convertAndSend("wzszy_hf",text);
        System.out.println("发送消息");
        return "OK";
    }
}
