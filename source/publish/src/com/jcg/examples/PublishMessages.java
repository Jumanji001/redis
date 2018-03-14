package com.jcg.examples;

import org.springframework.data.redis.core.StringRedisTemplate;

public class PublishMessages{
	
	public StringRedisTemplate redisTemplate;
	
	public String channel;

	
	public void publishMessage(String message){
		this.redisTemplate.convertAndSend(channel, message);
	}
	
	public StringRedisTemplate getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(StringRedisTemplate redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}


}
