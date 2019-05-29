package com.example.demo.service;


import com.example.demo.dao.MyMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Service
public class MyService {
    Logger logger = LoggerFactory.getLogger(MyService.class);

    @Autowired
    private MyMapper MyMapper;

    @Cacheable(cacheNames = {"user"},key = "#root.methodName")
    public String test() {
        System.out.println("调用了");
        return MyMapper.test();
    }

    /**
     *功能描述 监听指定队列的信息,默认封装为message
     * @author lth
     * @param
     * @return void
     */
    @RabbitListener(queues = "at.emps")
    public void recice(Message message){
        System.out.println(message.getMessageProperties());
        System.out.println(message.getBody());
    }
    @Async
    public void asyc(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
