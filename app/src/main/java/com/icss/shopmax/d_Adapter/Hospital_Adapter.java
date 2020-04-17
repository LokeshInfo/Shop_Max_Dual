package com.icss.shopmax.d_Adapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.icss.shopmax.API_Retro.BaseUrl;
import com.icss.shopmax.A_Model.Hospital_data;
import com.icss.shopmax.R;
import com.icss.shopmax.All_Services_Class.Sub_Category.Sub_Hospital_fragment;

import java.util.List;

public class Hospital_Adapter extends RecyclerView.Adapter<Hospital_Adapter.ViewHolder>
{
    List<Hospital_data> dataList;
    Activity activity;

    public Hospital_Adapter(Activity activity, List<Hospital_data> dlist){
        this.activity = activity;
        this.dataList = dlist;
        setHasStableIds(true);
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public Hospital_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_hospital,parent,false);
        return new Hospital_Adapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Hospital_Adapter.ViewHolder holder, final int i) {
        if (holder!=null){

            holder.hospital.setText(dataList.get(i).getHospital_name());

            Glide.with(activity).load(BaseUrl.image_hospitals+dataList.get(i).getBanner()).into(holder.img_hospital);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        AppCompatActivity activ = (AppCompatActivity) v.getContext();
                        Fragment fragment = new Sub_Hospital_fragment();
                        Bundle args = new Bundle();
                        args.putString("hospital_id",dataList.get(i).getHospital_id());
                        fragment.setArguments(args);
                        FragmentManager fragmentmanager =activ.getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction =fragmentmanager.beginTransaction();
                        fragmentTransaction.addToBackStack(fragment.getTag());
                        fragmentTransaction.replace(R.id.fragment_layout,fragment);
                        fragmentTransaction.commit();
                }
            });

        }

    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView hospital;
        ImageView img_hospital;

        public ViewHolder(View itemview){
            super(itemview);
            hospital = itemview.findViewById(R.id.hs_name);
            img_hospital = itemview.findViewById(R.id.hs_image);
        }
    }

}
