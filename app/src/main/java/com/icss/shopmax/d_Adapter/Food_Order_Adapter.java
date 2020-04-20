package com.icss.shopmax.d_Adapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.icss.shopmax.API_Retro.BaseUrl;
import com.icss.shopmax.A_Model.Restaurant;
import com.icss.shopmax.All_Services_Class.Sub_Category.Tab_Food_Order_Fragment;
import com.icss.shopmax.R;

import java.util.List;

public class Food_Order_Adapter extends RecyclerView.Adapter<Food_Order_Adapter.ViewHolder> {
    List<Restaurant> dataList;
    Activity mactivity;

    public Food_Order_Adapter(Activity mactivity, List<Restaurant> dataList) {
        this.mactivity = mactivity;
        this.dataList = dataList;
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

    @Override
    public Food_Order_Adapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_services, viewGroup, false);
        return new Food_Order_Adapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(Food_Order_Adapter.ViewHolder holder, final int i) {
        Restaurant restaurant = dataList.get(i);
        holder.name.setText(restaurant.getRestaurantName());
        Glide.with(mactivity).load(BaseUrl.getRestaurantImg + restaurant.getBanner()).into(holder.img);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment;
                FragmentManager fragmentmanager;
                FragmentTransaction fragmentTransaction;
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                Bundle args = new Bundle();
                fragment = new Tab_Food_Order_Fragment();
                args.putString("rname", "" + dataList.get(i));
                fragment.setArguments(args);
                fragmentmanager = activity.getSupportFragmentManager();
                fragmentTransaction = fragmentmanager.beginTransaction();
                fragmentTransaction.addToBackStack(fragment.getTag());
                fragmentTransaction.replace(R.id.fragment_layout, fragment);
                fragmentTransaction.commit();
            }
        });
    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView img;

        public ViewHolder(View itemview) {
            super(itemview);
            name = (TextView) itemview.findViewById(R.id.txservice);
            img = (ImageView) itemview.findViewById(R.id.imagevu);
        }
    }
}
