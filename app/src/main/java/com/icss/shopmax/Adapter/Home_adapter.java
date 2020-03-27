package com.icss.shopmax.Adapter;

import android.app.Activity;
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
import com.icss.shopmax.A_Model.Services_data;
import com.icss.shopmax.Model.data_model;
import com.icss.shopmax.R;
import com.icss.shopmax.ui.Services.Cake_Order_Fragment;
import com.icss.shopmax.ui.Services.Chef_fragment;
import com.icss.shopmax.ui.Services.Cleaning_Services;
import com.icss.shopmax.ui.Services.Food_Order_Fragment;
import com.icss.shopmax.ui.Services.Gas_Cylinder_fragment;
import com.icss.shopmax.ui.Services.Grocery_Fragment;
import com.icss.shopmax.ui.Services.Hospital_fragment;
import com.icss.shopmax.ui.Services.Hotel_Fragment;
import com.icss.shopmax.ui.Services.IT_services_fragment;
import com.icss.shopmax.ui.Services.Other_Services_Fragment;
import com.icss.shopmax.ui.Services.Pest_Control_Fragment;
import com.icss.shopmax.ui.Services.Photographer_Fragment;
import com.icss.shopmax.ui.Services.Professional_writer_fragment;
import com.icss.shopmax.ui.Services.RentCar_fragment;
import com.icss.shopmax.ui.Services.Sale_Fragment;
import com.icss.shopmax.ui.Services.Technical_Support_fragment;
import com.icss.shopmax.ui.Services.Travel_Agent_Fragment;
import com.icss.shopmax.ui.Services.classfieds_fragment;

import java.util.ArrayList;
import java.util.List;

public class Home_adapter extends RecyclerView.Adapter<Home_adapter.ViewHolder>
{
    List<Services_data> dataList;
    Activity mactivity;

    public Home_adapter(Activity mactivity, List<Services_data> dataList)
    {
        this.mactivity=mactivity;
        this.dataList=dataList;
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
    public Home_adapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_services,viewGroup,false);
        return new Home_adapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(Home_adapter.ViewHolder viewHolder, int i) {
        if (viewHolder!=null)
        {
           final Services_data dob = dataList.get(i);

           viewHolder.name.setText(dob.getService_name());
            Glide.with(mactivity).load(BaseUrl.image_services +dob.getBanner()).into(viewHolder.img);

            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Fragment fragment;
                   FragmentManager fragmentmanager;
                   FragmentTransaction fragmentTransaction;
                   AppCompatActivity activity = (AppCompatActivity) v.getContext();
                   String nm = dob.getService_id();
                   switch (nm)                  
                   {
                       case "Cleaning Services":
                           fragment = new Cleaning_Services();
                           fragmentmanager =activity.getSupportFragmentManager();
                           fragmentTransaction =fragmentmanager.beginTransaction();
                           fragmentTransaction.addToBackStack(fragment.getTag());
                           fragmentTransaction.replace(R.id.fragment_layout,fragment);
                           fragmentTransaction.commit();
                           break;


                       case "Hotel Booking":
                           fragment = new Hotel_Fragment();
                           fragmentmanager =activity.getSupportFragmentManager();
                           fragmentTransaction =fragmentmanager.beginTransaction();
                           fragmentTransaction.addToBackStack(fragment.getTag());
                           fragmentTransaction.replace(R.id.fragment_layout,fragment);
                           fragmentTransaction.commit();
                           break;

                       case "Grocery Orders\n & delivery":
                           fragment = new Grocery_Fragment();
                           fragmentmanager =activity.getSupportFragmentManager();
                           fragmentTransaction =fragmentmanager.beginTransaction();
                           fragmentTransaction.addToBackStack(fragment.getTag());
                           fragmentTransaction.replace(R.id.fragment_layout,fragment);
                           fragmentTransaction.commit();
                           break;

                       case "Cake Order &\n Homely Food":
                           fragment = new Cake_Order_Fragment();
                           fragmentmanager =activity.getSupportFragmentManager();
                           fragmentTransaction =fragmentmanager.beginTransaction();
                           fragmentTransaction.addToBackStack(fragment.getTag());
                           fragmentTransaction.replace(R.id.fragment_layout,fragment);
                           fragmentTransaction.commit();
                           break;

                       case "Food Orders\n & delivery":
                           fragment = new Food_Order_Fragment();
                           fragmentmanager =activity.getSupportFragmentManager();
                           fragmentTransaction =fragmentmanager.beginTransaction();
                           fragmentTransaction.addToBackStack(fragment.getTag());
                           fragmentTransaction.replace(R.id.fragment_layout,fragment);
                           fragmentTransaction.commit();
                           break;

                       case "SALE":
                           fragment = new Sale_Fragment();
                           fragmentmanager =activity.getSupportFragmentManager();
                           fragmentTransaction =fragmentmanager.beginTransaction();
                           fragmentTransaction.addToBackStack(fragment.getTag());
                           fragmentTransaction.replace(R.id.fragment_layout,fragment);
                           fragmentTransaction.commit();
                           break;

                       case "Technical Support":
                           fragment = new Technical_Support_fragment();
                           fragmentmanager =activity.getSupportFragmentManager();
                           fragmentTransaction =fragmentmanager.beginTransaction();
                           fragmentTransaction.addToBackStack(fragment.getTag());
                           fragmentTransaction.replace(R.id.fragment_layout,fragment);
                           fragmentTransaction.commit();
                           break;

                       case "Professional\n CV writers":
                           fragment = new Professional_writer_fragment();
                           fragmentmanager =activity.getSupportFragmentManager();
                           fragmentTransaction =fragmentmanager.beginTransaction();
                           fragmentTransaction.addToBackStack(fragment.getTag());
                           fragmentTransaction.replace(R.id.fragment_layout,fragment);
                           fragmentTransaction.commit();
                           break;

                       case "Rent A Car":
                           fragment = new RentCar_fragment();
                           fragmentmanager =activity.getSupportFragmentManager();
                           fragmentTransaction =fragmentmanager.beginTransaction();
                           fragmentTransaction.addToBackStack(fragment.getTag());
                           fragmentTransaction.replace(R.id.fragment_layout,fragment);
                           fragmentTransaction.commit();
                           break;

                       case "Pest \n Control":
                           fragment = new Pest_Control_Fragment();
                           fragmentmanager =activity.getSupportFragmentManager();
                           fragmentTransaction =fragmentmanager.beginTransaction();
                           fragmentTransaction.addToBackStack(fragment.getTag());
                           fragmentTransaction.replace(R.id.fragment_layout,fragment);
                           fragmentTransaction.commit();
                           break;

                       case "Chef at\n Home":
                           fragment = new Chef_fragment();
                           fragmentmanager =activity.getSupportFragmentManager();
                           fragmentTransaction =fragmentmanager.beginTransaction();
                           fragmentTransaction.addToBackStack(fragment.getTag());
                           fragmentTransaction.replace(R.id.fragment_layout,fragment);
                           fragmentTransaction.commit();
                           break;

                       case "3":
                           fragment = new Hospital_fragment();
                           fragmentmanager =activity.getSupportFragmentManager();
                           fragmentTransaction =fragmentmanager.beginTransaction();
                           fragmentTransaction.addToBackStack(fragment.getTag());
                           fragmentTransaction.replace(R.id.fragment_layout,fragment);
                           fragmentTransaction.commit();
                           break;

                       case "IT Services":
                           fragment = new IT_services_fragment();
                           fragmentmanager =activity.getSupportFragmentManager();
                           fragmentTransaction =fragmentmanager.beginTransaction();
                           fragmentTransaction.addToBackStack(fragment.getTag());
                           fragmentTransaction.replace(R.id.fragment_layout,fragment);
                           fragmentTransaction.commit();
                           break;

                       case "Photographer":
                           fragment = new Photographer_Fragment();
                           fragmentmanager =activity.getSupportFragmentManager();
                           fragmentTransaction =fragmentmanager.beginTransaction();
                           fragmentTransaction.addToBackStack(fragment.getTag());
                           fragmentTransaction.replace(R.id.fragment_layout,fragment);
                           fragmentTransaction.commit();
                           break;

                       case "Gas Cylinder\n Delivery":
                           fragment = new Gas_Cylinder_fragment();
                           fragmentmanager =activity.getSupportFragmentManager();
                           fragmentTransaction =fragmentmanager.beginTransaction();
                           fragmentTransaction.addToBackStack(fragment.getTag());
                           fragmentTransaction.replace(R.id.fragment_layout,fragment);
                           fragmentTransaction.commit();
                           break;

                       case "Other Services":
                           fragment = new Other_Services_Fragment();
                           fragmentmanager =activity.getSupportFragmentManager();
                           fragmentTransaction =fragmentmanager.beginTransaction();
                           fragmentTransaction.addToBackStack(fragment.getTag());
                           fragmentTransaction.replace(R.id.fragment_layout,fragment);
                           fragmentTransaction.commit();
                           break;

                       case "Travel Agent":
                           fragment = new Travel_Agent_Fragment();
                           fragmentmanager =activity.getSupportFragmentManager();
                           fragmentTransaction =fragmentmanager.beginTransaction();
                           fragmentTransaction.addToBackStack(fragment.getTag());
                           fragmentTransaction.replace(R.id.fragment_layout,fragment);
                           fragmentTransaction.commit();
                           break;

                       case "Classfieds":
                           fragment=new classfieds_fragment();
                           fragmentmanager =activity.getSupportFragmentManager();
                           fragmentTransaction =fragmentmanager.beginTransaction();
                           fragmentTransaction.addToBackStack(fragment.getTag());
                           fragmentTransaction.replace(R.id.fragment_layout,fragment);
                           fragmentTransaction.commit();
                           break;
                   }

               }
           });
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView name;
        ImageView img;

        public ViewHolder(View itemview)
        {
            super(itemview);
            name = (TextView) itemview.findViewById(R.id.txservice);
            img = (ImageView) itemview.findViewById(R.id.imagevu);
        }
    }


}
