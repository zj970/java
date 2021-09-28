package com.b2cdemo.mapper;

import com.b2cdemo.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AdminMapper {
    //一个接口
    List<Admin> queryAdminList();//查询所有用户

    Admin queryAdminById(int id);//查询一个用户

    int addAdmin(Admin admin);//增加一个用户

    int updateAdmin(Admin user);//更改用户

    int deleteAdmin(int id);//删除一个用户


}
