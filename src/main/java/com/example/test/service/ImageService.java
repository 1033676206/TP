package com.example.test.service;

import com.example.test.dto.ImageDTO;
import com.example.test.dto.ImageListDTO;

public interface ImageService {

    ImageListDTO getImageList(int page, int pageSize, Long categoryId);

    void createImage(ImageDTO imageDTO);

    void updateImage(Long id, ImageDTO imageDTO);

    void deleteImage(Long id);

}
