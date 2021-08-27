package com.springbootmybatis.mapper;

import com.springbootmybatis.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//这个注解表示了这是一个mybatis的mapper类 类：dao @Repository
@Mapper
@Repository
public interface UserMapper {
    //一个接口
    List<User> queryUserList();//查询所有用户

    User queryUserById(int id);//查询一个用户

    int addUser(User user);//增加一个用户

    int updateUser(User user);//更改用户

    int deleteUser(int id);//删除一个用户
}
