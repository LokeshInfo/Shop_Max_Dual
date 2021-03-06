package com.icss.shopmax.d_Adapter;

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

import com.bumptech.glide.Glide;
import com.icss.shopmax.R;

import java.util.ArrayList;

class classfieds_sub_adapter extends RecyclerView.Adapter<classfieds_sub_adapter.ViewHolder> {
    ArrayList<vehicle_Data> dlist;
    Activity activity;
    public classfieds_sub_adapter(Activity activity, ArrayList<vehicle_Data> listd){
        this.activity = activity;
        this.dlist = listd;
        setHasStableIds(true);
    }

    @NonNull
    @Override
    public classfieds_sub_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_sub_classfieds,parent,false);
        return new classfieds_sub_adapter.ViewHolder(v);    }

    @Override
    public void onBindViewHolder(@NonNull classfieds_sub_adapter.ViewHolder holder, int position) {
        holder.tx1.setText(dlist.get(position).getName());
        holder.tx2.setText(dlist.get(position).getType());
        holder.tx3.setText(""+dlist.get(position).getPrice());
        Glide.with(activity).load(dlist.get(position).getImage()).into(holder.img1);
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activ = (AppCompatActivity) v.getContext();
                Fragment fragment=new fragment_description();
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
        TextView tx1,tx2,tx3;
        ImageView img1;
        LinearLayout layout;

        public ViewHolder(View itemview){
            super(itemview);
            tx1 = itemview.findViewById(R.id.tx1);
            tx2 = itemview.findViewById(R.id.tx2);
            tx3 = itemview.findViewById(R.id.tx3);
            img1 = itemview.findViewById(R.id.img1);
            layout = itemview.findViewById(R.id.layout);
        }
    }
}
