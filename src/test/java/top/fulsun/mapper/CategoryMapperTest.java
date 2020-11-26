package top.fulsun.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.fulsun.entity.Category;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class CategoryMapperTest {
    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    void getAllCategory(){
        List<Category> allCategory = categoryMapper.getAllCategory();
        allCategory.stream().forEach(System.out::println);
    }

    @Test
    void addCategory() {
        Category category = new Category();
        category.setId(2);
        category.setName("Java学习");
        category.setCreateTime(LocalDateTime.now());
        categoryMapper.addCategory(category);
    }

    @Test
    void deleteCategoryById() {
        categoryMapper.deleteCategoryById(2);
    }

    @Test
    void updateCategory() {
        Category category = new Category();
        category.setId(2);
        category.setName("SpringBoot学习");
        category.setUpdateTime(LocalDateTime.now());
        categoryMapper.updateCategory(category);
    }
}