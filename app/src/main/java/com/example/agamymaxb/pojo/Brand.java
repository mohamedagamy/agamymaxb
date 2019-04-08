package com.example.agamymaxb.pojo;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

public class Brand {

    private int id;
    private int image;

    public Brand(int image) {
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImage(int image) {
        this.image = image;
    }


    public List<Brand> createBrandsList(){
        List<Brand> brands = new ArrayList<>();
        for (int i = 0; i <200; i++) {
            brands.add(new Brand(image));
        }

        return brands;
    }


    public static DiffUtil.ItemCallback<Brand> DIFF_CALLBACK = new DiffUtil.ItemCallback<Brand>() {
        @Override
        public boolean areItemsTheSame(@NonNull Brand oldItem, @NonNull Brand newItem) {
            return oldItem.id == newItem.id;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Brand oldItem, @NonNull Brand newItem) {
            return oldItem.getImage() == (newItem.getImage());
        }
    };

}
