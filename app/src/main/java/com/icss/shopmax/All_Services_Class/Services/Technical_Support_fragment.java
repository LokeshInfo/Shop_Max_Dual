package com.icss.shopmax.All_Services_Class.Services;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.icss.shopmax.Model.Chef_Model;
import com.icss.shopmax.R;
import com.icss.shopmax.All_Services_Class.MainActivity;
import com.icss.shopmax.All_Services_Class.Sub_Category.Technical_Sub_Fragment;

import java.util.ArrayList;

public class Technical_Support_fragment extends Fragment
{
    Button book;
    RecyclerView recyclerView;
    ArrayList<Chef_Model> cflist;
    private DatePickerDialog picker;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_technical_support,container,false);

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).onBackPressed();
            }
        });
        recyclerView = view.findViewById(R.id.tech_recycler);


        book = view.findViewById(R.id.buttn_book_serv);

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_layout,new Technical_Sub_Fragment())
                        .addToBackStack(new Technical_Sub_Fragment().getTag()).commit();
            }
        });
        pre_data();

        return view;
    }

    void pre_data(){

        cflist = new ArrayList<>();
        cflist.add(new Chef_Model("AC Mechanic","https://www.netclipart.com/pp/m/181-1812956_plumbing-gas-services-in-cartoon-plumber-png.png",0));
        cflist.add(new Chef_Model("Plumber","https://www.netclipart.com/pp/m/181-1812956_plumbing-gas-services-in-cartoon-plumber-png.png",0));
        cflist.add(new Chef_Model("Electrician","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTjXxDCwER4ZZxIUl_m5Fl8oNtqgAS-AiOB9DUA6YyE0JF6MR-h&s",0));
        cflist.add(new Chef_Model("Carpenter","https://st2.depositphotos.com/2589681/8093/v/450/depositphotos_80932320-stock-illustration-carpenter.jpg",0));
        cflist.add(new Chef_Model("Painter","https://us.123rf.com/450wm/vector2011/vector20111704/vector2011170400036/76371924-vector-ilustraci%C3%B3n-de-un-pintor-profesional-est%C3%A1-vestido-con-ropa-de-trabajo.jpg?ver=6",0));
        cflist.add(new Chef_Model("Road Side Assistant","https://cdn2.iconfinder.com/data/icons/cars-tractors-and-trucks/117/cars-07-512.png",0));
        cflist.add(new Chef_Model("Lost Car Key","https://cdn4.iconfinder.com/data/icons/dot/256/parking_locked.png",0));
        cflist.add(new Chef_Model("Others","https://cdn.iconscout.com/icon/premium/png-512-thumb/service-85-549338.png",0));


        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2 , GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(new Technical_Adapter(getActivity(),cflist));

    }

}
