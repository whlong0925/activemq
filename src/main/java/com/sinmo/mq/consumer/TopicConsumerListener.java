package com.sinmo.mq.consumer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;


public class TopicConsumerListener implements MessageListener{

	@Override
	public void onMessage(Message message) {
		try {
			System.out.println("TopicConsumer接收到消息:"+((TextMessage)message).getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
}
