package com.icss.shopmax.d_Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.icss.shopmax.Model.Chef_Model;
import com.icss.shopmax.R;

import java.util.ArrayList;

public class Chef_Adapter extends RecyclerView.Adapter<Chef_Adapter.ViewHolder>
{
    ArrayList<Chef_Model> dataList;
    CardView card;
    Activity mactivity;

    public Chef_Adapter(Activity mactivity, ArrayList<Chef_Model> dataList)
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
    public Chef_Adapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_chef,viewGroup,false);
        return new Chef_Adapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final Chef_Adapter.ViewHolder viewHolder,final int i) {
        if (viewHolder!=null)
        {
            final Chef_Model dob = dataList.get(i);


            viewHolder.name.setText(dob.getName());
            Glide.with(mactivity).load(dob.getImage()).into(viewHolder.img);

            viewHolder.card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AppCompatActivity activ = (AppCompatActivity) v.getContext();
                    Fragment fragment = new Sub_chef_customer_service();
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
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView name;
        ImageView img;
        CardView card;

        public ViewHolder(View itemview)
        {
            super(itemview);
            name = (TextView) itemview.findViewById(R.id.txservice);
            img = (ImageView) itemview.findViewById(R.id.imagevu);
            card=(CardView)itemview.findViewById(R.id.item);

        }
    }
}
