package com.example.API;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
public interface apihelper {
    @GET("employees")
    Call<apiclass> getdata();
    @FormUrlEncoded
    @POST("create")
   Call<apiclass.data>createdata(
            @Field("name") String name,
            @Field("salary")   int salary,
            @Field("age")   int age
    );
}
