package com.zheng.controller;

import com.zheng.service.WmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wms")
public class WmsController {

	@Autowired
	WmsService wmsService;

	@GetMapping("/buy")
	public String buy(int userId) {
		return wmsService.buy(userId);
	}

}
