package com.jcg.examples;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.StringRedisTemplate;

public class TopicMessageListener implements MessageListener{
	
	public StringRedisTemplate redisTemplate;
	
	

	public StringRedisTemplate getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(StringRedisTemplate redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	@Override
	public void onMessage(Message message, byte[] arg1) {
		
		  byte[] body = message.getBody();
	      byte[] channel = message.getChannel();  

	      String _message = (String)this.redisTemplate.getValueSerializer().deserialize(body);  
	      String topic = (String)this.redisTemplate.getStringSerializer().deserialize(channel);
	      
	      System.out.println("###################### GET MESSAGES FROM CHANNEL : ###########################" + topic);
	      System.out.println("###################### GET MESSAGES : ###########################" + _message);
		
	}
	
	
	
	

}
