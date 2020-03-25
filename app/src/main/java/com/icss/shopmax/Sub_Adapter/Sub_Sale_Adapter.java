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
import com.icss.shopmax.A_Model.Sale_Sub_Data;
import com.icss.shopmax.Adapter.Sale_Adapter;
import com.icss.shopmax.Adapter.SliderAdapter;
import com.icss.shopmax.Model.Sale_Data;
import com.icss.shopmax.Model.Slider_Data;
import com.icss.shopmax.R;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class Sub_Sale_Adapter  extends RecyclerView.Adapter<Sub_Sale_Adapter.ViewHolder>
{
    List<Sale_Sub_Data> dlist;
    Activity activity;
    List<Slider_Data> image_list;
    SliderAdapter slide_adapter;

    public Sub_Sale_Adapter(Activity activity, List<Sale_Sub_Data> listd){
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
    public Sub_Sale_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_sub_sale,parent,false);
        return new Sub_Sale_Adapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final Sub_Sale_Adapter.ViewHolder holder, int i) {

        if (holder!=null){

            holder.name.setText(dlist.get(i).getName());
            holder.price.setText(dlist.get(i).getPrice()+" /-");
            holder.description.setText(dlist.get(i).getDescription());

            holder.addcart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    holder.addcart.setText("Added");
                }
            });

            image_list = new ArrayList<>();
            if (!dlist.get(i).getImage1().matches("")){
                image_list.add(new Slider_Data("",""+dlist.get(i).getImage1(),""));
            } if (!dlist.get(i).getImage2().matches("")){
                image_list.add(new Slider_Data("",""+dlist.get(i).getImage2(),""));
            }  if (!dlist.get(i).getImage3().matches("")){
                image_list.add(new Slider_Data("",""+dlist.get(i).getImage3(),""));
            } if (!dlist.get(i).getImage4().matches("")){
                image_list.add(new Slider_Data("",""+dlist.get(i).getImage4(),""));
            }  if (!dlist.get(i).getImage5().matches("")){
                image_list.add(new Slider_Data("",""+dlist.get(i).getImage5(),""));
            }

            slide_adapter = new SliderAdapter(activity,image_list);
            holder.sliderView.setSliderAdapter(slide_adapter);

        }

    }


    @Override
    public int getItemCount() {
        return dlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView name, price, description;
        SliderView sliderView;
        Button addcart;

        public ViewHolder(View itemview){
            super(itemview);
            name = itemview.findViewById(R.id.tx_salename);
            price = itemview.findViewById(R.id.tx_saleamt);
            description = itemview.findViewById(R.id.tx_saledesc);
            sliderView = itemview.findViewById(R.id.jimageSlider);
            addcart = itemview.findViewById(R.id.adtocart);
        }
    }

}
