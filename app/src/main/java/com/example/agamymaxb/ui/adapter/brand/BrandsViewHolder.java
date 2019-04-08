package com.example.agamymaxb.ui.adapter.brand;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.example.agamymaxb.R;
import com.example.agamymaxb.pojo.Brand;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

public class BrandsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    AppCompatImageView ivBrands;
    Context mContext;

    public BrandsViewHolder(@NonNull View itemView) {
        super(itemView);
        ivBrands = itemView.findViewById(R.id.iv_brand_pic);
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void bind(Brand brand) {
        if (brand != null)
            ivBrands.setImageResource(brand.getImage());
    }

    @Override
    public void onClick(View v) {

        Toast.makeText(mContext, "" + ivBrands.getDrawable().toString(), Toast.LENGTH_SHORT).show();

    }
}
