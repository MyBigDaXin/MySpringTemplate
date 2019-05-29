package com.example.demo.base;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * * @description: 以后涉及数据库都存在的字段时候,
 * 可以把公共的属性放入进去,不要傻乎乎的都创建属性字段...（国赛的时候
 * 就傻乎乎的...）
 * * @author: Tonghuan
 * * @create: 2019/4/1
 **/
@Data
public abstract class BasePojo implements Serializable{

   private Date created;
   private Date updated;

}
