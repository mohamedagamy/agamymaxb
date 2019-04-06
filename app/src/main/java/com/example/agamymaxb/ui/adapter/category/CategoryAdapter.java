package com.example.agamymaxb.ui.adapter.category;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.agamymaxb.R;
import com.example.agamymaxb.pojo.Category;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder>  {
    List<Category> mCategories;
    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_categories,parent,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return 25;
    }

    public List<Category> getmCategories() {
        return mCategories;
    }

    public void setmCategories(List<Category> mCategories) {
        this.mCategories = mCategories;
    }
}
