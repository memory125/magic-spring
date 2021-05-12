package com.wing.service.impl;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.wing.pojo.User;
import com.wing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 创建对象
     *
     * @param user
     */
    @Override
    public User saveUser(User user) {
        return mongoTemplate.save(user);
    }

    /**
     * 根据用户名查询对象
     *
     * @param name
     * @return
     */
    @Override
    public User queryUserByName(String name) {
        Query query=new Query(Criteria.where("name").is(name));
        User user =  mongoTemplate.findOne(query , User.class);
        return user;
    }

    /**
     * 更新对象
     *
     * @param user
     */
    @Override
    public void updateUser(User user) {
        Query query=new Query(Criteria.where("id").is(user.getId()));
        Update update= new Update().set("age", user.getAge()).set("name", user.getName());
        //更新查询返回结果集的第一条
        UpdateResult result = mongoTemplate.updateFirst(query, update, User.class);
        System.out.println(result);
        //更新查询返回结果集的所有
        // mongoTemplate.updateMulti(query,update,TestEntity.class);
    }

    /**
     * 删除对象
     *
     * @param id
     */
    @Override
    public void deleteUserById(int id) {
        Query query=new Query(Criteria.where("id").is(id));
        DeleteResult remove = mongoTemplate.remove(query, User.class);
        System.out.println(remove);
    }
}
