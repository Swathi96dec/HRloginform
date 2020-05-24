package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.viewpager.widget.PagerAdapter;

import com.example.hrloginform.R;
import com.example.hrloginform.ViewpageActivity;


public class Viewpageradapter extends PagerAdapter implements View.OnClickListener {
    private int [] layouts;
    private LayoutInflater Layoutinflater;
    private Context context;
    ViewpageActivity page;

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
    public boolean isViewFromObject(View view,  Object object) {
        return view==object;
    }


    @Override
    public Object instantiateItem( ViewGroup container, int position) {
        View view=Layoutinflater.inflate(layouts[position],container,false);
        container.addView(view);
        Button nextbutton = view.findViewById(R.id.next);

        return view;
    }

    @Override
    public void destroyItem( ViewGroup container, int position, Object object) {
        View view=(View)object;
        container.removeView(view);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.next)
        {
           page.sethomepage();
        }

    }
}
