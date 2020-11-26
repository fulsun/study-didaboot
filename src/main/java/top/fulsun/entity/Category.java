package top.fulsun.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @program: springbootdemo
 * @description: 清单实体类
 * @author: fulsun
 * @create: 2020-11-26 11:23
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    private int id;
    private int userId;
    private String name; //清单名称
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private int run;
}
