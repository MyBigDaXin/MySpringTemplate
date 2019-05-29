package com.example.demo;

import com.example.demo.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

/**
 * * @description:
 * * @author: Tonghuan
 * * @create: 2019/3/19
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate; // 存的是的对象

    @Autowired
    private StringRedisTemplate stringRedisTemplate; // 存的是字符串

    @Test
    public void test(){
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setUsername("张三");
        user.setPassword("12312");
        user.setName("111");

        //redisTemplate.opsForList().leftPush("一个",user);
       // redisTemplate.opsForValue().set("user",user);
        stringRedisTemplate.opsForValue().set("dept","aa");

    }

}
