package com.example.hrloginform;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    Button adduser, viewall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        adduser = findViewById(R.id.adduser);
        viewall = findViewById(R.id.ViewALL);
        adduser.setOnClickListener(this);
        viewall.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.adduser) {
            startActivity(new Intent(this,AdduserActivity.class));

        } else {


        }
    }
}