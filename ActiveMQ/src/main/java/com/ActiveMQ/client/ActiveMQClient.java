package com.ActiveMQ.client;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Created by yz.shi on 2018/4/9.
 */
@Component
public class ActiveMQClient {

    // 使用JmsListener配置消费者监听的队列，其中text是接收到的消息
    @JmsListener(destination = "mytest.queue")
    public void receiveQueue(String text) {
        if(!StringUtils.isEmpty(text)){
            System.out.println("ActiveMQServer收到的报文为:"+text);
            System.out.println("");
        }
    }
}