package com.example.API;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
public interface apihelper {
    @GET("employees")
    Call<List<apiclass>> getdata();
    @FormUrlEncoded
    @POST("create")
   Call<apiclass>createdata(
            @Field("name") String name,
            @Field("salary")   int salary,
            @Field("age")   int age
    );
}
