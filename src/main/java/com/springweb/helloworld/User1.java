package com.springweb.helloworld;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class User1 {
        private Long id;
        private String name;
        private Integer age;
        private String email;
}
