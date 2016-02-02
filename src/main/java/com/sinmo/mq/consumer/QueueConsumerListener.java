
package com.sinmo.mq.consumer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class QueueConsumerListener implements MessageListener {

	@Override
	public void onMessage(Message message) {
		try {
			System.out.println(Thread.currentThread().getName()+"=QueueConsumer接收到消息:"+((TextMessage)message).getText());
//			if(true){
//			    throw new RuntimeException("测试异常是否回滚");
//			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
