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
import com.icss.shopmax.Model.Grocery_data;
import com.icss.shopmax.Model.Sale_Data;
import com.icss.shopmax.R;

import java.util.ArrayList;

public class Sub_Grocery_Adapter  extends RecyclerView.Adapter<Sub_Grocery_Adapter.ViewHolder>
{
    ArrayList<Grocery_data> dlist;
    Activity activity;

    public Sub_Grocery_Adapter(Activity activity, ArrayList<Grocery_data> listd){
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
            holder.num_qty.setText(""+dlist.get(i).getQty());
            holder.unit.setText(""+dlist.get(i).getUnit());

            String u1 = "data:image/jpeg;base64,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";
            String u2 = "https://gourmetdelight.in/image/cache/catalog/pdp/organicpotatoes-600x600.jpg";
            String u3 = "https://rukminim1.flixcart.com/image/352/352/j8rnpu80/pulses/p/4/h/500-kabuli-channa-kabuli-chana-un-branded-original-imaeymjkvdpwppa6.jpeg?q=70";
            String u4 = "https://images-na.ssl-images-amazon.com/images/I/61JrHlMHF3L._SX569_.jpg";
            String g1 = "https://hellenicgrocery.co.uk/wp-content/uploads/2019/04/85.jpg" ;     // rice
            String g2 = "https://5.imimg.com/data5/IQ/ST/MY-55300537/wheat-flour-500x500.jpg" ; // wheat


            if (i==0) {
                Glide.with(activity).load(u1).into(holder.img1);
            }

            if (i==1) {
                Glide.with(activity).load(u2).into(holder.img1);
            }
            else if(i==2){
                Glide.with(activity).load(u3).into(holder.img1);
            }
            else if(i==3){
                Glide.with(activity).load(u4).into(holder.img1);
            }
            else if (i==4){
                Glide.with(activity).load(g1).into(holder.img1);
            }
            else if (i==5){
                Glide.with(activity).load(g2).into(holder.img1);
            }

            holder.add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int num = dlist.get(i).getQty();
                        dlist.get(i).setQty(num+1);
                        notifyDataSetChanged();
                }
            });


            holder.remove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int num = dlist.get(i).getQty();
                    if (num<=1){}
                    else{
                        int minus = num-1;
                        dlist.get(i).setQty(minus);
                        notifyDataSetChanged();
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
        ImageView img1, add , remove;
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
        }
    }

}
