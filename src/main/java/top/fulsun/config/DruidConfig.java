package top.fulsun.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: springbootdemo
 * @description: Druid配置类
 * @author: fulsun
 * @create: 2020-11-28 22:25
 **/
@Configuration
public class DruidConfig {


    /**
     * 配置Druid的监控:
     *  提供监控信息展示的html页面
     *  提供监控信息的JSON API
     * @return
     */
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String,String> initParams = new HashMap<>();
        //账号
        initParams.put("loginUsername","admin");
        //密码
        initParams.put("loginPassword","123456");
        //登陆许可ip 不支持IPV6
        initParams.put("deny","172.19.162.111");
        initParams.put("allow","127.0.0.1");
        initParams.put("resetEnable","false");
        bean.setInitParameters(initParams);
        return bean;
    }
    //配置一个webURL监控的filter
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        Map<String,String> initParams = new HashMap<>();
        //忽略资源
        initParams.put("exclusions","*.js,*.gif,*.jpg, *.bmp, *.png,*.css,*.ico,/druid/*");
        bean.setInitParameters(initParams);
        bean.setUrlPatterns(Arrays.asList("/*"));
        return  bean;
    }

    // SQL防火墙过滤。控制系统内的SQL执行权限，禁止非法SQL行为
    @Bean
    public WallFilter wallFilter(){
        WallConfig wallConfig = new WallConfig();
        // 无条件清空表的检查
        wallConfig.setDeleteWhereNoneCheck(true);
        // 允许批量SQL操作
        wallConfig.setMultiStatementAllow(true);
        // 允许非基本语句的其他语句
        wallConfig.setNoneBaseStatementAllow(true);
        WallFilter wallFilter = new WallFilter();
        wallFilter.setConfig(wallConfig);
        return wallFilter;
    }


}
