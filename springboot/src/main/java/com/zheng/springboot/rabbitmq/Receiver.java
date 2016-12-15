package com.zheng.springboot.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by ZhangShuzheng on 2016/12/7.
 */
@Component
@RabbitListener(queues = "hello")
public class Receiver {

	@RabbitHandler
	public void process(String hello) {
		if (hello.equals("message1")) {
			System.out.println("消费开始时间：" + System.currentTimeMillis());
		}
		if (hello.equals("message100000")) {
			System.out.println("消费结束时间：" + System.currentTimeMillis());
		}
	}

}
