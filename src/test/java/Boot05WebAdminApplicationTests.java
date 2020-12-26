import com.springweb.MainApp;
import com.springweb.helloworld.User1;
import com.springweb.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest(classes = MainApp.class)
class Boot05WebAdminApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    @Autowired
    UserMapper userMapper;
    @Test
    void contextLoads(){
        Long count = jdbcTemplate.queryForObject("select count(1) from users_user", Long.class);
        log.info("获取到的数据数量是： " + count);
    }
    @Test
    void testUserMapper(){
        User1 user = userMapper.selectById(1L);
        log.info("用户信息" + user);
    }

}
