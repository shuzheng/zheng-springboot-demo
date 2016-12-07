package com.zheng.springboot.web;

import com.zheng.springboot.domain.User;
import com.zheng.springboot.exception.MyException;
import com.zheng.springboot.rabbitmq.Sender;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZhangShuzheng on 2016/11/16.
 */
@Controller
public class HelloController {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	/**
	 * 首页
	 * @param map
	 * @return
	 */
	@ApiOperation(value="测试首页", notes="测试首页get请求")
	@ApiImplicitParam(name = "map", value = "ModelMap实体map", required = false, dataType = "ModelMap")
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(ModelMap map) {
		map.addAttribute("host", "http://www.zhangshuzheng.cn");
		List<User> users = new ArrayList<>();
		User user = new User();
		user.setId(1l);
		user.setAge(11);
		user.setName("zhangsan");
		users.add(user);
		user = new User();
		user.setId(2l);
		user.setAge(22);
		user.setName("lisi");
		users.add(user);
		map.addAttribute("users", users);
		return "/index";
	}

	/**
	 * Spring Securety
	 * @return
	 * @throws MyException
	 */
	@RequestMapping("/hello")
	@ResponseBody
	public String hello() throws MyException {
		return "hello";
	}
	@RequestMapping("/login")
	@ResponseBody
	public String login() {
		return "login";
	}

	/**
	 * Redis
	 * @return
	 */
	@ApiOperation(value="Redis首页")
	@RequestMapping(value = "/redis", method = RequestMethod.GET)
	public String redis() {
		// 保存字符串
		stringRedisTemplate.opsForValue().set("aaa", "111");
		return stringRedisTemplate.opsForValue().get("aaa");
	}

	/**
	 * 统一异常处理
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value="错误页面1")
	@RequestMapping(value = "/error1", method = RequestMethod.GET)
	public String error1() throws Exception {
		throw new Exception("发生错误");
	}
	@ApiOperation(value="错误页面2")
	@RequestMapping(value = "/error2", method = RequestMethod.GET)
	public String error2() throws MyException {
		throw new MyException("发生错误");
	}

	/**
	 * 读取配置文件
	 */
	@Value("${spring.application.description}")
	private String appDescription;
	@ApiOperation(value="appDescription")
	@RequestMapping(value = "/appDescription", method = RequestMethod.GET)
	@ResponseBody
	public String appDescription() throws MyException {
		return appDescription;
	}

	/**
	 * 获取环境
	 */
	@Value("${profile.env}")
	private String env;
	@ApiOperation(value="env")
	@RequestMapping(value = "/env", method = RequestMethod.GET)
	@ResponseBody
	public String env() throws MyException {
		return env;
	}

	/**
	 * 发送邮件
	 */
	@Autowired
	private JavaMailSender mailSender;
	@RequestMapping(value = "/mail", method = RequestMethod.GET)
	@ResponseBody
	public String mail() throws MyException {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("xxx@163.com");
		message.setTo("xxx@163.com");
		message.setSubject("主题：简单邮件");
		message.setText("测试邮件内容");
		mailSender.send(message);
		return "success";
	}

	/**
	 * RabbitMQ
	 */
	@Autowired
	private Sender sender;
	@RequestMapping(value = "/mq", method = RequestMethod.GET)
	@ResponseBody
	public String mq() throws MyException {
		sender.send();
		return "success";
	}

}
