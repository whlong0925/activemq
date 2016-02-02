package com.sinmo.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jms.Destination;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sinmo.mq.producter.QueueProducter;
import com.sinmo.mq.producter.TopicProducter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-amq.xml")
public class SpringAMQTest {

    @Autowired
    private Destination queueDestination;

    @Autowired
    private Destination topicDestination;

    /**
     * 主题消息发布者
     */
    @Autowired
    private TopicProducter topicProducter;

    /**
     * 队列消息生产者
     */
    @Autowired
    private QueueProducter queueProducter;

    @SuppressWarnings("static-access")
    @Test
    public void testQueue() throws InterruptedException {
        for(int i=0;i<20;i++){
            String mess = new SimpleDateFormat("yyyy-MM-dd/HH:mm:ss").format(new Date());
            Thread.currentThread().sleep(1000);
            System.out.println("-----"+mess);
            String msg = "Hello Queue!"  + mess;
            this.queueProducter.send(msg);
        }
       // Thread.currentThread().sleep(30000);
       
    }

    @Test
    public void testTopic() throws Exception {
        String msg = "Hello Topic!";
        this.queueProducter.send(msg);
    }

}