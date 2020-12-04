package top.fulsun.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.fulsun.common.api.Result;
import top.fulsun.common.exception.DefinitionException;

/**
 * @author fulsun
 * @title: Test
 * @projectName springbootdemo
 * @description: 测试全局捕获异常
 * @date 2020/12/314:24:45
 */
@RestController
public class Test {
    //自定义异常处理
    @RequestMapping("/getDeException")
    public Result<Object> DeException() {
        throw new DefinitionException(400, "我出错了");
    }

    //其他异常处理
    @RequestMapping("/getException")
    public Result Exception(){
        Result result = new Result();
        int a=1/0;
        return result;
    }
}

