package com.icss.shopmax.Adapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.icss.shopmax.API_Retro.BaseUrl;
import com.icss.shopmax.A_Model.Grocery_Data;
import com.icss.shopmax.All_Services_Class.Sub_Category.Sub_Grocery_Fragment;
import com.icss.shopmax.Model.Slider_Data;
import com.icss.shopmax.R;
import com.icss.shopmax.All_Services_Class.Sub_Category.Sub_Sale_fragment;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class Grocery_Adapter extends RecyclerView.Adapter<Grocery_Adapter.ViewHolder>
{
    List<Grocery_Data> dlist;
    Activity activity;
    List<Slider_Data> image_list;
    Slider_Adapter slide_adapter;

    public Grocery_Adapter(Activity activity, List<com.icss.shopmax.A_Model.Grocery_Data> listd){
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
    public Grocery_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_grocery_cat,parent,false);
        return new Grocery_Adapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Grocery_Adapter.ViewHolder holder, final int i) {

        if (holder!=null){

            holder.name.setText(""+dlist.get(i).getGrocery_cat_name());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AppCompatActivity activ = (AppCompatActivity) v.getContext();
                    Fragment fragment = new Sub_Grocery_Fragment();
                    Bundle args = new Bundle();
                    args.putString("cat_id",dlist.get(i).getGrocery_cat_id());
                    args.putString("cat_name",dlist.get(i).getGrocery_cat_name());
                    fragment.setArguments(args);
                    FragmentManager fragmentmanager =activ.getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction =fragmentmanager.beginTransaction();
                    fragmentTransaction.addToBackStack(fragment.getTag());
                    fragmentTransaction.replace(R.id.fragment_layout,fragment);
                    fragmentTransaction.commit();
                }
            });

            image_list = new ArrayList<>();
            if (!dlist.get(i).getBanner1().matches("")){
                image_list.add(new Slider_Data("",""+dlist.get(i).getBanner1(),""));
            } if (!dlist.get(i).getBanner2().matches("")){
                image_list.add(new Slider_Data("",""+dlist.get(i).getBanner2(),""));
            }  if (!dlist.get(i).getBanner3().matches("")){
                image_list.add(new Slider_Data("",""+dlist.get(i).getBanner3(),""));
            }

            slide_adapter = new Slider_Adapter(activity,image_list, BaseUrl.image_grocery);
            holder.sliderView.setSliderAdapter(slide_adapter);

        }

    }


    @Override
    public int getItemCount() {
        return dlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView name;
        SliderView sliderView;

        public ViewHolder(View itemview){
            super(itemview);
            name = itemview.findViewById(R.id.tx_gcat);
            sliderView = itemview.findViewById(R.id.jimageSlider);
        }
    }
}
