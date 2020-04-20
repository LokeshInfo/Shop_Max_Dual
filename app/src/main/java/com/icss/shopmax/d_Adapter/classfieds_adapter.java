package com.icss.shopmax.d_Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.icss.shopmax.API_Retro.BaseUrl;
import com.icss.shopmax.A_Model.Classified;
import com.icss.shopmax.R;

import java.util.List;

public class classfieds_adapter extends RecyclerView.Adapter<classfieds_adapter.ViewHolder> {
    List<Classified> dlist;
    Activity activity;

    public classfieds_adapter(Activity activity, List<Classified> listd) {
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

    @Override
    public int getItemCount() {
        return dlist.size();
    }


    @NonNull
    @Override

    public classfieds_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_classfieds, parent, false);
        return new classfieds_adapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Classified classified = dlist.get(position);
        holder.tx.setText(classified.getSubServiceName());
        Glide.with(activity).load(BaseUrl.getClassifiedImg + classified.getBanner()).into(holder.img);

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activ = (AppCompatActivity) v.getContext();
                Fragment fragment = new vehicle_fragment();
                FragmentManager fragmentmanager = activ.getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentmanager.beginTransaction();
                fragmentTransaction.addToBackStack(fragment.getTag());
                fragmentTransaction.replace(R.id.fragment_layout, fragment);
                fragmentTransaction.commit();

            }
        });
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tx;
        ImageView img;
        LinearLayout layout;

        public ViewHolder(View itemview) {
            super(itemview);
            tx = itemview.findViewById(R.id.tv1);
            img = itemview.findViewById(R.id.img1);
            layout = itemview.findViewById(R.id.layout);

        }
    }

}
