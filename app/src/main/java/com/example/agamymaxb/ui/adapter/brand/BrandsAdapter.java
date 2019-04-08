package com.example.agamymaxb.ui.adapter.brand;

import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.agamymaxb.R;
import com.example.agamymaxb.pojo.Brand;
import com.example.agamymaxb.ui.interfaces.OnItemClickHandler;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BrandsAdapter extends RecyclerView.Adapter<BrandsViewHolder> {

    OnItemClickHandler onItemClickHandler;

    public void setOnItemClickHandler(OnItemClickHandler onItemClickHandler) {
        this.onItemClickHandler = onItemClickHandler;
    }

    @NonNull
    @Override
    public BrandsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_brands, parent, false);
        return new BrandsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BrandsViewHolder holder, final int position) {
        TypedArray imgs = holder.mContext.getResources().obtainTypedArray(R.array.brands_images);
        int resID = imgs.getResourceId(position, R.drawable.ic_launcher_background);
        holder.bind(new Brand(resID));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickHandler.onItemClickHandler("img. " + position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
