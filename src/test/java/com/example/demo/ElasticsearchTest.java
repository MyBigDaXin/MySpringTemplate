package com.example.demo;

import com.example.demo.elasticSearch.UserRepository;
import com.example.demo.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

/**
 * * @description:  elasticSearch测试
 * * @author: Tonghuan
 * * @create: 2019/3/21
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticsearchTest {




    @Test
    public void test(){
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setUsername("852172031");
        user.setPassword("123");
        user.setName("天线宝宝");


       // Repository.index(user);
    }
}
