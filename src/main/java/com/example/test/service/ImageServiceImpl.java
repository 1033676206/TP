package com.example.test.service;

import com.example.test.dto.ImageDTO;
import com.example.test.dto.ImageListDTO;
import com.example.test.dto.ImageItemDTO;
import com.example.test.entity.Image;
import com.example.test.mapper.ImageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageMapper imageMapper;

    @Override
    public ImageListDTO getImageList(int page, int pageSize, Long categoryId) {
        // 计算 offset
        int offset = (page - 1) * pageSize;

        // 获取影像列表
        List<ImageItemDTO> list = imageMapper.getImageList(offset, pageSize, categoryId);

        // 获取总记录数
        int total = imageMapper.getTotalImageCount(categoryId);

        // 返回结果
        return new ImageListDTO(0, total, list);
    }

    @Override
    public void createImage(ImageDTO imageDTO) {
        Image image = new Image();
        image.setName(imageDTO.getName());
        image.setUrl(imageDTO.getUrl());
        image.setCategoryId(imageDTO.getCategoryId());
        image.setRegion(imageDTO.getRegion());
        image.setPublishTime(imageDTO.getPublishTime());
        image.setUploadTime(new java.util.Date()); // 设置当前时间
        imageMapper.insertImage(image);
    }

    @Override
    public void updateImage(Long id, ImageDTO imageDTO) {
        Image image = new Image();
        image.setId(id);
        image.setName(imageDTO.getName());
        image.setUrl(imageDTO.getUrl());
        image.setCategoryId(imageDTO.getCategoryId());
        image.setRegion(imageDTO.getRegion());
        image.setPublishTime(imageDTO.getPublishTime());
        imageMapper.updateImageById(image);
    }

    @Override
    public void deleteImage(Long id) {
        imageMapper.deleteImageById(id);
    }


}
