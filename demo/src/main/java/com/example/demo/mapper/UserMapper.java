package com.example.demo.mapper;

import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


//这个注解表示了这是一个mybatis的mapper类 类：dao @Repository
@Mapper
@Repository
public interface UserMapper {
    int addUser(User user);//增加一个用户
}
