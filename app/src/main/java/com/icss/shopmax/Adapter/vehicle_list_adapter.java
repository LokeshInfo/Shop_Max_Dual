package com.icss.shopmax.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.icss.shopmax.R;

import java.util.ArrayList;
import java.util.List;

public class vehicle_list_adapter extends RecyclerView.Adapter<vehicle_list_adapter.ViewHolder> {
    List<vehicle_list_Data> dlist;
    Activity activity;
    public vehicle_list_adapter(Activity activity, List<vehicle_list_Data> listd){
        this.activity = activity;
        this.dlist = listd;
        setHasStableIds(true);
    }

    public vehicle_list_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_classfieds_list_vehicle,parent,false);
        return new vehicle_list_adapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tx1.setText(dlist.get(position).getType());
        holder.tx2.setText(""+dlist.get(position).getSearch());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activ = (AppCompatActivity) v.getContext();
                Fragment fragment=new vehicle_sub_fragment();
                FragmentManager fragmentmanager =activ.getSupportFragmentManager();
                FragmentTransaction fragmentTransaction =fragmentmanager.beginTransaction();
                fragmentTransaction.addToBackStack(fragment.getTag());
                fragmentTransaction.replace(R.id.fragment_layout,fragment);
                fragmentTransaction.commit();

            }
        });


    }

    @Override
    public int getItemCount() {
        return dlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView tx1,tx2;
        ImageView img1;
        LinearLayout layout;
        public ViewHolder(View itemview){
            super(itemview);
            tx1 = itemview.findViewById(R.id.tx1);
            tx2 = itemview.findViewById(R.id.tx2);
            img1 = itemview.findViewById(R.id.img1);
            layout = itemview.findViewById(R.id.layout);
        }
    }
}
