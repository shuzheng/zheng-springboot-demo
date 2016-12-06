package com.zheng;

import com.zheng.springboot.SpringbootApplication;
import com.zheng.springboot.dao.UserMapper;
import com.zheng.springboot.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootApplication.class)
public class SpringbootApplicationTests {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private UserMapper userMapper;

	@Test
	public void contextLoads() {
		System.out.println("=============================== redis start ===============================");
		// 保存字符串
//		stringRedisTemplate.opsForValue().set("aaa", "111");
//		Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
		System.out.println("=============================== redis end ===============================");

		userMapper.insert("zhangsan", 1);
		userMapper.insert("lisi", 2);
		userMapper.insert("wangwu", 3);
		userMapper.insert("zhaoliu", 4);

		User user = userMapper.findByName("lisi");
		System.out.println(user.getId());

	}

}
