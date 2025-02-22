package com.example.test.service;

import com.example.test.dto.CategoryDTO;
import com.example.test.dto.CategoryItemDTO;
import com.example.test.dto.CategoryListDTO;
import com.example.test.entity.Category;

import java.util.List;

public interface CategoryService {

    CategoryListDTO getCategoryList(int page, int pageSize);

    int getTotalCategoryCount();

    void createCategory(CategoryDTO categoryDTO);

    void updateCategory(Long id, CategoryDTO categoryDTO);

    void deleteCategory(Long id);

    List<CategoryItemDTO> getAllCategories();
}
