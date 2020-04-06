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

import com.example.sqllite.Sqllitehelper;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Sqllitehelper db;
    EditText username;
    EditText password;
    Button register;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new Sqllitehelper(this);
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
        }
    }

    @Override
    public void onClick(View v) {
        boolean result;
        if (v.getId() == R.id.register) {
            db = new Sqllitehelper(this);
            result = db.adddata(username.getText().toString(), password.getText().toString());
            if (result) {
                Toast.makeText(this, "User registered succesfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
            }

            else
                Toast.makeText(this, "User  not registered", Toast.LENGTH_SHORT).show();

        }
    }
}
