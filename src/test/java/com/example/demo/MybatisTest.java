package com.example.demo;

import com.example.demo.dao.MyMapper;
import com.example.demo.pojo.User;
import com.example.demo.service.Impl.UserServiceImpl;
import com.example.demo.service.UserService;
import net.bytebuddy.asm.Advice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

/**
 * * @description: mybatis及mybatisPlus的测试
 * * @author: Tonghuan
 * * @create: 2019/4/1
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisTest {

    @Autowired
    private MyMapper myMapper;

    @Autowired
    private UserService userService;

    @Test
    public void test(){
        String test = myMapper.test();
        System.out.println(test);
    }

    @Test
    public void test2(){
        User nameById = userService.getNameById(1L);
        System.out.println(nameById);
    }

}
