package com.example.prem.trip.Fragments;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.prem.trip.Adapter.SubActivityAdapter;
import com.example.prem.trip.DataManger.ApiClient;
import com.example.prem.trip.DataManger.ApiInterface;
import com.example.prem.trip.Model.ModelSubCategoryItemIist;
import com.example.prem.trip.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubActivityFragment extends Fragment {
    private RecyclerView recyclerView;
    private SubActivityAdapter adapter;
    private List<ModelSubCategoryItemIist> sub_Category;
    private ApiInterface apiInterface;
    private LinearLayoutManager linearLayoutManager;
    Context context;
    String category_id;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        context = getActivity();
//        Intent intent = getIntent();
//        Bundle bd = intent.getExtras();
//
//        if(bd!=null)
//        {
//            CategoryId = (String) bd.get("categoryId");
//        }
        Bundle bundle = this.getArguments();
        if (bundle!=null) {
            int id = bundle.getInt("id");
            Toast.makeText(context, "required id" + id, Toast.LENGTH_SHORT).show();
        }

//        String id = getArguments().getString("c_ic");
        View view =inflater.inflate(R.layout.subfragment_recy_list, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.homeRecyvlierView);
      linearLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        apiInterface= ApiClient.getRetrofit().create(ApiInterface.class);
        Call<List<ModelSubCategoryItemIist>> call =apiInterface.getSubCategories(category_id);
        call.enqueue(new Callback<List<ModelSubCategoryItemIist>>() {
            @Override
            public void onResponse(Call<List<ModelSubCategoryItemIist>> call, Response<List<ModelSubCategoryItemIist>> response) {
                sub_Category = response.body();
                adapter= new SubActivityAdapter(sub_Category,context);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<ModelSubCategoryItemIist>> call, Throwable t) {

            }
        });


        return view;
    }
}
