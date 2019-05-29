package com.example.demo;

import com.example.demo.pojo.User;
import com.google.common.collect.Maps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.UUID;

/**
 * * @description:
 * * @author: Tonghuan
 * * @create: 2019/3/19
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMQTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private AmqpAdmin admin;

    /**
     *功能描述 点对点方式
     * @author lth
     * @param
     * @return void
     */
    @Test
    public void test(){
        HashMap<Object, Object> map = Maps.newHashMap();
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setUsername("你好");
        user.setPassword("123");
        user.setName("里斯");


        map.put("msg","第一个数据");
        map.put("user",user);
        rabbitTemplate.convertAndSend("exchange.direct","*.news",map);

    }


    /**
     *功能描述 接收数据
     * @author lth
     * @param
     * @return void
     */
    @Test
    public void test2(){
        Object o = rabbitTemplate.receiveAndConvert("aa");
        System.out.println(o.getClass());
        System.out.println(o);
    }

    /**
     *功能描述 广播形式
     * @author lth
     * @param
     * @return void
     */
    @Test
    public void test3(){
        HashMap<Object, Object> map = Maps.newHashMap();
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setUsername("你好");
        user.setPassword("123");
        user.setName("里斯");


        map.put("msg","第一个数据");
        map.put("user",user);
        rabbitTemplate.convertAndSend("amq.fanout","",map);
    }

    // 用java代码进行rabbitMQ的创建

    @Test
    public void test4(){
        //admin.declareExchange(new DirectExchange("aa.xxx"));
        admin.declareQueue(new Queue("aa",true));
        admin.declareBinding(new Binding("aa",Binding.DestinationType.QUEUE,"aa.xxx","aa",null));
    }
}

