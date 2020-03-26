package com.example.sqllite;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Sqllitehelper extends SQLiteOpenHelper {

private static final int Database_version=1;
private static final String Databasename="RegistrationDb";

public Sqllitehelper(@Nullable Context context)
{
    super(context,Databasename,null,Database_version);

}

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL(Dbconstants.Createtable);
    db.execSQL(Dbconstants.Createemployeetable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(Dbconstants.Deletetable);
        db.execSQL(Dbconstants.Deleteemployeetable);
        onCreate(db);

    }

    public Cursor getdata() {
        SQLiteDatabase database = this.getWritableDatabase();
        return database.rawQuery("select * from users",null);
        }

    public boolean adddata(String Username, String Password ) {
    SQLiteDatabase database = this.getWritableDatabase();
    ContentValues contentvalues=new ContentValues();
    contentvalues.put(Dbconstants.username,Username);
    contentvalues.put(Dbconstants.password,Password);

    long result =database.insert(Dbconstants.tablename,null,contentvalues);
    if(result==-1)
        return false;

    else
        return true;
}
    public boolean adduser(String Username, int salary ,int age ) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentvalues=new ContentValues();
        contentvalues.put(Dbconstants.username,Username);
        contentvalues.put(Dbconstants.salary,salary);
        contentvalues.put(Dbconstants.age,age);

        long result =database.insert(Dbconstants.employeetable,null,contentvalues);
        if(result==-1)
            return false;

        else
            return true;
    }
    public Cursor getallemployee() {
        SQLiteDatabase database = this.getWritableDatabase();
        return database.rawQuery("select * from employee",null);
    }



    public Cursor checkdata(String Username, String Password ) {
        SQLiteDatabase database = this.getWritableDatabase();
        String username=Username.toString().trim();
        String password=Password.toString().trim();
         final String checkcreds="select * from users where username "+"= '"+ username+"'" +" and" +" password " + "= '"+ password + "'";
        return database.rawQuery(checkcreds,null);

}
}


