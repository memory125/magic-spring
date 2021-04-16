package com.wing.controller;

import com.wing.dao.DepartmentDao;
import com.wing.dao.EmployeeDao;
import com.wing.pojo.Department;
import com.wing.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

/**
 * @author memory125
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emps/list";       //返回到list页面
    }

    @GetMapping("/add")
    public String toAddEmployee(Model model) {
        //查出所有的部门信息,添加到departments中,用于前端接收
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        return "emps/add";//返回到添加员工页面
    }

    @PostMapping("/emp")
    public String addEmployee(Employee employee) {
        //添加一个员工
        employeeDao.addsave(employee);//调用底层业务方法保存员工信息
        return "redirect:/emps";//重定向到/emps,刷新列表,返回到list页面
    }

    @RequestMapping("/emp/{id}")
    public String toUpdateEmployee(@PathVariable("id") int id, Model model) {
        //查询员工信息
        Employee employee = employeeDao.getEmployeeByID(id);
        model.addAttribute("emp", employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        return "emps/update";
    }

    @PostMapping("/updateEmp")
    public String updateEmployee(Employee employee) {
        //添加一个员工
        employeeDao.addsave(employee);//调用底层业务方法保存员工信息
        return "redirect:/emps";//重定向到/emps,刷新列表,返回到list页面
    }

    @RequestMapping("/delemp/{id}")
    public String deleteEmployee(@PathVariable("id") int id, Model model) {
        // 删除员工
        employeeDao.deleteEmployeeByID(id);
        model.addAttribute("msg", "删除用户" + id + "成功");
        return "redirect:/emps";//重定向到/emps,刷新列表,返回到list页面
    }

}
