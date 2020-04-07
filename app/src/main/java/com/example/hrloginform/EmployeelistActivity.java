package com.example.hrloginform;


import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.API.Retrofitinstance;
import com.example.API.apiclass;
import com.example.API.apihelper;
import com.example.adapter.recycleviewadapter;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmployeelistActivity extends AppCompatActivity implements View.OnClickListener {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewallusers);
       recyclerView=findViewById(R.id.Recyclerview);
        Getdatafromapi();

    }

    private void Getdatafromapi() {
        apihelper service = Retrofitinstance.getRetrofitInstance().create(apihelper.class);
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
        });

    }

    private void setdatainrecycleview(List<apiclass.data> list){
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recycleviewadapter adapter = new recycleviewadapter(this, list);
       recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {

    }
}
