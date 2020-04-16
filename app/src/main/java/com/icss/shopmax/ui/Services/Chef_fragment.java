package com.icss.shopmax.ui.Services;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.icss.shopmax.d_Adapter.Chef_Adapter;
import com.icss.shopmax.Model.Chef_Model;
import com.icss.shopmax.R;
import com.icss.shopmax.ui.MainActivity;

import java.util.ArrayList;

public class Chef_fragment extends Fragment
{
    RecyclerView recyclerView;
    Button book;
    ArrayList<Chef_Model> cflist;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_chef,container,false);
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).onBackPressed();
            }
        });

        book = view.findViewById(R.id.chef_book);
        recyclerView = view.findViewById(R.id.cf_reccylerview);

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new Fragment_Bill();
                FragmentManager fragmentmanager =getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction =fragmentmanager.beginTransaction();
                fragmentTransaction.addToBackStack(fragment.getTag());
                fragmentTransaction.replace(R.id.fragment_layout,fragment);
                fragmentTransaction.commit();
            }
        });
        pre_data();

        return view;
    }

    void pre_data(){

        cflist = new ArrayList<>();
        cflist.add(new Chef_Model("Indian","https://data.tibettravel.org/assets/images/Tibet-bhutan-tour/indian-food-in-Lhasa.jpg",0));
        cflist.add(new Chef_Model("Continental","https://3.imimg.com/data3/OM/BI/MY-14951738/110867212-500x500.jpg",0));
        cflist.add(new Chef_Model("Arabic","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSyBfObVjtNGHUgJFf2Eaena7u2wuUpWBCm9OLpFbWgSq5Ys9T7&s",0));
        cflist.add(new Chef_Model("Chinise","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTiDyemqACYI55l5ppfEdQSg7B54azUMVS-BK1wTyKXDN5KiSpD9g&s",0));
        cflist.add(new Chef_Model("Philipino","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTedKSdh62ZqDldym6jEOSi8KQpKtWEowyysqGIa1s-8x_1s6Kh&s",0));

        GridLayoutManager gd = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(gd);
        recyclerView.setAdapter(new Chef_Adapter(getActivity(),cflist));

    }
}
