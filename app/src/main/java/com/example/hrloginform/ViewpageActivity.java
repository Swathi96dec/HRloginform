package com.example.hrloginform;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.adapter.Viewpageradapter;

public class ViewpageActivity extends AppCompatActivity implements View.OnClickListener {
   // private ViewPager viewpage;
    Button next;
    LinearLayout dotslayout;
    private ImageView[] dots;
    private int dotscount;
    private int[] layouts={R.layout.activity_page1,R.layout.activity_page2,R.layout.activity_page3,R.layout.activity_page4,R.layout.activity_page5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);
        ViewPager viewpage=findViewById(R.id.viewpager);
        next=findViewById(R.id.next);
        next.setOnClickListener(this);
        Viewpageradapter pageadapter=new Viewpageradapter(layouts,this);
        dotslayout=findViewById(R.id.dots);
        viewpage.setAdapter(pageadapter);
        dotscount=pageadapter.getCount();
        dots = new ImageView[dotscount];

        for(int i = 0; i < dotscount; i++){

            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.inactivedot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            dotslayout.addView(dots[i], params);

        }
        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.activedot));

        viewpage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for(int i = 0; i< dotscount; i++){
                    if(i==position) {
                        dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.activedot));
                    }
                            else
                    {
                        dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.inactivedot)) ;
                    }
                }

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
