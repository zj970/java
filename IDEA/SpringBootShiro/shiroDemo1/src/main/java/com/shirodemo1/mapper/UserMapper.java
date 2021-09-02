package com.shirodemo1.mapper;
import com.shirodemo1.pojo.User;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {

    public User queryUserName(String name);
}
