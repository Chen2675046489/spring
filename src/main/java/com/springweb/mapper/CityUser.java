package com.springweb.mapper;

import com.springweb.helloworld.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

//@Mapper
public interface CityUser {

    @Select("select * from users_user where id = #{id}")
    User getUser(Long id);
}
