package com.example.agamymaxb.ui.adapter.category;

import android.app.Application;

import com.example.agamymaxb.pojo.Category;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

public class CategoryViewModel extends AndroidViewModel {
    private Executor executor;
    private LiveData<PagedList<Category>> categoryList;
    private DataSource<Integer, Category> mostRecentDataSource;

    public CategoryViewModel(@NonNull Application application) {
        super(application);
        executor = Executors.newFixedThreadPool(2);
        CategoryDataSourceFactory dataSourceFactory = new CategoryDataSourceFactory(application.getBaseContext());
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