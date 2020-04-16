package com.icss.shopmax.d_Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.chuross.library.ExpandableLayout;
import com.icss.shopmax.Model.classfieds_Data;
import com.icss.shopmax.R;

import java.util.ArrayList;
import java.util.List;

public class classfieds_browse_adapter extends RecyclerView.Adapter<classfieds_browse_adapter.ViewHolder> {

    ArrayList<classfieds_Data> dlist;
    Activity activity;
    vehicle_list_adapter list_adapter;
    List<vehicle_list_Data> ddlist;

    public classfieds_browse_adapter(Activity activity, ArrayList<classfieds_Data> listd){
        this.activity = activity;
        this.dlist = listd;
        setHasStableIds(true);
    }

    @NonNull
    @Override
    public classfieds_browse_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_quickbrowse,parent,false);
        return new classfieds_browse_adapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final classfieds_browse_adapter.ViewHolder holder, int position) {

        preData();
        holder.tx.setText(dlist.get(position).getName());

        list_adapter = new vehicle_list_adapter(activity,ddlist);
        LinearLayoutManager ll = new LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false);
        holder.recyclerView2.setLayoutManager(ll);
        holder.recyclerView2.setAdapter(list_adapter);

        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.expandableLayout.isExpanded())
                holder.expandableLayout.collapse();

                else
                    holder.expandableLayout.expand();
            }
        });

        holder.tx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.expandableLayout.isExpanded())
                    holder.expandableLayout.collapse();

                else
                    holder.expandableLayout.expand();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView tx;
        ImageView img;
        ExpandableLayout expandableLayout;
        LinearLayout layout2;
        RecyclerView recyclerView2;

        public ViewHolder(View itemview){
            super(itemview);
            tx= itemview.findViewById(R.id.tv1);
            img= itemview.findViewById(R.id.img1);
            expandableLayout= itemview.findViewById(R.id.expandableLayout);
            recyclerView2 = itemview.findViewById(R.id.classfieds_recycler_view2);
        }
    }
    private void preData()
    {
        ddlist = new ArrayList<>();

        ddlist.add(new vehicle_list_Data("Car/Sedan","212"));
        ddlist.add(new vehicle_list_Data("4*4/SUV","212"));
        ddlist.add(new vehicle_list_Data("Car Parts & Accessories","212"));
        ddlist.add(new vehicle_list_Data("Commercial vehicle","212"));
        ddlist.add(new vehicle_list_Data("Car plate number","212"));
        ddlist.add(new vehicle_list_Data("motorbike","212"));
        ddlist.add(new vehicle_list_Data("Car rentals","212"));
    }


}
