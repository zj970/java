package com.staffingsystem.controller;

import com.staffingsystem.dao.DepartmentDao;
import com.staffingsystem.dao.EmployeeDao;
import com.staffingsystem.pojo.Department;
import com.staffingsystem.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Collection;

@Component
@Controller
public class EmployeeController {

    @Autowired //注入
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao department;
    //自定义路径
    @RequestMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();//获得所有员工信息
        //System.out.println("==---------"+employees);
        model.addAttribute("employees",employees);//返回给前端
        return "emp/list";//返回到这个页面
    }

    //去员工的增加页面
    @GetMapping("/toAdd")
    public String toAddpage(Model model){
        //查出所有部门的信息
        Collection<Department> departments = department.getDepartments();
        model.addAttribute("departmentName",departments);
        return "emp/add";
    }

    //传递员工的参数
    @PostMapping("/toAdd")
    public String addEmp(Employee employee){
        //post请求添加信息 forward
        System.out.println("==---------"+employee);
        employeeDao.Save(employee);//调用底层业务方法保存员工信息
        return "redirect:/emps";
    }

    //去员工的修改页面
    @GetMapping("/emp/{id}")
    public String toUpdateEmp(@PathVariable("id")Integer id, Model model){
        //查出原来的数据
        Employee employee = employeeDao.getEmployeeById(id);
        model.addAttribute("emp",employee);
        //部门信息
        Collection<Department> departments = department.getDepartments();
        model.addAttribute("departmentName",departments);

        return "emp/update";
    }

    //传递修改参数
    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee){
        employeeDao.Save(employee);
        return "redirect:/emps";
    }

    //删除员工
    @GetMapping("/delemp/{id}")
    public String deleteEmp(@PathVariable("id")Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
