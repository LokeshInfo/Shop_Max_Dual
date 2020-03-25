package com.icss.shopmax.ui.Services;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.icss.shopmax.Adapter.Rent_Hotel_Adapter;
import com.icss.shopmax.Adapter.flight_booking_Adapter;
import com.icss.shopmax.Model.Rent_Hotel_Data;
import com.icss.shopmax.Model.flight_data;
import com.icss.shopmax.R;
import com.icss.shopmax.ui.MainActivity;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class bookflight_fragment extends Fragment {
    private RecyclerView recyclerView;
    ArrayList<flight_data> dlist;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bookflight,container,false);

        Toolbar toolbar = view.findViewById(R.id.bookflight_toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).onBackPressed();
            }
        });
        recyclerView = (RecyclerView) view.findViewById(R.id.bookflight_recycler_view);
        pre_data();

        return view;

    }

    private void pre_data(){

        dlist = new ArrayList<>();

        dlist.add(new flight_data("Qatar Airways","80000 ","Flight No. 101","1/01/2020","10:00 AM","8:00 AM"));
        dlist.add(new  flight_data("Air India","75000 ","Flight No. 102","6/01/2020","07:00 AM","10:00 AM"));
        dlist.add(new  flight_data("British Airways","60000 ","Flight No. 103","8/01/2020","6:00 AM","8:00 AM"));
        dlist.add(new flight_data("Indigo","95000 ","Flight No. 104","15/01/2020","11:00 AM","9:00 AM"));
        dlist.add(new flight_data("Airbus","70000 ","Flight No. 105","31/01/2020","10:00 AM","5:00 AM"));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new flight_booking_Adapter(getActivity(),dlist));

    }
}
