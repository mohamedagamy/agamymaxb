package com.example.agamymaxb.ui.adapter.category;
import android.content.Context;

import com.example.agamymaxb.pojo.Category;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

public class CategoryDataSourceFactory extends DataSource.Factory<Integer, Category> {
    private MutableLiveData<CategoryDataSource> sourceLiveData = new MutableLiveData<>();

    private CategoryDataSource latestSource;
    private Context mContext;

    public CategoryDataSourceFactory(Context context) {
        this.mContext = context;
    }

    @Override
    public DataSource<Integer, Category> create() {
        latestSource = new CategoryDataSource(mContext);
        sourceLiveData.postValue(latestSource);
        return latestSource;
    }
}
