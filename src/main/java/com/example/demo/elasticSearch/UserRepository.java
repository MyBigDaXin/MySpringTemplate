package com.example.demo.elasticSearch;

import com.example.demo.pojo.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * * @description: elasticSearch的数据库
 * * @author: Tonghuan
 * * @create: 2019/3/21
 **/
@Component
public interface UserRepository {
// extends ElasticsearchRepository<User,Integer>

}
