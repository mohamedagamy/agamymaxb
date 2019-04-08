package com.example.agamymaxb.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.example.agamymaxb.R;
import androidx.viewpager.widget.ViewPager;

public class CustomViewPager extends ViewPager {
    private boolean swipeable;

    public CustomViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomViewPager);
        try {
            swipeable = a.getBoolean(R.styleable.CustomViewPager_swipeable, true);
        } finally {
            a.recycle();
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return swipeable && super.onInterceptTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return swipeable && super.onInterceptTouchEvent(event);
    }
}
