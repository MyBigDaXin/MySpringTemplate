package com.example.demo.exception;

/**
 * * @description: 自定义异常
 * * @author: Tonghuan
 * * @create: 2019/3/19
 **/
public class UserNotExistException extends RuntimeException{
    public UserNotExistException() {
        super("用户不存在");
    }
}
