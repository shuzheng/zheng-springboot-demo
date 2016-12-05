package com.zheng.springboot.web;

import com.zheng.springboot.domain.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZhangShuzheng on 2016/11/16.
 */
@Controller
public class HelloController {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@ApiOperation(value="测试首页", notes="测试首页get请求")
	@ApiImplicitParam(name = "map", value = "ModelMap实体map", required = false, dataType = "ModelMap")
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String index(ModelMap map) {
		map.addAttribute("host", "http://www.zhangshuzheng.cn");
		List<User> users = new ArrayList<>();
		User user = new User();
		user.setId(null);
		user.setAge(11);
		user.setName("");
		users.add(user);
		user = new User();
		user.setId(2l);
		user.setAge(22);
		user.setName("lisi");
		users.add(user);
		map.addAttribute("users", users);
		return "/index";
	}

	@ApiOperation(value="Redis首页")
	@RequestMapping(value = "/redis", method = RequestMethod.GET)
	public String redis() {
		// 保存字符串
		stringRedisTemplate.opsForValue().set("aaa", "111");
		return stringRedisTemplate.opsForValue().get("aaa");
	}

}
