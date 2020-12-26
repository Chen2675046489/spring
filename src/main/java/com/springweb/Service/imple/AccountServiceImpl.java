package com.springweb.Service.imple;

import com.springweb.Service.AccountService;
import com.springweb.helloworld.User;
import com.springweb.mapper.Account_user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    Account_user accountUser;
    public User Get_user(Long id){
        return accountUser.get_user(id);
    }
}
