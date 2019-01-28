package com.ActiveMQ.queue.producer;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import javax.jms.Destination;
import javax.annotation.Resource;

/**
 * Created by yz.shi on 2018/4/9.
 */
@Service("producer")
public class Producer {
    @Resource
    private JmsTemplate jmsTemplate;

    /**
     * 发送消息（主方法设置队列）
     *
     * @param destination 发送到的队列
     * @param message     待发送的消息
     */
    public void convertAndSend(Destination destination, final String message) {
        jmsTemplate.convertAndSend(destination, message);
    }

    /**
     * 发送消息（定时发送队列）
     */
    static int i = 100;
    Destination destination = new ActiveMQQueue("yzshi_queue");

    @Scheduled(fixedDelay = 5000) // 5s执行一次   只有无参的方法才能用该注解
    public void convertAndSend() {
        i++;
        String message = "这是定时任务queueProducer发送的第" + i + "个消息！";
        jmsTemplate.convertAndSend(destination, message);
    }

}
