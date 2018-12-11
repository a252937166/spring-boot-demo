package com.ouyanglol.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ouyanglol.demo.dao.UserDAO;
import com.ouyanglol.demo.model.User;
import com.ouyanglol.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;


/**
 * @author Ouyang
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public PageInfo<User> all() {
        //开始分页，查询第1页，每页3条数据
        PageHelper.startPage(1,3);
        return new PageInfo<>(userDAO.selectAll());
    }

    @Override
    public User selectById(String id) {
        //首次查询redis数据库有无缓存，没有就从数据库查，并把查到的数据放入redis缓存
        if (redisTemplate.opsForValue().get(id)==null) {
            User user = userDAO.selectByPrimaryKey(id);
            redisTemplate.opsForValue().set(id,user);
            return user;
        }
        return (User)redisTemplate.opsForValue().get(id);
    }

    @Override
    @Cacheable(value = "user",key = "#id")
    public User selectByIdV2(String id) {
        return userDAO.selectByPrimaryKey(id);
    }
}
