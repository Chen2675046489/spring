package com.springweb.Service.imple;


import com.springweb.helloworld.User;
import com.springweb.mapper.CityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceIpml {

    @Autowired
    CityUser cityUser;

    public User getCityUser(Long id) {
        return cityUser.getUser(id);
    }

}
