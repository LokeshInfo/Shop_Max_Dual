package com.icss.shopmax.Sub_Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.icss.shopmax.Model.Grocery_data;
import com.icss.shopmax.R;

import java.util.ArrayList;

public class Sub_Add_Grocery_Adapter  extends RecyclerView.Adapter<Sub_Add_Grocery_Adapter.ViewHolder>
{
    ArrayList<String> dlist;
    Activity activity;

    public Sub_Add_Grocery_Adapter(Activity activity, ArrayList<String> listd){
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
    public Sub_Add_Grocery_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_add_subgrocery,parent,false);
        return new Sub_Add_Grocery_Adapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final Sub_Add_Grocery_Adapter.ViewHolder holder,final int i) {

        if (holder!=null) {
            int nm = i+1;
            holder.name.setText(nm+".   "+dlist.get(i));
        }

    }


    @Override
    public int getItemCount() {
        return dlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView name;

        public ViewHolder(View itemview){
            super(itemview);
            name = itemview.findViewById(R.id.product_namee);
        }
    }

    public void add_item(String data)
    {
        dlist.add(data);
        notifyDataSetChanged();
    }

}
