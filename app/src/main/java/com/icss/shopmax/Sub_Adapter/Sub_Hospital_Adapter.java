package com.icss.shopmax.Sub_Adapter;

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
import com.icss.shopmax.API_Retro.BaseUrl;
import com.icss.shopmax.A_Model.Doctor_data;
import com.icss.shopmax.Model.Hospital_Data;
import com.icss.shopmax.R;
import com.icss.shopmax.ui.Sub_Category.Patient_Details_Fragment;
import com.icss.shopmax.ui.Sub_Category.Sub_Sale_fragment;

import java.util.ArrayList;
import java.util.List;

public class Sub_Hospital_Adapter extends RecyclerView.Adapter<Sub_Hospital_Adapter.ViewHolder>
{
    List<Doctor_data> dlist;
    Activity activity;

    public Sub_Hospital_Adapter(Activity activity, List<Doctor_data> listd){
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
    public Sub_Hospital_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_sub_hospital,parent,false);
        return new Sub_Hospital_Adapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Sub_Hospital_Adapter.ViewHolder holder, final int i) {

        if (holder!=null){

            //holder.hospital.setText(dlist.get(i).get());
            holder.name.setText(dlist.get(i).getDoctor_name());
            holder.price.setText("Fees Rs. "+dlist.get(i).getFees()+"/-");
            holder.description.setText(dlist.get(i).getSpecialist());
            Glide.with(activity).load(BaseUrl.image_doctor +dlist.get(i).getImage()).into(holder.profileImage);

            holder.book.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AppCompatActivity activ = (AppCompatActivity) v.getContext();
                    Fragment fragment = new Patient_Details_Fragment();
                    Bundle args = new Bundle();
                    args.putString("h_id",dlist.get(i).getHospital_id());
                    args.putString("d_id",dlist.get(i).getDoctor_id());
                    FragmentManager fragmentmanager =activ.getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction =fragmentmanager.beginTransaction();
                    fragmentTransaction.addToBackStack(fragment.getTag());
                    fragmentTransaction.replace(R.id.fragment_layout,fragment);
                    fragmentTransaction.commit();
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
        TextView hospital,name, price, description,book;
        ImageView profileImage;

        public ViewHolder(View itemview){
            super(itemview);
            hospital = itemview.findViewById(R.id.hospital_name);
            name = itemview.findViewById(R.id.doc_name);
            price = itemview.findViewById(R.id.doc_fees);
            description = itemview.findViewById(R.id.doc_desc);
            book = itemview.findViewById(R.id.buttn_book);
            profileImage = itemview.findViewById(R.id.profileImage);
        }
    }


}
