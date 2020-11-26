package top.fulsun;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: springbootdemo
 * @description: 项目的启动类
 * @author: fulsun
 * @create: 2020-11-23 16:04
 **/
@SpringBootApplication
@MapperScan(basePackages = "top.fulsun.mapper")
public class SpringbootDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoApplication.class, args);
    }
}
