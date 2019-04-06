package com.example.agamymaxb.pojo;

public class Category {

    private int id;
    private int categoryImage;
    private String categoryTitle;

    public Category(int categoryImage, String categoryTitle) {
        this.categoryImage = categoryImage;
        this.categoryTitle = categoryTitle;
    }

    public int getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(int categoryImage) {
        this.categoryImage = categoryImage;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
