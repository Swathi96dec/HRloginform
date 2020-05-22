package com.example.model;

import android.content.Context;
import android.database.Cursor;

import com.example.API.apiclass;
import com.example.Interfaces.ILoginView;
import com.example.Interfaces.IModel;
import com.example.Interfaces.Iview;
import com.example.sqllite.Sqllitehelper;

import java.util.List;

public class Modelhandler implements IModel {
    private Sqllitehelper db;

    public Modelhandler(Iview view) {
        db = new Sqllitehelper((Context) view);

    }
    public Modelhandler(ILoginView view) {
        db = new Sqllitehelper((Context) view);

    }

    @Override
    public Cursor getdatafromCursor() {
        return db.getdata();

    }

    @Override
    public boolean addusers(String username,String password) {
        return db.adddata(username,password);
    }

    @Override
    public Cursor checkdata(String username,String password) {
       return db.checkdata(username,password);
    }

    @Override
    public List<apiclass.data> getdatafromapi() {
        return null;
    }
}
