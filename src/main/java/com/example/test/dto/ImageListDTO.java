package com.example.test.dto;

import java.util.List;

// 用于封装分页查询结果
public class ImageListDTO {
    private int code;
    private int total;
    private List<ImageItemDTO> list;

    // 构造函数
    public ImageListDTO(int code, int total, List<ImageItemDTO> list) {
        this.code = code;
        this.total = total;
        this.list = list;
    }

    // Getters and Setters
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<ImageItemDTO> getList() {
        return list;
    }

    public void setList(List<ImageItemDTO> list) {
        this.list = list;
    }
}
