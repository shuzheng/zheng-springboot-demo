package com.zheng.springboot.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ZhangShuzheng on 2016/12/5.
 */
@Component
public class ScheduledTasks {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Scheduled(fixedRate = 5000 * 60)
	public void reportCurrentTime() {
		System.out.println("当前时间：" + dateFormat.format(new Date()));
	}

	@Scheduled(cron = "0 0/5 * * * ?")
	public void test() {
		System.out.println("test");
	}

}
