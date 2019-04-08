package com.example.agamymaxb.pojo;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class Category {

    private int id;
    private int categoryImage;
    private String categoryTitle;

    public Category(int id, int categoryImage, String categoryTitle) {
        this.id = id;
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


    public static DiffUtil.ItemCallback<Category> DIFF_CALLBACK = new DiffUtil.ItemCallback<Category>() {
        @Override
        public boolean areItemsTheSame(@NonNull Category oldItem, @NonNull Category newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Category oldItem, @NonNull Category newItem) {
            return oldItem.getCategoryTitle().equals(newItem.getCategoryTitle()) &&
                    oldItem.getCategoryImage() == (newItem.getCategoryImage());
        }
    };

}
