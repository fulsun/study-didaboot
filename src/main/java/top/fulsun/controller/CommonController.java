package top.fulsun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import top.fulsun.entity.Category;
import top.fulsun.entity.CategoryExample;
import top.fulsun.entity.Task;
import top.fulsun.entity.TaskExample;
import top.fulsun.mapper.CategoryMapper;
import top.fulsun.mapper.TaskMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: springbootdemo
 * @description: 基本控制层
 * @author: fulsun
 * @create: 2020-11-29 19:57
 **/
@Controller
public class CommonController {
    @Autowired
    CategoryMapper categoryMapper;

    @Autowired
    TaskMapper taskMapper;

    @RequestMapping("/index")
    public String index(Model model) {
        //得到所有的分类
        List<Category> categoryLists = new ArrayList<>();
        CategoryExample categoryExample = new CategoryExample();
        categoryLists = categoryMapper.selectByExample(categoryExample);
        model.addAttribute("categoryLists", categoryLists);

        // 找到今天的分类
        CategoryExample.Criteria categoryCriteria = categoryExample.createCriteria();
        categoryCriteria.andNameEqualTo("今天");
        List<Category> categoryList2 = categoryMapper.selectByExample(categoryExample);
        List<Integer> todayCategoryID = new ArrayList<>();
        for (Category category : categoryList2) {
            todayCategoryID.add(category.getId());
        }

        //默认是显示今天这个分类下的清单
        List<Task> taskListForToday = new ArrayList<>();
        TaskExample taskExample = new TaskExample();
        TaskExample.Criteria criteria = taskExample.createCriteria();
        if (todayCategoryID.size()>0) {
            criteria.andCategoryIdIn(todayCategoryID);
            taskListForToday = taskMapper.selectByExample(taskExample);
        }else{
            taskListForToday = null;
        }
        model.addAttribute("taskList", taskListForToday);
        return "index";
    }
}
