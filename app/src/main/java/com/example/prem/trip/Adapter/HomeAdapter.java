package com.example.prem.trip.Adapter;


import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prem.trip.Activities.SubActivity;

import com.example.prem.trip.Fragments.SubActivityFragment;
import com.example.prem.trip.Model.ModelCategoryItemlist;
import com.example.prem.trip.R;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter <HomeAdapter.ViewTextHolder> {

    Context context;
    private List<ModelCategoryItemlist> category;
    public HomeAdapter(List<ModelCategoryItemlist> category, Context context){
        this.category=category;
        this.context=context;


    }

    @NonNull
    @Override
    public ViewTextHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_list_item_view,parent, false);
        ViewTextHolder recyclerViewHolder = new ViewTextHolder(view);
        return recyclerViewHolder;

        //return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewTextHolder holder, final int position) {
        final String c_name =category.get(position).getC_name();
       final String c_id =category.get(position).getC_id();
        holder.cname.setText(c_name);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,SubActivity.class);
                intent.putExtra("categoryName", c_name);
                intent.putExtra("categoryId", c_id);
                context.startActivity(intent);


//                SubActivityFragment subActivityFragment = new SubActivityFragment();
//                Bundle bundle = new Bundle();
//                bundle.putString("id",c_id);

               // subActivityFragment.setArguments(bundle);

//                subActivityFragment.setArguments(bundle);
//                Intent intent=new Intent(context,SubActivity.class);
//                context.startActivity(intent);


              //  Toast.makeText(context, ""+, Toast.LENGTH_SHORT).show();

//                String id = c_id;
//                SubActivityFragment subActivityFragment = new SubActivityFragment();
//                FragmentManager fragmentManager = getFragmenbntManager();
//                FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
//                 args.putString("id", c_id);
//                subActivityFragment.setArguments(bundle);
//                subActivityFragment.replace(R.id.subfragment_recy_list, subActivityFragment);
//                subActivityFragment.commit();


//String cid=c_id.getText().toString();
// Fragment fr=new friendfragment();
// FragmentManager fm=getFragmentManager();
// android.app.FragmentTransaction ft=fm.beginTransaction();
// Bundle args = new Bundle();
// args.putString("CID", cid);
// fr.setArguments(args);
// ft.replace(R.id.content_frame, fr);
// ft.commit();



            }
        });
    }

//    private FragmentManager getFragmentManager() {
//        return null;
//    }

    @Override
    public int getItemCount() {
        return category.size();
    }

    public class ViewTextHolder extends RecyclerView.ViewHolder {
        TextView cname;
        ImageView imageView;

        public ViewTextHolder(View itemView) {
            super(itemView);
            cname = itemView.findViewById(R.id.c_name);
            imageView = itemView.findViewById(R.id.homeImg1);
        }
    }
}
