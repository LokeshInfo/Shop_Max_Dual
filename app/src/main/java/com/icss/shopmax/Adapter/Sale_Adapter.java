package com.icss.shopmax.Adapter;

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
import com.icss.shopmax.Model.Sale_Data;
import com.icss.shopmax.Model.Slider_Data;
import com.icss.shopmax.R;
import com.icss.shopmax.ui.Services.Cleaning_Services;
import com.icss.shopmax.ui.Sub_Category.Sub_Sale_fragment;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class Sale_Adapter extends RecyclerView.Adapter<Sale_Adapter.ViewHolder>
{
    List<com.icss.shopmax.A_Model.Sale_Data> dlist;
    Activity activity;
    List<Slider_Data> image_list;
    SliderAdapter slide_adapter;

    public Sale_Adapter(Activity activity, List<com.icss.shopmax.A_Model.Sale_Data> listd){
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
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_sale,parent,false);
        return new Sale_Adapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,final int i) {

        if (holder!=null){

            holder.name.setText(dlist.get(i).getName());
            holder.price.setText(dlist.get(i).getPrice_from()+" /-   To      "+dlist.get(i).getPrice_to()+" /-" );
            holder.description.setText(dlist.get(i).getDescription());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        AppCompatActivity activ = (AppCompatActivity) v.getContext();
                        Fragment fragment = new Sub_Sale_fragment();
                        Bundle args = new Bundle();
                        args.putString("cat_id",dlist.get(i).getId());
                        args.putString("cat_name",dlist.get(i).getName());
                        fragment.setArguments(args);
                        FragmentManager fragmentmanager =activ.getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction =fragmentmanager.beginTransaction();
                        fragmentTransaction.addToBackStack(fragment.getTag());
                        fragmentTransaction.replace(R.id.fragment_layout,fragment);
                        fragmentTransaction.commit();
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

        public ViewHolder(View itemview){
            super(itemview);
            name = itemview.findViewById(R.id.tx_salename);
            price = itemview.findViewById(R.id.tx_saleamt);
            description = itemview.findViewById(R.id.tx_saledesc);
            sliderView = itemview.findViewById(R.id.jimageSlider);
        }
    }

}
