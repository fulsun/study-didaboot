package top.fulsun.controller;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.fulsun.entity.Category;
import top.fulsun.entity.TaskExample;
import top.fulsun.mapper.CategoryMapper;
import top.fulsun.mapper.TaskMapper;

import java.util.List;

/**
 * @program: springbootdemo
 * @description: 清单的控制层
 * @author: fulsun
 * @create: 2020-11-26 17:23
 **/
@Api(tags = "清单信息管理")
@RequestMapping("/category")
@RestController
public class CategoryController {
    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private TaskMapper taskMapper;


    @ApiOperation("查询所有的清单")
    @GetMapping("/getAllCategory")
    List<Category> getAllCategory() {
        List<Category> categories = categoryMapper.selectByExample(null);
        return categories;
    }

    @ApiOperation("添加一个清单分类")
    @PostMapping("/add")
    @ApiResponse(code = 1, message = "添加成功")
    @ApiImplicitParam(name = "category", required = true, paramType = "query")
    int addCategory(@ApiParam("添加的清单") @RequestBody Category category) {
        return categoryMapper.insertSelective(category);
    }

    @ApiOperation("根据id删除一个清单分类")
    @ApiImplicitParam(name = "id", value = "清单ID", required = true, paramType = "path")
    @DeleteMapping("/del/{id}")
    @ApiResponses({
     @ApiResponse(code = 0, message = "删除记录不存在"),
     @ApiResponse(code = 1, message = "删除成功"),
    })
    int deleteCategoryById(@PathVariable("id") int id) {
        // 删除分类下的所有任务
        TaskExample taskExample = new TaskExample();
        TaskExample.Criteria criteria = taskExample.createCriteria();
        criteria.andCategoryIdEqualTo(id);
        taskMapper.deleteByExample(taskExample);
        return categoryMapper.deleteByPrimaryKey(id);
    }

    @ApiOperation("更新清单")
    @PutMapping("/updateCategory")
    @ApiResponse(code = 1, message = "修改成功")
    @ApiImplicitParam(name = "category", value = "清单对象", required = true, paramType = "query")
    int updateCategory(@RequestBody Category category) {
        return categoryMapper.updateByPrimaryKeySelective(category);
    }
}
