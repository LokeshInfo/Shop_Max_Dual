package com.icss.shopmax.Sub_Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.icss.shopmax.API_Retro.BaseUrl;
import com.icss.shopmax.A_Model.Grocery_Product_Data;
import com.icss.shopmax.Model.Grocery_data;
import com.icss.shopmax.Model.Sale_Data;
import com.icss.shopmax.R;

import java.util.ArrayList;
import java.util.List;

public class Sub_Grocery_Adapter  extends RecyclerView.Adapter<Sub_Grocery_Adapter.ViewHolder>
{
    List<Grocery_Product_Data> dlist;
    Activity activity;

    public Sub_Grocery_Adapter(Activity activity, List<Grocery_Product_Data> listd){
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
    public Sub_Grocery_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_sub_grocery,parent,false);
        return new Sub_Grocery_Adapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final Sub_Grocery_Adapter.ViewHolder holder,final int i) {

        if (holder!=null){

            holder.name.setText(dlist.get(i).getName());
            holder.price.setText(dlist.get(i).getPrice()+" /-");
            holder.unit.setText(""+dlist.get(i).getUnit_quantity()+" "+dlist.get(i).getUnit()+", ");

            Glide.with(activity).load(BaseUrl.image_grocery_products+dlist.get(i).getBanner()).into(holder.product_image);

            holder.add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int num = Integer.parseInt(holder.num_qty.getText().toString()) + 1;
                        holder.num_qty.setText(""+num);
                }
            });


            holder.remove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int num = Integer.parseInt(holder.num_qty.getText().toString());
                    if (num<=1){}
                    else{
                        int minus = num-1;
                        holder.num_qty.setText(""+minus);
                    }
                }
            });

            holder.addcart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    holder.addcart.setText("Added");
                }
            });
            

        }

    }


    @Override
    public int getItemCount() {
        return dlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView name, price, unit, num_qty;
        ImageView img1, add , remove, product_image;
        Button addcart;
        Spinner area_spin;

        public ViewHolder(View itemview){
            super(itemview);
            name = itemview.findViewById(R.id.pd_name);
            price = itemview.findViewById(R.id.pd_price);
            unit = itemview.findViewById(R.id.pd_unit);
            img1 = itemview.findViewById(R.id.pdimage);
            num_qty = itemview.findViewById(R.id.qty_item);
            add = itemview.findViewById(R.id.add_item);
            remove = itemview.findViewById(R.id.remove_item);
            addcart = itemview.findViewById(R.id.addtocart);
            area_spin = itemview.findViewById(R.id.area_spin);
            product_image = itemview.findViewById(R.id.pdimage);
        }
    }

}
