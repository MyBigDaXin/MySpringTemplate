package com.example.demo.service;

import com.example.demo.pojo.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *功能描述  这个只是个普通的service
 * @author lth
 */

public interface UserService {

    User getNameById(Long id);

}
