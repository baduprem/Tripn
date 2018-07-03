package com.example.prem.trip.Fragments;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.prem.trip.Adapter.HomeAdapter;
import com.example.prem.trip.DataManger.ApiClient;
import com.example.prem.trip.DataManger.ApiInterface;
import com.example.prem.trip.Model.ModelCategoryItemlist;
import com.example.prem.trip.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {


    private RecyclerView recyclerView;
    private GridLayoutManager layoutManager;
    private HomeAdapter adapter;
    private List<ModelCategoryItemlist> category;
    private ApiInterface apiInterface;
    Context context;

//    onHomeSendListener homeSendListener;
//    public  interface onHomeSendListener{
//        public  void  onHomeSendListener(String SubCategory);
//
//    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        context = getActivity();
        View view =inflater.inflate(R.layout.home_fragment_recy_list, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.homeRecyvlierView);
        layoutManager= new GridLayoutManager(context,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        apiInterface= ApiClient.getRetrofit().create(ApiInterface.class);
        Call<List<ModelCategoryItemlist>> call= apiInterface.getCategories();

        call.enqueue(new Callback<List<ModelCategoryItemlist>>() {
            @Override
            public void onResponse(Call<List<ModelCategoryItemlist>> call, Response<List<ModelCategoryItemlist>> response) {

                category = response.body();
                Toast.makeText(context, ""+category.size(), Toast.LENGTH_SHORT).show();
                adapter= new HomeAdapter(category,context);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<ModelCategoryItemlist>> call, Throwable t) {

            }
        });
         return view;
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        Activity activity = (Activity) context;
//        try {
//            homeSendListener= (onHomeSendListener) activity;
//        }
//        catch (ClassCastException e){
//            throw new ClassCastException(activity.toString()+"must implement homeSendListener");
//        }

//    }
}
