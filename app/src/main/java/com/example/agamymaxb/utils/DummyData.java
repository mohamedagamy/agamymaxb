package com.example.agamymaxb.utils;

import android.content.Context;
import android.content.res.TypedArray;

import com.example.agamymaxb.R;
import com.example.agamymaxb.pojo.Category;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.agamymaxb.utils.Constants.MAX_NUM_PAGES;

public class DummyData {
    Context context;
    List<Integer> categoryImages;
    List<String> categoryTitles;
    List<Integer> brandsImages;

    public DummyData(Context context) {
        this.context = context;
        categoryTitles = getCategoryResources();
        categoryImages = getImagesResources();
        brandsImages = getBrandsImgResources();
        initCategoriesObjects();
    }

    private List<Integer> getBrandsImgResources() {
        brandsImages = new ArrayList<>();
        TypedArray imageTypedArray = context.getResources().obtainTypedArray(R.array.brands_images);

        for (int i = 0; i < imageTypedArray.length(); i++) {
            brandsImages.add(imageTypedArray.getResourceId(i, R.drawable.ic_launcher_background));

        }

        return brandsImages;


    }

    private List<Category> categories = new ArrayList<>();

    private List<Category> initCategoriesObjects() {
        categories = new ArrayList<>();

        for (int i = 0; i < MAX_NUM_PAGES; i++) {
            Category category = new Category(i, categoryImages.get(i % 25), categoryTitles.get(i % 25));
            categories.add(category);
        }
        return categories;
    }

    public List<Category> getCategories() {
        return categories;
    }

    private List<String> getCategoryResources() {
        return Arrays.asList(context.getResources().getStringArray(R.array.category_titles));
    }


    private List<Integer> getImagesResources() {
        categoryImages = new ArrayList<>();
        TypedArray imageTypedArray = context.getResources().obtainTypedArray(R.array.category_images);

        for (int i = 0; i < imageTypedArray.length(); i++) {
            categoryImages.add(imageTypedArray.getResourceId(i, R.drawable.ic_launcher_background));

        }

        return categoryImages;
    }

    public List<Integer> getCategoryImages() {
        return categoryImages;
    }

    public List<Integer> getBrandsImages() {
        return brandsImages;
    }
}
