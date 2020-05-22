package com.example.Presenter;
import android.database.Cursor;

import com.example.API.apiclass;
import com.example.Interfaces.ILoginView;
import  com.example.Interfaces.IModel;
import  com.example.Interfaces.Ipresenter;
import com.example.Interfaces.Iview;
import com.example.model.Modelhandler;

import java.util.List;

public class Presenter implements Ipresenter {
    private IModel model;
   private Iview view;
  private  ILoginView loginView;

    public Presenter(Iview view)
    {
        this.view=view;
        model=new Modelhandler(view);

    }
    public Presenter(ILoginView view)
    {
        this.loginView=view;
        model=new Modelhandler(loginView);

    }
    @Override
    public void getdatafromsqllite() {
      Cursor data=model.getdatafromCursor();
      view.ongetdataresponse(data);

    }

    @Override
    public void adduser(String username,String password) {
       boolean result= model.addusers(username,password);
       view.onadduserresponse(result);
    }

    @Override
    public void checkdata(String username,String password) {
        Cursor data=model.checkdata(username,password);
        loginView.onloginresponse(data);

    }

    @Override
    public List<apiclass.data> getdatafromapi() {
        return null;
    }
}
