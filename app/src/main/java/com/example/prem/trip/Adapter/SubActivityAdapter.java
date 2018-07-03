package com.example.prem.trip.Adapter;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.prem.trip.DataManger.ApiClient;
import com.example.prem.trip.Fragments.SubActivityFragment;
import com.example.prem.trip.Model.ModelSubCategoryItemIist;
import com.example.prem.trip.R;
import com.squareup.picasso.Picasso;

import java.util.List;


public class SubActivityAdapter extends RecyclerView.Adapter<SubActivityAdapter.ViewTextHolder>{
    private Context context;
    private List<ModelSubCategoryItemIist> subCategory;

    public SubActivityAdapter(List<ModelSubCategoryItemIist> subCategory, Context context) {
        this.subCategory = subCategory;
        this.context= context;
    }

    @NonNull
    @Override
    public SubActivityAdapter.ViewTextHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.subfragment_list_item_view,parent, false);
        ViewTextHolder recyclerViewHolder= new ViewTextHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SubActivityAdapter.ViewTextHolder holder, int position) {
        final String destName = subCategory.get(position).getName();
        final String destDes =subCategory.get(position).getDescription();
        String titleImg =subCategory.get(position).getImg_url();
        final String image_url = ApiClient.BASE_URL+"uploads/"+titleImg;
        holder.detail1.setText(destDes);
        holder.title1.setText(destName);
        Picasso.with(context).load(image_url).into(holder.titleImage1);
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return subCategory.size();
    }

    public class ViewTextHolder extends RecyclerView.ViewHolder{

        ImageView titleImage1;
        TextView title1;
        TextView detail1;
        public ViewTextHolder(View itemView) {
            super(itemView);
           titleImage1 = itemView.findViewById(R.id.titleImage);
           title1= itemView.findViewById(R.id.title);
           detail1= itemView.findViewById(R.id.detail);
        }
    }
}
