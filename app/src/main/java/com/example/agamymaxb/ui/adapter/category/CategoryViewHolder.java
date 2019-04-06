package com.example.agamymaxb.ui.adapter.category;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import android.widget.Toast;

import com.example.agamymaxb.R;
import com.example.agamymaxb.pojo.Category;
import com.example.agamymaxb.ui.callbacks.OnItemClickHandler;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryViewHolder extends RecyclerView.ViewHolder{

    AppCompatImageView ivCategory;
    AppCompatTextView tvBrandTitle;
    Context mContext;

    public CategoryViewHolder(@NonNull View itemView) {
        super(itemView);

        mContext = itemView.getContext();
        ivCategory = itemView.findViewById(R.id.iv_category_pic);
        tvBrandTitle = itemView.findViewById(R.id.tv_category_title);
    }

    public void bind(Category category) {

        if(category  != null){
            ivCategory.setImageResource(category.getCategoryImage());
            tvBrandTitle.setText(category.getCategoryTitle());
        }
    }
}
