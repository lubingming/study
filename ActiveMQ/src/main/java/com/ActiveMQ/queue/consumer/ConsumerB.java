package com.ActiveMQ.queue.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * Created by yz.shi on 2018/4/9.
 */
@Component
public class ConsumerB {
    /**
     * 使用JmsListener配置消费者监听的队列
     *
     * @param text 接收到的消息
     */
    @JmsListener(destination = "yzshi_queue")
    @SendTo("out.queue")
    public String receiveQueue(String text) {
        System.out.println("----------------Consumer-B : 收到的报文为:" + text);
        return text;
    }

    @JmsListener(destination = "yzshi_queue")
    public void printReceiveQueue(String text) {
        System.out.println("+++++++++++++++++Consumer-B : 收到的报文为:" + text);
    }

}
