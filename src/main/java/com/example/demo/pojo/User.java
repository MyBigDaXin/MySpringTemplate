package com.example.demo.pojo;

import com.example.demo.base.BasePojo;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * * @description:
 * document:elasticsearch的注解,indexName=索引名 type类型
 * * @author: Tonghuan
 * * @create: 2019/3/19
 **/
@Data
@Document(indexName = "example",type = "user")
public class User extends BasePojo implements Serializable{

    private String id;

    private String username;

    private String password;

    private String name;

}
