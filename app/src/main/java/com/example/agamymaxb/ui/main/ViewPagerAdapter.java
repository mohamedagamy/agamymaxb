package com.example.agamymaxb.ui.main;

import android.content.Context;

import com.example.agamymaxb.R;
import com.example.agamymaxb.ui.fragment.HomeFragment;
import com.example.agamymaxb.ui.fragment.OffersFragment;
import com.example.agamymaxb.ui.fragment.OrdersFragment;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    Context mContext;

    public ViewPagerAdapter(FragmentManager fm,Context context) {
        super(fm);
        this.mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new OffersFragment();
            case 2:
                return new OrdersFragment();
        }
        return null; //does not happen
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        switch (position) {
            case 0:
                return mContext.getString(R.string.home_screen);
            case 1:
                return mContext.getString(R.string.home_offers);
            case 2:
                return mContext.getString(R.string.home_orders);
        }

        return super.getPageTitle(position);
    }

    @Override
    public int getCount() {
        return 3;
    }
}
