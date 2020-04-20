package com.icss.shopmax.All_Services_Class.Services;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.icss.shopmax.API_Retro.BaseUrl;
import com.icss.shopmax.A_Model.TechnicalSupport;
import com.icss.shopmax.R;
import com.icss.shopmax.d_Adapter.Sub_it_customer_service;

import java.util.List;

public class Technical_Adapter extends RecyclerView.Adapter<Technical_Adapter.ViewHolder> {

    List<TechnicalSupport> dataList;
    CardView card;
    Activity mactivity;

    public Technical_Adapter(Activity mactivity, List<TechnicalSupport> dataList) {
        this.mactivity = mactivity;
        this.dataList = dataList;
        setHasStableIds(true);
    }

    @NonNull
    @Override
    public Technical_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_chef, viewGroup, false);
        return new Technical_Adapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Technical_Adapter.ViewHolder viewHolder, final int i) {
        if (viewHolder != null) {
            final TechnicalSupport technicalSupport = dataList.get(i);


            viewHolder.name.setText(technicalSupport.getSubServiceName());
            Glide.with(mactivity).load(BaseUrl.technicalBanner + technicalSupport.getBanner()).into(viewHolder.img);

            viewHolder.card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AppCompatActivity activ = (AppCompatActivity) v.getContext();
                    Bundle bundle = new Bundle();
                    Fragment fragment = new Sub_it_customer_service();
                    bundle.putString("sub_service_id", technicalSupport.getSubServiceId());
                    bundle.putString("TYPE", "TECHNICAL_SERVICE");
                    fragment.setArguments(bundle);
                    FragmentManager fragmentmanager = activ.getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentmanager.beginTransaction();
                    fragmentTransaction.addToBackStack(fragment.getTag());
                    fragmentTransaction.replace(R.id.fragment_layout, fragment);
                    fragmentTransaction.commit();
                }
            });


        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView img;
        CardView card;

        public ViewHolder(View itemview) {
            super(itemview);
            name = (TextView) itemview.findViewById(R.id.txservice);
            img = (ImageView) itemview.findViewById(R.id.imagevu);
            card = (CardView) itemview.findViewById(R.id.item);

        }
    }
}
