package com.example.prem.trip.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.prem.trip.Adapter.SubActivityAdapter;
import com.example.prem.trip.DataManger.ApiClient;
import com.example.prem.trip.DataManger.ApiInterface;
import com.example.prem.trip.Model.ModelSubCategoryItemIist;
import com.example.prem.trip.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SubActivityAdapter adapter;
    private List<ModelSubCategoryItemIist> sub_Category;
    private ApiInterface apiInterface;

    private LinearLayoutManager linearLayoutManager;
    String CategoryId;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subfragment_recy_list);
        Intent intent = getIntent();
        Bundle bd = intent.getExtras();

        if(bd!=null)
        {
            CategoryId = (String) bd.get("categoryId");
        }
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView = (RecyclerView) findViewById(R.id.subfragment_recy_list);
        recyclerView.setLayoutManager(linearLayoutManager);

        apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);
        Call<List<ModelSubCategoryItemIist>> call = apiInterface.getSubCategories(CategoryId);
        call.enqueue(new Callback<List<ModelSubCategoryItemIist>>() {
            @Override
            public void onResponse(Call<List<ModelSubCategoryItemIist>> call, Response<List<ModelSubCategoryItemIist>> response) {
                sub_Category= response.body();
                adapter= new SubActivityAdapter(sub_Category,SubActivity.this);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<ModelSubCategoryItemIist>> call, Throwable t) {

            }
        });
    }


}
