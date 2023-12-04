package com.geesun.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.geesun.pojo.User;

public interface UserService extends IService<User> {


    //int deleteByIds(Long[] ids);

    //int addUser(User user);

    User findByUsername(User user);

    User findUserById(String userId);
}
