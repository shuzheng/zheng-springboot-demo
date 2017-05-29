package com.zheng.springboot.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ZhangShuzheng on 2016/12/7.
 */
@Component
public class Sender {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send() {
		long time = System.currentTimeMillis();
		System.out.println("生产开始时间：" + time);
		for (int i = 1; i <= 100000; i ++) {
			this.rabbitTemplate.convertAndSend("hello", "message" + i);
		}
		System.out.println("生产结束时间：{}" + (System.currentTimeMillis() - time));
	}

}
