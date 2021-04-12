package com.wing.dao;

import com.wing.pojo.Department;
import com.wing.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author memory125
 */
//注册到IOC容器中
@Repository
public class EmployeeDao {

    //模拟数据库中员工表的数据
    static private Map<Integer, Employee> employees;

    //员工所属的部门
    @Autowired//自动注入
    private DepartmentDao departmentDao;

    static {
        employees = new HashMap<>();//创建一个员工表
        employees.put(1001, new Employee(1001, "zsr", "1234@qq.com", 0, new Department(1001, "技术部")));
        employees.put(1002, new Employee(1002, "lyr", "1345@qq.com", 1, new Department(1002, "市场部")));
        employees.put(1003, new Employee(1003, "gcc", "5665@qq.com", 0, new Department(1003, "调研部")));
        employees.put(1004, new Employee(1004, "zyx", "7688@qq.com", 1, new Department(1004, "后勤部")));
        employees.put(1005, new Employee(1005, "zch", "8089@qq.com", 1, new Department(1005, "运营部")));
    }

    //主键自增
    private static Integer initialID = 1006;

    //增加一个员工
    public void addsave(Employee employee) {
        if (employee.getId() == null)
            employee.setId(initialID);
        //部门关联外键
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);
    }

    //查询全部员工信息
    public Collection<Employee> getAll() {
        return employees.values();
    }

    //通过id查询员工
    public Employee getEmployeeByID(Integer id) {
        return employees.get(id);
    }

    //通过id删除员工
    public void deleteEmployeeByID(int id) {
        employees.remove(id);
    }
}

