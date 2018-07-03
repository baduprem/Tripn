package com.example.prem.trip.DataManger;

import com.example.prem.trip.Model.ModelCategoryItemlist;
import com.example.prem.trip.Model.ModelSubCategoryItemIist;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @GET("nav_list_select.php")
    Call<List<ModelCategoryItemlist>> getCategories();
    @POST("detail.php")
    @FormUrlEncoded
    Call<List<ModelSubCategoryItemIist>> getSubCategories(@Field("c_id") String c_id);
}
