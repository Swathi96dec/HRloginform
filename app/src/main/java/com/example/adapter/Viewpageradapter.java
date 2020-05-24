package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;


public class Viewpageradapter extends PagerAdapter  {
    private int [] layouts;
    private LayoutInflater Layoutinflater;
    private Context context;

    public Viewpageradapter(int[] layouts,Context context) {
        this.layouts = layouts;
        this.context=context;
        Layoutinflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return layouts.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }


    @NonNull
    @Override
    public Object instantiateItem( @NonNull ViewGroup container, int position) {
        View view=Layoutinflater.inflate(layouts[position],container,false);
        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem( ViewGroup container, int position, @NonNull Object object) {
        View view=(View)object;
        container.removeView(view);
    }

}
