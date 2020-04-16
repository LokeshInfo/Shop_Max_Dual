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
import com.icss.shopmax.R;
import com.icss.shopmax.ui.Sub_Category.Tab_Food_Order_Fragment;

import java.util.ArrayList;

public class Food_Order_Adapter extends RecyclerView.Adapter<Food_Order_Adapter.ViewHolder>
{
    ArrayList<String> dataList;
    Activity mactivity;

    public Food_Order_Adapter(Activity mactivity, ArrayList<String> dataList)
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
    public Food_Order_Adapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_services,viewGroup,false);
        return new Food_Order_Adapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(Food_Order_Adapter.ViewHolder viewHolder,final int i) {
        if (viewHolder!=null)
        {
            viewHolder.name.setText(dataList.get(i));

            //viewHolder.img.setImageResource(dob.getImage());

            String i1 = "https://www.intelligenthq.com/wp-content/uploads/2019/08/restaurant.jpg";
            String i2 = "https://fastly.4sqi.net/img/general/600x600/38308928_cNLsFF2u7NTXbJZXwjJg75WnIxUFPqd6t6y0zPtLwh0.jpg";
            String i3 = "https://freedesignfile.com/upload/2016/12/Tasty-Chinese-Food-HD-picture-03.jpg";
            String i4 = "https://i.pinimg.com/originals/22/0e/2c/220e2cb270e24151c2b3e2f55d999d5b.jpg";
            String i5 = "data:image/jpeg;base64,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";
            String i6 = "https://cdn.vox-cdn.com/thumbor/73nhsZwI55BVgH8-rapmIhkvbUk=/0x0:4047x3035/1200x675/filters:focal(1700x1194:2346x1840)/cdn.vox-cdn.com/uploads/chorus_image/image/64046617/20150915-_Upland_Burger_3.0.0.1489236245.0.jpg";
            String i7 = "https://media.istockphoto.com/photos/snacks-fast-food-concept-eatting-at-work-place-fresh-club-sandwich-picture-id1143308647";
            String i8 = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTCsB9kBGp0jGsDEnS3joJMKqAgIWtoSEdXootWDbsha430yDcC&s";
            String i9 = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTx8pjwrjQg5XR3YBDGH2B-QpJbOm9lRom8x8jhtzrk9lvI982w&s";


            if (i==0){
                Glide.with(mactivity).load(i1).into(viewHolder.img); }
            else if(i==1){
                Glide.with(mactivity).load(i2).into(viewHolder.img); }
            else if(i==2){
                Glide.with(mactivity).load(i3).into(viewHolder.img); }
            else if(i==3){
                Glide.with(mactivity).load(i4).into(viewHolder.img); }
            else if(i==4){
                Glide.with(mactivity).load(i5).into(viewHolder.img); }
            else if(i==5){
                Glide.with(mactivity).load(i6).into(viewHolder.img); }
            else if(i==6){
                Glide.with(mactivity).load(i7).into(viewHolder.img); }
            else if(i==7){
                Glide.with(mactivity).load(i8).into(viewHolder.img); }
            else if(i==8){
                Glide.with(mactivity).load(i9).into(viewHolder.img); }


            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Fragment fragment;
                    FragmentManager fragmentmanager;
                    FragmentTransaction fragmentTransaction;
                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                            Bundle args = new Bundle();
                            fragment = new Tab_Food_Order_Fragment();
                            args.putString("rname",""+dataList.get(i));
                            fragment.setArguments(args);
                            fragmentmanager =activity.getSupportFragmentManager();
                            fragmentTransaction =fragmentmanager.beginTransaction();
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

        public ViewHolder(View itemview)
        {
            super(itemview);
            name = (TextView) itemview.findViewById(R.id.txservice);
            img = (ImageView) itemview.findViewById(R.id.imagevu);
        }
    }
}
