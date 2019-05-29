package com.example.demo;

import com.example.demo.dao.MyMapper;
import com.example.demo.service.MyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private MyMapper myMapper;

	@Autowired
	private MyService myService;

	@Autowired
	private RedisTemplate<Object, Object> redisTemplate;

	@Test
	public void contextLoads() {
		String test = myService.test();
		redisTemplate.opsForList().leftPush("6",test);
		System.out.println(test);
	}

}
