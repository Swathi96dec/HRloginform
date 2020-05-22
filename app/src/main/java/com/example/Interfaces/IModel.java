package com.example.Interfaces;

import android.database.Cursor;

import com.example.API.apiclass;

import java.util.List;

public interface IModel {
    Cursor getdatafromCursor();
    boolean addusers(String username,String password);
    Cursor checkdata(String username,String password);
    List<apiclass.data> getdatafromapi();
}
