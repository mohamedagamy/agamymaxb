package com.example.agamymaxb.ui.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.agamymaxb.R;
import com.example.agamymaxb.ui.adapter.brand.BrandsAdapter;
import com.example.agamymaxb.ui.adapter.category.CategoryAdapter;
import com.example.agamymaxb.ui.callbacks.OnItemClickHandler;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements OnItemClickHandler {

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
        BrandsAdapter brandsAdapter = new BrandsAdapter();
        brandsRecyclerView.setAdapter(brandsAdapter);
        brandsAdapter.setOnItemClickHandler(this);


        categoryRecyclerView.setItemAnimator(new DefaultItemAnimator());
        CategoryAdapter categoryAdapter = new CategoryAdapter();
        categoryRecyclerView.setAdapter(categoryAdapter);
        categoryAdapter.setOnItemClickHandler(this);

        return view;
    }

    private void paginateItems(){
        Toast.makeText(getContext(), "Loading ....", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClickHandler(String title) {
        Toast.makeText(getContext(), ""+title, Toast.LENGTH_SHORT).show();
    }


    //****************************************
}//End Class


