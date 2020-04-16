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
import com.icss.shopmax.d_Adapter.SliderAdapter;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.List;

public class Slider_Adapter extends SliderViewAdapter<Slider_Adapter.SliderAdapterVH> {

    List<Slider_Data> dataList;
    Activity context;
    String img_url;

    public Slider_Adapter(Activity context, List<Slider_Data> dlist, String img_url) {
        this.context = context;
        this.dataList = dlist;
        this.img_url = img_url;
    }

    @Override
    public Slider_Adapter.SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.sliding_page, null);
        return new Slider_Adapter.SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(Slider_Adapter.SliderAdapterVH viewHolder, int i) {

        if (viewHolder!=null) {
            Glide.with(context).load(img_url+""+dataList.get(i).getImage()).into(viewHolder.imageview);
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
