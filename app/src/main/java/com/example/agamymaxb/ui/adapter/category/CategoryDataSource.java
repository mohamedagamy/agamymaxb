package com.example.agamymaxb.ui.adapter.category;

import android.content.Context;
import com.example.agamymaxb.pojo.Category;
import com.example.agamymaxb.utils.DummyData;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.paging.ItemKeyedDataSource;

import static com.example.agamymaxb.utils.Constants.MAX_NUM_PAGES;

public class CategoryDataSource extends ItemKeyedDataSource<Integer, Category> {
    Context mContext;

    public CategoryDataSource(Context context) {
        this.mContext = context;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Category> callback) {

        List<Category> items =
                fetchItems(0, params.requestedLoadSize);
        callback.onResult(items);
    }


    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Category> callback) {
        int nextKey = params.key + 1;
        if (nextKey < MAX_NUM_PAGES) {
            List<Category> items =
                    fetchItemsAfter(nextKey, params.requestedLoadSize);
            callback.onResult(items);
        }
    }


    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Category> callback) {
        int prevKey = params.key - 1;
        if (prevKey > 0) {
            List<Category> items =
                    fetchItemsBefore(prevKey, params.requestedLoadSize);
            callback.onResult(items);
        }
    }


    @NonNull
    @Override
    public Integer getKey(@NonNull Category item) {
        return item.getId();
    }

    private List<Category> fetchItems(Integer requestedInitialKey, int requestedLoadSize) {

        List<Category> categories = new DummyData(mContext).getCategories();
        return categories.subList(requestedInitialKey, requestedLoadSize);
    }

    private List<Category> fetchItemsAfter(Integer key, int requestedLoadSize) {
        List<Category> categories = new DummyData(mContext).getCategories();
        return categories.subList(key, key + requestedLoadSize);
    }

    private List<Category> fetchItemsBefore(Integer key, int requestedLoadSize) {
        List<Category> categories = new DummyData(mContext).getCategories();
        return categories.subList(key, requestedLoadSize);
    }

}
