package com.example.agamymaxb.pojo;



import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

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
