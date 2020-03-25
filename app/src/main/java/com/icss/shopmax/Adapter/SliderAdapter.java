package com.icss.shopmax.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.icss.shopmax.API_Retro.BaseUrl;
import com.icss.shopmax.Model.Slider_Data;
import com.icss.shopmax.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.List;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderAdapterVH> {

    List<Slider_Data> dataList;
    Activity context;

    public SliderAdapter(Activity context, List<Slider_Data> dlist) {
        this.context = context;
        this.dataList = dlist;
    }

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.sliding_page, null);
        return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, int i) {

        if (viewHolder!=null) {
            Glide.with(context).load(BaseUrl.BaseImg+""+dataList.get(i).getImage()).into(viewHolder.imageview);
        }
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {

        public ImageView imageGifContainer;
        View itemView;
            ImageView imageview;
           // TextView textview;

            public SliderAdapterVH(View itemView) {
                super(itemView);
                imageview = itemView.findViewById(R.id.imageview);
              //  textview = itemView.findViewById(R.id.textview);
                this.itemView = itemView;
            }
        }
    }
