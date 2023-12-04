package com.geesun.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.geesun.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {

}