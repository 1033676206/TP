package com.example.test.mapper;

import com.example.test.dto.ImageItemDTO;
import com.example.test.entity.Image;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ImageMapper {
//    @Insert("INSERT INTO images (name, description, file_path, upload_time,categoryName,region,publishTime) VALUES (#{name}, #{description}, #{filePath}, #{uploadTime},#{categoryName},#{region},#{publishTime})")
//    void insertImage(Image image);
//
//    @Select("SELECT * FROM images WHERE name = #{name}")
//    Image getImageByName(String name);
//
//    @Select("SELECT * FROM images")
//    List<Image> getAllImages();
//
//    @Delete("DELETE FROM images WHERE name = #{name}")
//    void deleteImage(String name);
//
//    @Select("SELECT COUNT(*) FROM images WHERE name = #{name}")
//    int countByName(@Param("name") String name);

    //List<ImageItemDTO> getImageList(int page, int pageSize, Long categoryId);
    // offset：分页的起始点。 pageSize：表示每页显示的记录数。 categoryId：表示影像所属的分类ID（可选参数）。
    @Select({
            "<script>",
            "SELECT * FROM images",
            "<where>",
            "<if test='categoryId != null'>",
            "category_id = #{categoryId}",
            "</if>",
            "</where>",
            "ORDER BY upload_time DESC",
            "LIMIT #{pageSize} OFFSET #{offset}",
            "</script>"
    })
    List<ImageItemDTO> getImageList(@Param("offset") int offset, @Param("pageSize") int pageSize,
                                    @Param("categoryId") Long categoryId);

    // 获取总记录数
    @Select({
            "<script>",
            "SELECT COUNT(*) FROM images",
            "<where>",
            "<if test='categoryId != null'>",
            "category_id = #{categoryId}",
            "</if>",
            "</where>",
            "</script>"
    })
    int getTotalImageCount(@Param("categoryId") Long categoryId);

    @Insert("INSERT INTO images (name, url, category_id, region, publish_time, upload_time) " +
            "VALUES (#{name}, #{url}, #{categoryId}, #{region}, #{publishTime}, NOW())")
    void insertImage(Image image);

    @Update({
            "<script>",
            "UPDATE images",
            "<set>",
            "  <if test='name != null'>name = #{name},</if>",
            "  <if test='url != null'>url = #{url},</if>",
            "  <if test='categoryId != null'>category_id = #{categoryId},</if>",
            "  <if test='region != null'>region = #{region},</if>",
            "  <if test='publishTime != null'>publish_time = #{publishTime}</if>",
            "</set>",
            "WHERE id = #{id}",
            "</script>"
    })
    int updateImageById(Image image);

    @Delete("DELETE FROM images WHERE id = #{id}")
    int deleteImageById(Long id);
}
