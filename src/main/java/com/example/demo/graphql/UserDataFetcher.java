package com.example.demo.graphql;

import com.example.demo.service.UserService;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * * @description: 为了更好的操控GrapQLProvider 具体dataFetcher根据业务需要去实现
 * * @author: Tonghuan
 * * @create: 2019/4/1
 **/
@Component
public class UserDataFetcher implements MyDataFetcher{

    @Autowired
    private UserService userService;

    @Override
    public String filedName() {
        return "User";
    }

    @Override
    public Object dataFetcher(DataFetchingEnvironment environment) {
        Long id = environment.getArgument("id");
       return this.userService.getNameById(id);
    }
}
