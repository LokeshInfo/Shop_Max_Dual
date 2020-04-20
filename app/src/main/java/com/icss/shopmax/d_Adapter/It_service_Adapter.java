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
import com.icss.shopmax.A_Model.ITSupport;
import com.icss.shopmax.R;

import java.util.List;

public class It_service_Adapter extends RecyclerView.Adapter<It_service_Adapter.ViewHolder> {
    List<ITSupport> dlist;
    Activity activity;

    public It_service_Adapter(Activity activity, List<ITSupport> listd) {
        this.activity = activity;
        this.dlist = listd;
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
    public It_service_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_hospital, parent, false);
        return new It_service_Adapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull It_service_Adapter.ViewHolder holder, final int i) {

        final ITSupport itSupport = dlist.get(i);
        holder.hospital.setText(itSupport.getSubServiceName());
        Glide.with(activity).load(BaseUrl.getITBanner + itSupport.getBanner()).into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                AppCompatActivity activ = (AppCompatActivity) v.getContext();
                Fragment fragment = new Sub_it_customer_service();
                bundle.putString("sub_service_id", itSupport.getSubServiceId());
                bundle.putString("TYPE","IT_SERVICE");
                fragment.setArguments(bundle);
                FragmentManager fragmentmanager = activ.getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentmanager.beginTransaction();
                fragmentTransaction.addToBackStack(fragment.getTag());
                fragmentTransaction.replace(R.id.fragment_layout, fragment);
                fragmentTransaction.commit();
            }
        });


    }


    @Override
    public int getItemCount() {
        return dlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView hospital;
        ImageView imageView;

        public ViewHolder(View itemview) {
            super(itemview);
            hospital = itemview.findViewById(R.id.hs_name);
            imageView = itemview.findViewById(R.id.hs_image);
        }
    }

}
