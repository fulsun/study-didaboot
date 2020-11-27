package top.fulsun.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.fulsun.entity.Category;
import top.fulsun.entity.CategoryExample;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class CategoryMapperTest {
    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    void selectByPrimaryKey(){
        Category category = categoryMapper.selectByPrimaryKey(1);
        System.out.println(category);
    }

    @Test
    void selectByExample(){
        CategoryExample example = new CategoryExample();
        example.setDistinct(true);
        example.setOrderByClause("id DESC");
        CategoryExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo("今天");
        // select distinct id, user_id, name, create_time, update_time, run
        // from category WHERE ( name = ? ) order by id DESC
        List<Category> categories = categoryMapper.selectByExample(example);
        System.out.println(categories);
    }

    @Test
    void addCategory() {
        Category category = new Category();
        category.setId(2);
        category.setName("Java学习");
        category.setCreateTime(LocalDateTime.now());
        categoryMapper.insert(category);
        List<Category> categories = categoryMapper.selectByExample(null);
        categories.stream().forEach(System.out::println);
    }

    @Test
    void deleteCategoryById() {
        int i = categoryMapper.deleteByPrimaryKey(2);
        if(i!=0){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }
    }

    @Test
    void updateCategory() {
        Category category = new Category();
        category.setId(2);
        category.setUserId(1);
        category.setName("SpringBoot学习");
        category.setUpdateTime(LocalDateTime.now());
        // 更新想更新的字段
        // update category SET user_id = ?, name = ?, update_time = ? where id = ?
        categoryMapper.updateByPrimaryKeySelective(category);
    }
}