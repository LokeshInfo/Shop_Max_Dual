package com.icss.shopmax.d_Adapter;

import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.icss.shopmax.Model.Professional_Writer_Data;
import com.icss.shopmax.Model.Slider_Data;
import com.icss.shopmax.R;
import com.icss.shopmax.All_Services_Class.Services.Fragment_Bill;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class Professional_Writer_Adapter extends RecyclerView.Adapter<Professional_Writer_Adapter.ViewHolder>
{
    ArrayList<Professional_Writer_Data> dlist;
    Activity activity;
    SliderAdapter slide_adapter;
    List<Slider_Data> image_list;

    public Professional_Writer_Adapter(Activity activity, ArrayList<Professional_Writer_Data> listd){
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
    public Professional_Writer_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_professional_writer,parent,false);
        return new Professional_Writer_Adapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Professional_Writer_Adapter.ViewHolder holder, final int i) {

        if (holder!=null){

            holder.name.setText(dlist.get(i).getName());

            holder.hire.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        AppCompatActivity activ = (AppCompatActivity) v.getContext();
                        Fragment fragment = new Fragment_Bill();
                        FragmentManager fragmentmanager =activ.getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction =fragmentmanager.beginTransaction();
                        fragmentTransaction.addToBackStack(fragment.getTag());
                        fragmentTransaction.replace(R.id.fragment_layout,fragment);
                        fragmentTransaction.commit();
                    }
            });

           holder.preview.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   image_list = new ArrayList<>();
                   for (int a=0 ;a<dlist.get(i).getImage().length ; a++){
                       image_list.add(new Slider_Data("",""+dlist.get(i).getImage()[a],""));
                   }
                   show_dilog(image_list);
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
        TextView name, preview;
        TextView hire;

        public ViewHolder(View itemview){
            super(itemview);
            name = itemview.findViewById(R.id.wrname);
            preview = itemview.findViewById(R.id.wr_info);
            hire = itemview.findViewById(R.id.buttn_hire);
        }
    }

    private void show_dilog(List<Slider_Data> ddlist)
    {
        final Dialog dialogView = new Dialog(activity);
        dialogView.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialogView.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogView.setContentView(R.layout.dialog_writer);

        Window window = dialogView.getWindow();
        window.setLayout(WindowManager.LayoutParams.FILL_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);

        SliderView sliderView = dialogView.findViewById(R.id.wrimageSlider);
        ImageView imgclose = dialogView.findViewById(R.id.img_close);

        slide_adapter = new SliderAdapter(activity,ddlist);
        sliderView.setSliderAdapter(slide_adapter);
        imgclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {      dialogView.dismiss(); }       });

        dialogView.show();
        dialogView.setCanceledOnTouchOutside(true);
    }


}
