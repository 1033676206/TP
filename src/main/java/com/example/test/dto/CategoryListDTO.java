package com.example.test.dto;

import java.util.List;

public class CategoryListDTO {
    private int code;
    private int total;
    private List<CategoryItemDTO> list;

    // 构造函数
    public CategoryListDTO(int code, int total, List<CategoryItemDTO> list) {
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

    public List<CategoryItemDTO> getList() {
        return list;
    }

    public void setList(List<CategoryItemDTO> list) {
        this.list = list;
    }
}
