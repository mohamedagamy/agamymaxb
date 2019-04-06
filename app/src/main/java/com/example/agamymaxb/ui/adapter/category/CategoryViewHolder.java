package com.example.agamymaxb.ui.adapter.category;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;

import com.example.agamymaxb.R;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryViewHolder extends RecyclerView.ViewHolder {

    AppCompatImageView ivCategory;
    AppCompatTextView tvBrandTitle;
    Context mContext;

    public CategoryViewHolder(@NonNull View itemView) {
        super(itemView);

        mContext = itemView.getContext();
        ivCategory = itemView.findViewById(R.id.iv_category_pic);
        tvBrandTitle = itemView.findViewById(R.id.tv_category_title);
    }

    public void bind(int category) {

        TypedArray imgs = mContext.getResources().obtainTypedArray(R.array.category_images);
        TypedArray titles = mContext.getResources().obtainTypedArray(R.array.category_titles);
        //get resourceid by index
        int resID = imgs.getResourceId(getAdapterPosition(), R.drawable.ic_launcher_background);
        int resTitle = titles.getResourceId(getAdapterPosition(), -1);
        ivCategory.setImageResource(resID);

        if(resTitle  != -1)
            tvBrandTitle.setText(""+mContext.getString(resTitle));
    }

}
