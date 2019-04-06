package com.example.agamymaxb.ui.adapter.category;

import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.agamymaxb.R;
import com.example.agamymaxb.pojo.Category;
import com.example.agamymaxb.ui.callbacks.OnItemClickHandler;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder>  {
    List<Category> mCategories;
    OnItemClickHandler onItemClickHandler;

    public void setOnItemClickHandler(OnItemClickHandler onItemClickHandler) {
        this.onItemClickHandler = onItemClickHandler;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_categories,parent,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        TypedArray imgs = holder.mContext.getResources().obtainTypedArray(R.array.category_images);
        TypedArray titles = holder.mContext.getResources().obtainTypedArray(R.array.category_titles);
        //get resourceid by index
        int resID = imgs.getResourceId(position, R.drawable.ic_launcher_background);
        final String resTitle = holder.mContext.getString(titles.getResourceId(position, -1));

        holder.bind(new Category(resID,resTitle));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickHandler.onItemClickHandler(resTitle);
            }
        });
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
