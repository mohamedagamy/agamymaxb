package com.example.agamymaxb.ui.adapter.brand;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;

import com.example.agamymaxb.R;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

public class BrandsViewHolder extends RecyclerView.ViewHolder {

    AppCompatImageView ivBrands;
    Context mContext;
    public BrandsViewHolder(@NonNull View itemView) {
        super(itemView);
        ivBrands = itemView.findViewById(R.id.iv_brand_pic);
        mContext = itemView.getContext();
    }

    public void bind(int pos) {

        TypedArray imgs = mContext.getResources().obtainTypedArray(R.array.brands_images);
        //get resourceid by index
        int resID = imgs.getResourceId(pos, R.drawable.ic_launcher_background);
        ivBrands.setImageResource(resID);
    }
}
