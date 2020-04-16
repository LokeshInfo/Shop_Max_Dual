package com.icss.shopmax.d_Adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.icss.shopmax.R;

import java.util.ArrayList;

public class fragment_sub_quickbrowse extends Fragment {
    RecyclerView recyclerView2;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.adapter_quickbrowse,container,false);
        recyclerView2 = view.findViewById(R.id.classfieds_recycler_view2);
        pre_Data1();
        return  view;
    }
    private void pre_Data1() {
        ArrayList<vehicle_list_Data> dlist1 = new ArrayList();
        dlist1.add(new vehicle_list_Data("Car/Sedan","212"));
        dlist1.add(new vehicle_list_Data("4*4/SUV","212"));
        dlist1.add(new vehicle_list_Data("Car Parts & Accessories","212"));
        dlist1.add(new vehicle_list_Data("Commercial vehicle","212"));
        dlist1.add(new vehicle_list_Data("Car plate number","212"));
        dlist1.add(new vehicle_list_Data("motorbike","212"));
        dlist1.add(new vehicle_list_Data("Car rentals","212"));


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView2.setLayoutManager(linearLayoutManager);
        recyclerView2.setAdapter(new vehicle_list_adapter(getActivity(),dlist1));
    }

}
