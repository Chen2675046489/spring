package com.springweb.mapper;

import com.springweb.helloworld.User;
import org.apache.ibatis.annotations.Mapper;

//@Mapper
public interface Account_user {
     User get_user(Long id);
}
