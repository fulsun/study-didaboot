package top.fulsun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.fulsun.entity.Task;
import top.fulsun.mapper.TaskMapper;

import java.util.HashMap;

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

    @ResponseBody
    @DeleteMapping("/del/{id}")
    public HashMap<String, Object> delTaskById(@PathVariable("id") int id){
        // int i = taskMapper.deleteByPrimaryKey(id);
        Task record = new Task();
        record.setId(id);
        record.setRun((byte) 1);
        int i = taskMapper.updateByPrimaryKeySelective(record);
        String res= i != 0 ? "删除成功" : "删除失败";
        HashMap<String, Object> map = new HashMap<>();
        map.put("data", res);
        return map;
    }

}
