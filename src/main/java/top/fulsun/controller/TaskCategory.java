package top.fulsun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import top.fulsun.entity.Task;
import top.fulsun.mapper.TaskMapper;

/**
 * @author fulsun
 * @title: TaskCategory
 * @projectName springbootdemo
 * @description: TODO
 * @date 2020/11/3014:03:18
 */
@Controller
@RequestMapping("/task")
public class TaskCategory {
    @Autowired
    TaskMapper taskMapper;

    @PostMapping("/updateTask")
    // public String updateTask(@RequestBody Task task){
    public String updateTask(Integer id, String name){
        Task task = new Task();
        task.setId(id);
        task.setName(name);
        taskMapper.updateByPrimaryKeySelective(task);
        //重定向到主页
        return "redirect:/index";
    }

}
