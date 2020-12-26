package com.springweb.Service.imple;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springweb.Service.UserService;
import com.springweb.helloworld.User1;
import com.springweb.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User1> implements UserService {


}
