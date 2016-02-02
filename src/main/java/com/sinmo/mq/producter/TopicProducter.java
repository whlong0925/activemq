package com.sinmo.mq.producter;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;


@Component("topicProducter")
public class TopicProducter {
	
	@Autowired
	private JmsTemplate jmsTopicTemplate;
	
	/**
	 * 发送一条消息到指定的队列（目标）
	 * @param message 消息内容
	 */
	public void send(final String message){
		this.jmsTopicTemplate.send(new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(message);
			}
		});
	}
	public void send(String topicName,final String message){
	    this.jmsTopicTemplate.send(topicName, new MessageCreator() {
	        @Override
	        public Message createMessage(Session session) throws JMSException {
	            return session.createTextMessage(message);
	        }
	    });
	}

}
