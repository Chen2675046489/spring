package com.springweb.helloworld;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

@Deprecated
@Configuration
public class MyDataSourceConfig {

    /**
     * ConfigurationProperties 会与配置文件中的spring.datasource数据进行绑定
     * 默认的自动配饰是判断容器中哦没有才会配置
     */
//    @ConfigurationProperties("spring.datasource")
//    @Bean  如果要使用配置文件的话，需要先将自己写的方法注释掉，默认先使用自己写的，最后才是默认的
    public DataSource dataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setFilters("stat");
        return druidDataSource;
    }

    /**
     * 配置监控页功能
     */
//    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        return servletRegistrationBean;
    }
}
