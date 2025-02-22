package com.example.test.controller;

import com.example.test.dto.CategoryDTO;
import com.example.test.dto.CategoryItemDTO;
import com.example.test.dto.CategoryListDTO;
import com.example.test.entity.Category;
import com.example.test.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// 新添加的注释
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public CategoryListDTO getCategoryList(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int pageSize) {
        return categoryService.getCategoryList(page, pageSize);
    }

    @PostMapping
    public String createCategory(@RequestBody CategoryDTO categoryDTO) {
        categoryService.createCategory(categoryDTO);
        return "Category created successfully";
    }

    @PutMapping("/{id}")
    public String updateCategory(@PathVariable Long id, @RequestBody CategoryDTO categoryDTO) {
        categoryService.updateCategory(id, categoryDTO);
        return "Category updated successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return "Category deleted successfully";
    }

    @GetMapping("/all")
    public List<CategoryItemDTO> getAllCategories() {
        return categoryService.getAllCategories();
    }

}
