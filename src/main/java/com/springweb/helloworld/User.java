package com.springweb.helloworld;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class User {

    // 表明userName字段在表中不存在
    @TableField(exist = false)
    private String userName;

    private String age;
    private Integer id;
    private String name;
    private String avatar;
    private String gender;
    private Long phone;
}
