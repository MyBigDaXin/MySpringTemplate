package com.example.demo.controller;

import com.example.demo.service.MyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MyController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyController.class);

    @Autowired
    private MyService myService;

    @RequestMapping(value = "/test")
    public String getShufflingImg(){
        System.out.println("11");
        return myService.test();
    }
    @RequestMapping(value = "/asyc")
    public String not(){
        myService.asyc();
        return "aa";
    }
}
