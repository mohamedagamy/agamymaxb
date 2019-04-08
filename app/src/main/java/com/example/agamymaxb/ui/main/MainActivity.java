package com.example.agamymaxb.ui.main;

import android.os.Bundle;

import com.example.agamymaxb.R;
import com.example.agamymaxb.ui.adapter.category.CategoryViewModel;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {
    CategoryViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViewPager();

        setUpViewModel();
    }

    private void setUpViewModel() {
        viewModel = ViewModelProviders.of(this).get(CategoryViewModel.class);
    }

    private void setupViewPager() {
        final ViewPager viewPager = findViewById(R.id.view_pager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);

        TabLayout tabLayout = findViewById(R.id.pager_tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }

    public CategoryViewModel getViewModel() {
        return viewModel;
    }
}
