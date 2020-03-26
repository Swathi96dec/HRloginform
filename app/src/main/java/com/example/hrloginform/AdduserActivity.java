package com.example.hrloginform;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sqllite.Sqllitehelper;

public class AdduserActivity extends AppCompatActivity implements View.OnClickListener {
    EditText username,salary,age;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adduser);
       username=findViewById(R.id.username);
       salary=findViewById(R.id.salary);
       age=findViewById(R.id.age);
       submit=findViewById(R.id.submit);
       submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.submit)
        {
            boolean result=false;
            Sqllitehelper db=new Sqllitehelper(this);
            String user_name=username.getText().toString();
            String salary_=salary.getText().toString();
            String age_=age.getText().toString();

            Integer salary=Integer.parseInt(salary_);
            Integer age=Integer.parseInt(age_);
            db.adduser(user_name,salary,age);
            if(result)
            {
                Toast.makeText(this, " Employee added Successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,HomeActivity.class));
            }

        }

    }
}
