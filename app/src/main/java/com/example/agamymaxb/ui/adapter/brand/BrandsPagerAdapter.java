package com.example.agamymaxb.ui.adapter.brand;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.agamymaxb.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewpager.widget.PagerAdapter;

public class BrandsPagerAdapter extends PagerAdapter {
    private final Context mContext;
    private List<Integer> imageList;

    @Override
    public int getCount() {
        return imageList.size();
    }

    public BrandsPagerAdapter(Context ctx, List<Integer> images) {
        this.mContext = ctx;
        this.imageList = images;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.list_item_brands, null, false);
        AppCompatImageView brandImage = viewGroup.findViewById(R.id.iv_brand_pic);
        brandImage.setImageResource(imageList.get(position));
        container.addView(viewGroup);
        return viewGroup;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ViewGroup) object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
