package com.zheng.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ZhangShuzheng on 2016/12/7.
 */
@RefreshScope
@RestController
public class TestController {

	@Value("${from}")
	private String from;
	@RequestMapping("/from")
	public String from() {
		return this.from;
	}

}
