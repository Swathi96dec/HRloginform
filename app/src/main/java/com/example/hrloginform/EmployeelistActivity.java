package com.example.hrloginform;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.API.apiclass;

import com.example.Interfaces.IEmployeeListview;
import com.example.Interfaces.Ipresenter;
import com.example.Presenter.Presenter;
import com.example.adapter.recycleviewadapter;

import java.util.List;

public class EmployeelistActivity extends AppCompatActivity implements IEmployeeListview, View.OnClickListener {
    RecyclerView recyclerView;
    Ipresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewallusers);
       recyclerView=findViewById(R.id.Recyclerview);
        presenter = new Presenter(this);
        if(checkconnectivity()) {
            presenter.getdatafromapi();
        }
        else
        {
            Toast.makeText(this, "Please connect to Internet to see the list", Toast.LENGTH_LONG).show();
        }
       // Getdatafromapi();

    }

   // private void Getdatafromapi() {
       /* apihelper service = Retrofitinstance.getRetrofitInstance().create(apihelper.class);
        Call<apiclass> call=service.getdata();
        call.enqueue(new Callback<apiclass>() {
            @Override
            public void onResponse(Call <apiclass> call, Response<apiclass> response) {
                if (response.isSuccessful()) {
                    apiclass data=response.body();
                    List<apiclass.data> datalist =data.data;

                   setdatainrecycleview(datalist);
                }
                else
                {
                    Toast.makeText(EmployeelistActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<apiclass> call, Throwable t) {
                Toast.makeText(EmployeelistActivity.this, "Unable to fetch data", Toast.LENGTH_LONG).show();

            }
        });*/

  //  }
    @Override
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
    public void setdatainrecycleview(List<apiclass.data> list){
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recycleviewadapter adapter = new recycleviewadapter(this, list);
       recyclerView.setAdapter(adapter);
    }

    @Override
    public void onfailureresponse(String message) {
        Toast.makeText(EmployeelistActivity.this, message, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onClick(View v) {

    }
}
