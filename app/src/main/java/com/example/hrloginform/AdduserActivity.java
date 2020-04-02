package com.example.hrloginform;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.API.Retrofitinstance;

import com.example.API.apiclass;
import com.example.API.apihelper;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdduserActivity extends AppCompatActivity implements View.OnClickListener {
    EditText username, salary, age;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adduser);
        username = findViewById(R.id.username);
        salary = findViewById(R.id.salary);
        age = findViewById(R.id.age);
        submit = findViewById(R.id.submit);
        submit.setOnClickListener(this);

    }

    private String[] Adddata() {
        final String[] res = new String[1];

        apihelper service = Retrofitinstance.getRetrofitInstance().create(apihelper.class);
        Call<apiclass> call = service.createdata(username.getText().toString(), Integer.parseInt(salary.getText().toString()), Integer.parseInt(age.getText().toString()));

        call.enqueue(new Callback<apiclass>() {
            @Override
            public void onResponse(Call<apiclass> call, Response<apiclass> response) {
                Toast.makeText(AdduserActivity.this, "User added succesfully", Toast.LENGTH_LONG).show();
                res[0] ="success";

            }

            @Override
            public void onFailure(Call<apiclass> call, Throwable t) {
                Toast.makeText(AdduserActivity.this, "User not added succesfully" +t.getMessage(), Toast.LENGTH_LONG).show();
                res[0]="failed";

            }


        });
        return res;

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.submit) {
            boolean res;
            res=validatedata();
            if(res)
            {
               String[] Res = Adddata();
               if(Res[0].equals("success"))
               {
                   startActivity(new Intent(this,HomeActivity.class));
               }

            }


        }

    }

    private boolean validatedata() {
        boolean result = true;
        String regex;
        Matcher matcher;
        if (username.getText().toString().equals("")) {
            username.setError("name is required");
            result = false;
        } else {
             regex= "[a-zA-Z]+$";
            matcher = Pattern.compile(regex).matcher(username.getText().toString());
            if (!matcher.find()) {
                username.setError("name should be in alphabets");
                result = false;

            }
        }
            if (salary.getText().toString().equals("")) {
                salary.setError("salary is required");
                result = false;
            } else {
                 regex = "[0-9]+$";
                matcher = Pattern.compile(regex).matcher(salary.getText());
                if (!matcher.find()) {
                    salary.setError("salary should be in numbers");
                    result = false;

                }
            }

            if (age.getText().toString().equals("")) {
                age.setError("age is required");
                result = false;
            } else {
                regex = "[0-9]+$";
                matcher = Pattern.compile(regex).matcher(age.getText());
                if (!matcher.find()) {
                    age.setError("age should be in numbers");
                    result = false;

                }
            }

        return result;
        }

    }

