package com.example.hrloginform;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.adapter.Viewpageradapter;

public class ViewpageActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewPager viewpage;
    Button next;
    private int[] layouts={R.layout.activity_page1,R.layout.activity_page2,R.layout.activity_page3,R.layout.activity_page4,R.layout.activity_page5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);
        viewpage=findViewById(R.id.viewpager);
        next=findViewById(R.id.next);
        next.setOnClickListener(this);
        Viewpageradapter pageadapter=new Viewpageradapter(layouts,this);
        viewpage.setAdapter(pageadapter);
        viewpage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position==layouts.length-1)
                {
                    next.setVisibility(View.VISIBLE);
                }
                else
                {
                    next.setVisibility(View.INVISIBLE);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    public void sethomepage()
    {
        Intent intent =new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.next)
        {
            sethomepage();
        }

    }
}
