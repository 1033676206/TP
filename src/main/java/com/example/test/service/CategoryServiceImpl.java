package com.example.test.service;

import com.example.test.dto.CategoryDTO;
import com.example.test.dto.CategoryItemDTO;
import com.example.test.dto.CategoryListDTO;
import com.example.test.entity.Category;
import com.example.test.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public CategoryListDTO getCategoryList(int page, int pageSize) {
        int offset = (page - 1) * pageSize;
        List<CategoryItemDTO> list = categoryMapper.getCategoryList(offset, pageSize);
        int total = categoryMapper.getTotalCategoryCount();
        return new CategoryListDTO(0, total, list); // 假设0表示成功
    }

    @Override
    public int getTotalCategoryCount() {
        return categoryMapper.getTotalCategoryCount();
    }

    @Override
    public void createCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setCode(categoryDTO.getCode());
        category.setName(categoryDTO.getName());
        categoryMapper.insertCategory(category);
    }

    @Override
    public void updateCategory(Long id, CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setCode(categoryDTO.getCode());
        category.setName(categoryDTO.getName());

        category.setId(id);
        categoryMapper.updateCategory(category);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryMapper.deleteCategoryById(id);
    }

    @Override
    public List<CategoryItemDTO> getAllCategories() {
        return categoryMapper.getAllCategories();
    }
}
