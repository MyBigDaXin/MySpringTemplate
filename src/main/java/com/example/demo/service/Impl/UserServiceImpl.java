package com.example.demo.service.Impl;

import com.example.demo.base.BaseServiceImpl;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * * @description:
 * * @author: Tonghuan
 * * @create: 2019/4/1
 **/
@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{

    @Override
    public User getNameById(Long id) {
       return super.queryById(id);
    }
}
