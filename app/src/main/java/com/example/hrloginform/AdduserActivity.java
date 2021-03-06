package com.example.hrloginform;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.Interfaces.IAdduser;
import com.example.Interfaces.Ipresenter;
import com.example.Presenter.Presenter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdduserActivity extends AppCompatActivity implements IAdduser, View.OnClickListener {
    EditText username, salary, age;
    Button submit;
   // final String[] res1 = new String[1];
    Ipresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adduser);
        username = findViewById(R.id.username);
        salary = findViewById(R.id.salary);
        age = findViewById(R.id.age);
        submit = findViewById(R.id.submit);
        submit.setOnClickListener(this);
        presenter = new Presenter(this);

    }

   /* private void Adddata() {

        boolean connectivity;
        connectivity=checkconnectivity();

    if(connectivity) {
    apihelper service = Retrofitinstance.getRetrofitInstance().create(apihelper.class);
    Call<apiclass.data> call = service.createdata(username.getText().toString(), Integer.parseInt(salary.getText().toString()), Integer.parseInt(age.getText().toString()));

    call.enqueue(new Callback<apiclass.data>() {
        @Override
        public void onResponse(Call<apiclass.data> call, Response<apiclass.data> response) {
            if (response.isSuccessful()) {
                Toast.makeText(AdduserActivity.this, "User added succesfully", Toast.LENGTH_LONG).show();
                res1[0]="success";
                loadHomepage();

            }
            else
            {
                Toast.makeText(AdduserActivity.this, response.message(), Toast.LENGTH_LONG).show();
            }

        }

        @Override
        public void onFailure(Call<apiclass.data> call, Throwable t) {
            Toast.makeText(AdduserActivity.this, "User not added succesfully" + t.getMessage(), Toast.LENGTH_LONG).show();
            res1[0]="failed";
            loadHomepage();

        }


    });
}

else {
    res1[0]="Internet connection Required";
    }


    }

    public void loadHomepage()
    {
          if(res1[0].equals("success"))
               {
                   Toast.makeText(AdduserActivity.this, "User added succesfully", Toast.LENGTH_LONG).show();
                   new Handler().postDelayed(new Runnable() {

                       @Override
                       public void run() {
                           //do something
                           LoadHomepagewithdelay();
                       }
                   }, 5000 );

               }
               else{
                   if(res1[0].equals("failed"))
                   {
                       Toast.makeText(AdduserActivity.this, "User not added succesfully Please try again", Toast.LENGTH_LONG).show();
                   }
                   else{
                       Toast.makeText(AdduserActivity.this, "Check your Internet Connection", Toast.LENGTH_LONG).show();
                   }

               }
    } */
    public void LoadHomepagewithdelay()
    {
        startActivity(new Intent(this,HomeActivity.class));
    }

    public boolean checkconnectivity()
    {
        ConnectivityManager cm =
                (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);

        assert cm != null;
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        return activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.submit) {
            boolean res;
            res=validatedata();
           // res=validatedata();
            if(res)
            {
                if(checkconnectivity()) {
                    presenter.adddata(username.getText().toString(), Integer.parseInt(salary.getText().toString()), Integer.parseInt(age.getText().toString()));
                    //Adddata();
                }
                else
                {
                    Toast.makeText(this, "Please connect to Internet ", Toast.LENGTH_SHORT).show();
                }

            }

        }

    }
@Override
    public boolean validatedata() {
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

    @Override
    public void onadddataresponse(String message) {
        if(message.equals("User added Succesfully"))
        {
            Toast.makeText(AdduserActivity.this, "User added succesfully", Toast.LENGTH_LONG).show();
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    //do something
                    LoadHomepagewithdelay();
                }
            }, 5000 );
        }

        else
        {
            Toast.makeText(AdduserActivity.this, message, Toast.LENGTH_LONG).show();
        }

    }
}

