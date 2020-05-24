package com.example.Interfaces;

import com.example.API.apiclass;

import java.util.List;

public interface IEmployeeListview {
    void setdatainrecycleview(List<apiclass.data> list);
    void onfailureresponse(String message);
    boolean checkconnectivity();

}
