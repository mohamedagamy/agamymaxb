package com.example.agamymaxb.ui.adapter.category;

import com.example.agamymaxb.pojo.Category;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

public class CategoryViewModel extends ViewModel {
    private Executor executor;
    private LiveData<PagedList<Category>> categoryList;
    private DataSource<Integer,Category> mostRecentDataSource;

    public CategoryViewModel() {
        executor= Executors.newFixedThreadPool(1);
        CategoryDataSourceFactory dataSourceFactory = new CategoryDataSourceFactory();
        mostRecentDataSource = dataSourceFactory.create();

        PagedList.Config pagedListConfig =
                (new PagedList.Config.Builder())
                        .setEnablePlaceholders(false)
                        .setInitialLoadSizeHint(8)
                        .setPageSize(16).build();

        categoryList = new LivePagedListBuilder<>(dataSourceFactory, pagedListConfig)
                .setFetchExecutor(executor)
                .build();
    }

    public void invalidateDataSource() {
        mostRecentDataSource.invalidate();
    }

    public LiveData<PagedList<Category>> getCategoryList() {
        return categoryList;
    }
}