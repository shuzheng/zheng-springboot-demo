package com.zheng.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by ZhangShuzheng on 2016/12/2.
 */
@Component
public class ComputeClientHystrix implements ComputeClient {

	@Override
	public Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b) {
		return -9999;
	}

}
