package com.example.agamymaxb.ui.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.agamymaxb.R;
import com.example.agamymaxb.pojo.Category;
import com.example.agamymaxb.ui.adapter.brand.BrandsAdapter;
import com.example.agamymaxb.ui.adapter.brand.BrandsPagerAdapter;
import com.example.agamymaxb.ui.adapter.category.CategoryAdapter;
import com.example.agamymaxb.ui.interfaces.OnItemClickHandler;
import com.example.agamymaxb.ui.main.MainActivity;
import com.example.agamymaxb.utils.DummyData;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements OnItemClickHandler, View.OnClickListener {

    RecyclerView categoryRecyclerView;
    ViewPager brandsPager;
    BrandsAdapter brandsAdapter;
    CategoryAdapter categoryAdapter;
    BrandsPagerAdapter brandsPagerAdapter;
    AppCompatImageView fabNext,fabPrev;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        setUpViews(view);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        subscribe();
    }

    private void subscribe() {
        if(((MainActivity)getActivity()).getViewModel().getCategoryList() != null){
            ((MainActivity) getActivity()).getViewModel().getCategoryList().observe(getActivity(), new Observer<PagedList<Category>>() {
                @Override
                public void onChanged(PagedList<Category> categories) {
                    categoryAdapter.submitList(categories);
                }
            });
        }
    }

    private void setUpViews(View view) {
        brandsPager = view.findViewById(R.id.pager_brands);
        categoryRecyclerView = view.findViewById(R.id.recyclerview_categories);

        fabNext = view.findViewById(R.id.fab_next_image);
        fabPrev = view.findViewById(R.id.fab_previous_image);
        fabNext.setOnClickListener(this);
        fabPrev.setOnClickListener(this);

       // brandsRecyclerView.setItemAnimator(new DefaultItemAnimator());
         //brandsAdapter = new BrandsAdapter();
        //brandsRecyclerView.setAdapter(brandsAdapter);
        //brandsAdapter.setOnItemClickHandler(this);

        brandsPagerAdapter= new BrandsPagerAdapter(getContext(), new DummyData(getContext()).getBrandsImages());
        brandsPager.setAdapter(brandsPagerAdapter);


        categoryRecyclerView.setItemAnimator(new DefaultItemAnimator());
        categoryAdapter = new CategoryAdapter();
        categoryRecyclerView.setAdapter(categoryAdapter);
        categoryAdapter.setOnItemClickHandler(this);
    }

    @Override
    public void onItemClickHandler(String title) {
        Toast.makeText(getContext(), ""+title, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        int totalCount = brandsPagerAdapter.getCount(); //4
        int counterFlag=  brandsPager.getCurrentItem(); // 0
        switch (v.getId()){
            case R.id.fab_next_image: // 5
                counterFlag++;
                counterFlag = counterFlag >= totalCount ? counterFlag % totalCount : counterFlag;
                brandsPager.setCurrentItem(counterFlag);
                break;

            case R.id.fab_previous_image: // -1
                counterFlag--;
                counterFlag = counterFlag < 0 ? totalCount : counterFlag;
                brandsPager.setCurrentItem(counterFlag);
                break;


        }
    }


    //****************************************
}//End Class


