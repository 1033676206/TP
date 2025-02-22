package com.example.test.controller;

import com.example.test.dto.ImageDTO;
import com.example.test.dto.ImageListDTO;
import com.example.test.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @GetMapping
    public ImageListDTO getImages(
            /*
                page 参数默认值为1。
                pageSize 参数默认值为10。
                categoryId 参数是可选的，没有默认值。
             */
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(required = false) Long categoryId) {
        return imageService.getImageList(page, pageSize, categoryId);
    }

    @PostMapping
    public String createImage(@RequestBody ImageDTO imageDTO) {
        imageService.createImage(imageDTO);
        return "Image created successfully";
    }

    @PutMapping("/{id}")
    public String updateImage(@PathVariable Long id, @RequestBody ImageDTO imageDTO) {
        imageService.updateImage(id, imageDTO);
        return "Image updated successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteImage(@PathVariable Long id) {
        imageService.deleteImage(id);
        return "Image deleted successfully";
    }

}