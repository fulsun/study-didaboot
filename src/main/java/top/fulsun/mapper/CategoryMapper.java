package top.fulsun.mapper;

import top.fulsun.entity.Category;

import java.util.List;

/**
 * @program: springbootdemo
 * @description: 清单的Mapper接口
 * @author: fulsun
 * @create: 2020-11-26 17:25
 **/
public interface CategoryMapper {
    /**
     * 查询所有的清单
     */
    List<Category> getAllCategory();

    /**
     * 添加一个清单分类
     * */
    void addCategory(Category category);

    /**
     * 根据id删除一个清单分类
     * */
    void deleteCategoryById(int id);

    /**
     * 对清单分类的名称进行修改
     * */
    void updateCategory(Category category);

}
