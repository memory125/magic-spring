package com.wing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author memory125
 */
@RestController
public class JdbcController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/users")
    public List<Map<String, Object>> userList() {
        String sql = "select * from wing.user";
        List<Map<String, Object>> usersList = jdbcTemplate.queryForList(sql);
        return  usersList;
    }

    @RequestMapping("/addUser/{id}")
    public String addUser(@PathVariable("id") int id) {
        String sql = "insert into wing.user(id,name,pwd) values(?,?,?)";

        // 封装
        Object[] objects = new Object[3];
        objects[0] = id;
        objects[1] = "Tiffany";
        objects[2] = "555666";

        int res = jdbcTemplate.update(sql, objects);
        if (res > 0) {
            return "addUser - OK";
        } else {
            return "addUser - failed!";
        }
    }

    @RequestMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") int id) {
        String sql = "update wing.user set name = ?,pwd = ? where id = " + id;

        // 封装
        Object[] objects = new Object[2];
        objects[0] = "Tiffany Franklin";
        objects[1] = "333222";

        int res = jdbcTemplate.update(sql, objects);
        if (res > 0) {
            return "updateUser - OK";
        } else {
            return "updateUser - failed!";
        }
    }

    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        String sql = "delete from wing.user where id = " + id;

        int res = jdbcTemplate.update(sql);
        if (res > 0) {
            return "updateUser - OK";
        } else {
            return "updateUser - failed!";
        }
    }
}
