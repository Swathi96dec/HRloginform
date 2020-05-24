package com.example.Interfaces;

import android.content.Context;
import android.database.Cursor;

import com.example.API.apiclass;

import java.util.List;

public interface Ipresenter {
    void getdatafromsqllite();
    void adduser(String username,String password);
    void checkdata(String username,String password);
    void getdatafromapi();
    void adddata(String username,Integer salary, Integer age);
}
