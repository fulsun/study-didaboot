package top.fulsun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import top.fulsun.entity.Category;
import top.fulsun.entity.CategoryExample;
import top.fulsun.entity.Task;
import top.fulsun.entity.TaskExample;
import top.fulsun.mapper.CategoryMapper;
import top.fulsun.mapper.TaskMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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


    @GetMapping("/category/{cid}")
    public String getTaskByCategoryid(@PathVariable("cid") int id, Model model) {
        //默认是显示今天这个分类下的清单
        List<Task> taskListForToday = new ArrayList<>();
        TaskExample taskExample = new TaskExample();
        TaskExample.Criteria criteria = taskExample.createCriteria();
        if (id != 0) {
            criteria.andCategoryIdEqualTo(id);
            criteria.andRunEqualTo((byte) 0);
            taskListForToday = taskMapper.selectByExample(taskExample);
        } else {
            taskListForToday = null;
        }

        List<Category> categoryByIdOrName = getCategoryByIdOrName(id, null);
        Category category = categoryByIdOrName.get(0);
        model.addAttribute("currentCategory", category);
        model.addAttribute("taskList", taskListForToday);
        return "index";
    }

    @RequestMapping("/")
    public String index(Model model, HttpServletRequest request) {
        //得到所有的分类
        List<Category> categoryLists = getCategoryByIdOrName(null, null);
        HttpSession session = request.getSession();
        session.setAttribute("categoryLists", categoryLists);
        List<Category> todayLists = getCategoryByIdOrName(null, "今天");
        List<Integer> todayCategoryID = new ArrayList<>();
        for (Category category : todayLists) {
            todayCategoryID.add(category.getId());
        }

        //默认是显示今天这个分类下的清单
        List<Task> taskListForToday = new ArrayList<>();
        TaskExample taskExample = new TaskExample();
        TaskExample.Criteria criteria = taskExample.createCriteria();
        if (todayCategoryID.size() > 0) {
            criteria.andCategoryIdIn(todayCategoryID);
            criteria.andRunEqualTo((byte) 0);
            taskListForToday = taskMapper.selectByExample(taskExample);
        } else {
            taskListForToday = null;
        }

        Category category = todayLists.get(0);
        model.addAttribute("currentCategory", category);
        model.addAttribute("taskList", taskListForToday);
        return "index";
    }


    private List<Category> getCategoryByIdOrName(Integer id, String name) {
        List<Category> categoryLists = new ArrayList<>();
        CategoryExample categoryExample = new CategoryExample();
        CategoryExample.Criteria criteria = categoryExample.createCriteria();
        if (name != null && name != "") {
            criteria.andNameEqualTo(name);
        }
        if (id != null && id != 0) {
            criteria.andIdEqualTo(id);
        }
        categoryLists = categoryMapper.selectByExample(categoryExample);
        return categoryLists;
    }
}
