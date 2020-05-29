package com.example.hrloginform;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    Button adduser, viewall,officelocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        adduser = findViewById(R.id.adduser);
        viewall = findViewById(R.id.ViewALL);
        officelocation=findViewById(R.id.officelocation);
        adduser.setOnClickListener(this);
        viewall.setOnClickListener(this);
        officelocation.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.adduser) {
            startActivity(new Intent(this,AdduserActivity.class));

        } else {
            if(v.getId()==R.id.ViewALL)
            {
                startActivity(new Intent(this,EmployeelistActivity.class));

            }
            else
            {
                if(v.getId()==R.id.officelocation)
                {
                    /*   to go to google map app in phone
                    Uri gmmIntentUri = Uri.parse("geo:17.3850,78.4867");


// Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
// Make the Intent explicit by setting the Google Maps package
                    mapIntent.setPackage("com.google.android.apps.maps");

                    if (mapIntent.resolveActivity(getPackageManager()) != null) {
                        startActivity(mapIntent);
                    }
                    */
                    startActivity(new Intent(this,MapsActivity.class));


// Attempt to start an activity that can handle the Intent

                }
            }


        }
    }
}