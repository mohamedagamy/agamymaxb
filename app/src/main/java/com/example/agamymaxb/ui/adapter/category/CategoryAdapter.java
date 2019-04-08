package com.example.agamymaxb.ui.adapter.category;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.agamymaxb.R;
import com.example.agamymaxb.pojo.Category;
import com.example.agamymaxb.ui.interfaces.OnItemClickHandler;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;

public class CategoryAdapter extends PagedListAdapter<Category, CategoryViewHolder> {
    OnItemClickHandler onItemClickHandler;

    public CategoryAdapter() {
        super(Category.DIFF_CALLBACK);
    }

    public void setOnItemClickHandler(OnItemClickHandler onItemClickHandler) {
        this.onItemClickHandler = onItemClickHandler;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_categories, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        try {
            Category category = getItem(position);
            if (category != null)
                holder.bind(category);
        } catch (Exception e) {
        }

    }

}
