package com.zheng.web;

import com.zheng.service.ComputeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ZhangShuzheng on 2016/11/23.
 */
@RestController
public class ConsumerController {

	@Autowired
	ComputeClient computeClient;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public Integer add() {
		return computeClient.add(10, 20);
	}

}
