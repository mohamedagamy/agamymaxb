package com.example.agamymaxb.ui.adapter.brand;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.agamymaxb.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BrandsAdapter extends RecyclerView.Adapter<BrandsViewHolder> {
    @NonNull
    @Override
    public BrandsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_brands,parent,false);
        return new BrandsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BrandsViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
