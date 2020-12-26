package com.springweb.helloworld;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fengwenyi.api.result.CommonPage;
import com.fengwenyi.api.result.CommonResponse;
import com.springweb.Service.UserService;
import com.springweb.Service.imple.AccountServiceImpl;
import com.springweb.Service.imple.CityServiceIpml;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@Slf4j // 日志构造器
@RestController
public class HelloWorld {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/sql")
    public Long sql(){
        Long count = jdbcTemplate.queryForObject("select count(1) from users_user", Long.class);
        return count;
    }

    @Autowired
    CityServiceIpml cityServiceIpml;

    @ResponseBody
    @GetMapping("/city")
    public User cityUser(@RequestParam("id") Long id){
        return cityServiceIpml.getCityUser(id);
    }

    @Autowired
    AccountServiceImpl accountServiceImpl;
    @ResponseBody
    @GetMapping("/acc")
    public User account_use(@RequestParam("id") Long id){
       return accountServiceImpl.Get_user(id);
    }

    @RequestMapping("/hello")
    public String handle01()
    {
        log.info("请求进来了**********");
        return "hello client";
    }

//    @RequestMapping(value = "/user",method = RequestMethod.GET)
    @GetMapping("/user")
    public String getUser(){
        return "GET-张三";
    }

    @PostMapping("/user")
    public String saveUser(){
        return "POST-张三";
    }


//    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    @PutMapping("/user")
    public String putUser(){
        return "PUT-张三";
    }

//    @RequestMapping(value = "/user",method = RequestMethod.DELETE)
    @DeleteMapping("/user")
    public String deleteUser(){
        return "DELETE-张三";
    }


    @Autowired
    UserService userService;

    @ResponseBody
    @GetMapping("/dynamic_table")
    public CommonResponse dynamic_table(@RequestParam(value = "page", defaultValue = "1") Integer pn,
                                       @RequestParam(value = "size", defaultValue = "3") Integer Size){
        HashMap map = new HashMap();
        List<User1> list = userService.list();
        Page<User1> page =  new Page<>(pn, Size);
        // 分页查询的结果
        Page<User1> user1Page = userService.page(page, null);
        List<User1> user1List = user1Page.getRecords();

        Long pages = user1Page.getPages();
        Long total = user1Page.getTotal();
        Long pageSize = user1Page.getSize();
        map.put("user_list", user1List);
        map.put("pages", pages);
        map.put("total", total);
        map.put("pageSize", pageSize);

        return CommonResponse.ok(map);

    }

    @GetMapping("/delete/user")
    public String Delete_user(@RequestParam("id") Integer id){
        userService.removeById(id);
        return "删除成功";
    }

    @ResponseBody
    @PostMapping("/update/user")

    // public String Update_user(@RequestBody User1 user) 可以使用json格式床送
    public CommonResponse Update_user(@RequestParam("id") Long id,
                                      @RequestParam("name") String name, Model model) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id", id);
        User1 user1 = new User1();
        user1.setName(name);
        userService.update(user1, queryWrapper);
        String msg = "更新成功";
        model.addAttribute(msg);
        return CommonResponse.ok(msg);
    }

}
