package com.example.sqllite;

public class Dbconstants {
    static final String username= "username";
    static final String password="password";
    static final String salary="salary";
    static final String age="age";
    static final String tablename="users";
    static final String employeetable="employee";
    static final String Createemployeetable="Create Table employee( username Text PRIMARYKEY, salary Integer, age Integer)";
    static final String Createtable="Create Table users( username Text PRIMARYKEY, password Text)";
    static final String Deletetable="Drop table if exists users";
    static final String Deleteemployeetable="Drop table if exists employee";

}
