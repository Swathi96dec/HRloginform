package com.example.Interfaces;

import android.database.Cursor;


public interface Iview {
//boolean addusers();
//Cursor checkdata();
    //List<apiclass.data> getdatafromapi();
void ongetdataresponse(Cursor data);
void onadduserresponse(boolean result);

}
