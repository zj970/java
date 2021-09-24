package com.staffingsystem.pojo;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

//员工表
@Data
@NoArgsConstructor//自动生成无参构造
public class Employee {

    private Integer id;
    private String lastName;
    private String email;
    private Integer gendeer;//0:女 1：男
    private Department department;
    private Date birth;

    public Employee(Integer id, String lastName, String email, Integer gendeer, Department department) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gendeer = gendeer;
        this.department = department;
        this.birth = new Date();//默认创建日期
    }
}
