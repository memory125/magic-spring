package com.wing.dao;

import com.wing.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author memory125
 */
//注册到IOC容器中
@Repository
public class DepartmentDao {
    //模拟数据库中的数据
    private static Map<Integer, Department> departments = null;

    static {
        departments = new HashMap<>();//创建一个部门表
        departments.put(1001, new Department(1001, "技术部"));
        departments.put(1002, new Department(1002, "市场部"));
        departments.put(1003, new Department(1003, "调研部"));
        departments.put(1004, new Department(1004, "后勤部"));
        departments.put(1005, new Department(1005, "运营部"));
    }

    //获得部门的所有信息
    public Collection<Department> getDepartments() {
        return departments.values();
    }

    //通过id得到部门
    public Department getDepartmentById(int id) {
        return departments.get(id);
    }
}
