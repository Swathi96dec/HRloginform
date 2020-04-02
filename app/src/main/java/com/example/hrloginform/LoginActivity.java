package com.example.hrloginform;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sqllite.Sqllitehelper;

public class LoginActivity  extends AppCompatActivity implements View.OnClickListener {
    EditText username, password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.Login);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.Login) {
            Sqllitehelper db = new Sqllitehelper(this);
            Cursor res = db.checkdata(username.getText().toString(), password.getText().toString());
            if (res.getCount() != 0)
            {
                startActivity(new Intent(this, HomeActivity.class));
            }
            else
            {
                Toast.makeText(this, "Username and password are incorrect", Toast.LENGTH_LONG).show();

            }

        }
    }
}
