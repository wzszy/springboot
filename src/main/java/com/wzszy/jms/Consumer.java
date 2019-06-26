package com.wzszy.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @JmsListener(destination = "wzszy_hf")
    public void message(String text) {
        System.out.println("接收到: "+text);
    }
}
