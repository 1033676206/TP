package com.example.test.mapper;

import com.example.test.dto.CategoryDTO;
import com.example.test.dto.CategoryItemDTO;
import com.example.test.entity.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoryMapper {

    @Select({
            "<script>",
            "SELECT id, code, name FROM categories",
            "ORDER BY id ASC",
            "LIMIT #{pageSize} OFFSET #{offset}",
            "</script>"
    })
    List<CategoryItemDTO> getCategoryList(@Param("offset") int offset, @Param("pageSize") int pageSize);

    @Select("SELECT COUNT(*) FROM categories")
    int getTotalCategoryCount();

    @Insert("INSERT INTO categories (code, name) VALUES (#{code}, #{name})")
    void insertCategory(Category category);

    @Update("UPDATE categories SET code=#{code}, name=#{name} WHERE id=#{id}")
    void updateCategory(Category category);

    @Delete("DELETE FROM categories WHERE id = #{id}")
    int deleteCategoryById(Long id);

    @Select("SELECT id,code ,name FROM categories ORDER BY name ASC")
    List<CategoryItemDTO> getAllCategories();

}
