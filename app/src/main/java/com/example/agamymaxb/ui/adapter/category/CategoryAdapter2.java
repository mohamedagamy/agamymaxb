package com.example.agamymaxb.ui.adapter.category;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.agamymaxb.R;
import com.example.agamymaxb.pojo.Category;
import com.example.agamymaxb.ui.interfaces.OnItemClickHandler;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryAdapter2 extends RecyclerView.Adapter<CategoryViewHolder> {
    OnItemClickHandler onItemClickHandler;
    List<Category> categories;
    public void setOnItemClickHandler(OnItemClickHandler onItemClickHandler) {
        this.onItemClickHandler = onItemClickHandler;
    }

    public CategoryAdapter2(List<Category> categories) {
        this.categories = categories;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_categories,parent,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        try {
            Category category = categories.get(position);
            if(category != null)
                holder.bind(category);
        }catch (Exception e){}

    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

}
