package com.ActiveMQ.server;


import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import javax.jms.Destination;

/**
 * Created by yz.shi on 2018/4/9.
 */
@Component
@EnableScheduling
public class ActiveMQServer {

    @Autowired
    private JmsTemplate jmsTemplate;

    static int index = 0;

    Destination destination = new ActiveMQQueue("mytest.queue");

    @Scheduled(fixedDelay = 5000) // 5s执行一次   只有无参的方法才能用该注解
    public void sendMessage() {
        index++;
        String message = "shiyuezhong" + index;
        this.jmsTemplate.convertAndSend(destination, message);
    }

}
