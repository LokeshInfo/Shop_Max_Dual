package com.icss.shopmax.ui.Services;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.icss.shopmax.Adapter.Rent_Hotel_Adapter;
import com.icss.shopmax.Model.Rent_Hotel_Data;
import com.icss.shopmax.R;
import com.icss.shopmax.ui.MainActivity;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RentHotel_fragment extends Fragment {
    private RecyclerView recyclerView;
    ArrayList<Rent_Hotel_Data> dlist;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_rentahotel,container,false);

        Toolbar toolbar = view.findViewById(R.id.renthotel_toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).onBackPressed();
            }
        });
        recyclerView = (RecyclerView) view.findViewById(R.id.renthotel_recycler_view);

        pre_data();

        return view;
    }
    private void pre_data(){

        dlist = new ArrayList<>();

        dlist.add(new Rent_Hotel_Data("Sayaji"," ","7500","Rating: 4.9"));
        dlist.add(new Rent_Hotel_Data("Redisson","","7150","Rating: 4.9"));
        dlist.add(new Rent_Hotel_Data("Hotel Wow","","6560","Rating: 4.6"));
        dlist.add(new Rent_Hotel_Data("Hotel Shreemaya","","5650","Rating: 4.3"));
        dlist.add(new Rent_Hotel_Data("Hotel Infinity","","6500","Rating: 4.5"));
        dlist.add(new Rent_Hotel_Data("Oyo Hotel","","945","Rating: 4.6"));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new Rent_Hotel_Adapter(getActivity(),dlist));

    }
}
