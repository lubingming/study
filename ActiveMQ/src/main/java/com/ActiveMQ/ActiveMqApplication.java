package com.ActiveMQ;


import com.ActiveMQ.queue.producer.Producer;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.annotation.PostConstruct;
import javax.jms.Destination;

@SpringBootApplication
public class ActiveMqApplication {

    @Autowired
    private Producer producer;

    @PostConstruct
    public void init() {
        int num = 10;
        try {
            Destination destinationQueue = new ActiveMQQueue("yzshi_queue");
            for (int i = 1; i <= num; i++) {
                producer.convertAndSend(destinationQueue, "这是主queueProducer发送的第" + i + "个消息！");
            }
            System.out.println("activeMQ生产成功！");
        } catch (Exception e) {
            System.out.println("activeMQ生产失败！");
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(ActiveMqApplication.class, args);
    }


}

