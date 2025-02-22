package com.example.test.entity;

import java.util.Date;

public class Image {
    private Long id;
    private String name;
    private String description;
    private String filePath;
    private String categoryName;
    private String region;
    private String publishTime;
    private Date uploadTime;

    private String url;
    private Long categoryId;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getRegion() {
        return region;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getPublishTime() {
        return publishTime;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getCategoryName() {
        return categoryName;
    }

}
