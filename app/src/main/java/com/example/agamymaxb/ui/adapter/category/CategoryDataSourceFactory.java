package com.example.agamymaxb.ui.adapter.category;

import com.example.agamymaxb.pojo.Category;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

public class CategoryDataSourceFactory  extends DataSource.Factory<Integer, Category> {
    private MutableLiveData<CategoryDataSource> sourceLiveData =
            new MutableLiveData<>();

    private CategoryDataSource latestSource;

    @Override
    public DataSource<Integer, Category> create() {
        latestSource = new CategoryDataSource();
        sourceLiveData.postValue(latestSource);
        return latestSource;
    }
}
