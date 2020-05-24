package com.example.Presenter;
import android.database.Cursor;
import com.example.API.Retrofitinstance;
import com.example.API.apiclass;
import com.example.API.apihelper;
import com.example.Interfaces.IAdduser;
import com.example.Interfaces.IEmployeeListview;
import com.example.Interfaces.ILoginView;
import  com.example.Interfaces.IModel;
import  com.example.Interfaces.Ipresenter;
import com.example.Interfaces.Iview;
import com.example.model.Modelhandler;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class Presenter implements Ipresenter {
    private IModel model;
    private Iview view;
    private ILoginView loginView;
    private IEmployeeListview employeelist;
    private IAdduser adduser;

    public Presenter(Iview view) {
        this.view = view;
        model = new Modelhandler(view);

    }

    public Presenter(IAdduser adduser) {


        this.adduser = adduser;
    }


    public Presenter(ILoginView view) {
        this.loginView = view;
        model = new Modelhandler(loginView);

    }

    public Presenter(IEmployeeListview view) {
        this.employeelist = view;


    }

    @Override
    public void getdatafromsqllite() {
        Cursor data = model.getdatafromCursor();
        view.ongetdataresponse(data);

    }

    @Override
    public void adduser(String username, String password) {
        boolean result = model.addusers(username, password);
        view.onadduserresponse(result);
    }

    @Override
    public void checkdata(String username, String password) {
        Cursor data = model.checkdata(username, password);
        loginView.onloginresponse(data);

    }

    @Override
    public void getdatafromapi() {

        apihelper service = Retrofitinstance.getRetrofitInstance().create(apihelper.class);
        Call<apiclass> call = service.getdata();
        call.enqueue(new Callback<apiclass>() {
            @Override
            public void onResponse(Call<apiclass> call, Response<apiclass> response) {
                if (response.isSuccessful()) {
                    apiclass data = response.body();
                    List<apiclass.data> datalist = data.data;

                    employeelist.setdatainrecycleview(datalist);
                } else {
                    // Toast.makeText(context, response.message(), Toast.LENGTH_SHORT).show();
                    employeelist.onfailureresponse(response.message());
                }

            }

            @Override
            public void onFailure(Call<apiclass> call, Throwable t) {
                //Toast.makeText(EmployeelistActivity.this, "Unable to fetch data", Toast.LENGTH_LONG).show();
                employeelist.onfailureresponse(t.getMessage());

            }
        });


    }

    @Override
    public void adddata(String username, Integer salary, Integer age) {

            apihelper service = Retrofitinstance.getRetrofitInstance().create(apihelper.class);
            Call<apiclass.data> call = service.createdata(username, salary, age);

            call.enqueue(new Callback<apiclass.data>() {
                @Override
                public void onResponse(Call<apiclass.data> call, Response<apiclass.data> response) {
                    if (response.isSuccessful()) {
                       // Toast.makeText(AdduserActivity.this, "User added succesfully", Toast.LENGTH_LONG).show();
                       // res1[0] = "success";
                      //  loadHomepage();
                        adduser.onadddataresponse("User added Succesfully");

                    } else {
                        //Toast.makeText(AdduserActivity.this, response.message(), Toast.LENGTH_LONG).show();
                        adduser.onadddataresponse("There is some error in page"+response.message());
                    }

                }

                @Override
                public void onFailure(Call<apiclass.data> call, Throwable t) {
                  //  Toast.makeText(AdduserActivity.this, "User not added succesfully" + t.getMessage(), Toast.LENGTH_LONG).show();
                   // res1[0] = "failed";
                  //  loadHomepage();
                    adduser.onadddataresponse("There is some error in page"+t.getMessage());

                }


            });
        }

    }


