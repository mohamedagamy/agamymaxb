package com.example.agamymaxb.ui.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ames.uncover.UncoveringDataModel;
import com.ames.uncover.primary.PrimaryDataProvider;
import com.ames.uncover.primary.PrimaryRequest;
import com.ames.uncover.primary.PrimaryResponse;
import com.ames.uncover.primary.Query;
import com.example.agamymaxb.R;
import com.example.agamymaxb.pojo.Category;
import com.example.agamymaxb.ui.adapter.brand.BrandsAdapter;
import com.example.agamymaxb.ui.adapter.category.CategoryAdapter;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    RecyclerView brandsRecyclerView,categoryRecyclerView;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        brandsRecyclerView = view.findViewById(R.id.recyclerview_brands);
        categoryRecyclerView = view.findViewById(R.id.recyclerview_categories);

        brandsRecyclerView.setItemAnimator(new DefaultItemAnimator());
        brandsRecyclerView.setAdapter(new BrandsAdapter());


        categoryRecyclerView.setItemAnimator(new DefaultItemAnimator());
        categoryRecyclerView.setAdapter(new CategoryAdapter());

        return view;
    }

    private void paginateItems(){
        Toast.makeText(getContext(), "Loading ....", Toast.LENGTH_SHORT).show();
    }


 //****************************************
}//End Class


