package com.example.hrloginform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.Interfaces.Ipresenter;
import com.example.Interfaces.Iview;
import com.example.Presenter.Presenter;



public class MainActivity extends AppCompatActivity implements Iview, View.OnClickListener {

    EditText username;
    EditText password;
    Button register;
    TextView text;
    Ipresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new Presenter(this);
        presenter.getdatafromsqllite();
       /* db = new Sqllitehelper(this);
        Cursor data = db.getdata();

       if (data.getCount() == 0) {
            setContentView(R.layout.activity_main);
            username = findViewById(R.id.username);
            password = findViewById(R.id.password);
            register =findViewById(R.id.register);
            text= this.findViewById(R.id.heading);
            register.setOnClickListener(this);

        } else {
            Intent intent =new Intent(this,LoginActivity.class);
            startActivity(intent);
        }*/
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.register) {
            presenter.adduser(username.getText().toString(), password.getText().toString());
          /*  db = new Sqllitehelper(this);
            result = db.adddata(username.getText().toString(), password.getText().toString());
            if (result) {
                Toast.makeText(this, "User registered succesfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
            }

            else
                Toast.makeText(this, "User  not registered", Toast.LENGTH_SHORT).show();*/

        }
    }

    @Override
    public void ongetdataresponse(Cursor data) {
        if (data.getCount() == 0) {
            setContentView(R.layout.activity_main);
            username = findViewById(R.id.username);
            password = findViewById(R.id.password);
            register =findViewById(R.id.register);
            text= this.findViewById(R.id.heading);
            register.setOnClickListener(this);

        } else {
            Intent intent =new Intent(this,LoginActivity.class);
            startActivity(intent);
        }


    }

    @Override
    public void onadduserresponse(boolean result) {
        if (result) {
            Toast.makeText(this, "User registered succesfully", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }

        else
            Toast.makeText(this, "User  not registered", Toast.LENGTH_SHORT).show();

    }
}
