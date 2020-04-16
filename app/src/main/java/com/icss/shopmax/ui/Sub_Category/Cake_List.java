package com.icss.shopmax.ui.Sub_Category;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.icss.shopmax.Model.Rent_Car_Data;
import com.icss.shopmax.R;
import com.icss.shopmax.Sub_Adapter.Cake_List_Adapter;
import com.icss.shopmax.ui.MainActivity;

import java.util.ArrayList;

public class Cake_List extends Fragment
{
    private RecyclerView recyclerView;
    ArrayList<Rent_Car_Data> dlist;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_ordercake,container,false);

        Toolbar toolbar = view.findViewById(R.id.rentcar_toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).onBackPressed();
            }
        });
        recyclerView = (RecyclerView) view.findViewById(R.id.rentcar_recycler_view);

        pre_data();

        return view;
    }

    private void pre_data(){

        dlist = new ArrayList<>();

        dlist.add(new Rent_Car_Data("Caramel Apple Cake","","1000","Chocolate Flavour"));
        dlist.add(new Rent_Car_Data("Orange Velvet Cake","","2766","Pineapple Flavour"));
        dlist.add(new Rent_Car_Data("Pineapple Cake","","3999","White Chocolate Covered Strawberry"));
        dlist.add(new Rent_Car_Data("Lemon Ginger Cake","","12999","Key Lime."));
        dlist.add(new Rent_Car_Data("Apricot crumble cake","","13777","Pumpkin Roll"));
        dlist.add(new Rent_Car_Data("Vanilla Birthday Cake","","5999","White Chocolate Raspberry Cheese Cake"));
        dlist.add(new Rent_Car_Data("Caramel Cake","","8999","Strawberry Lemonade"));
        dlist.add(new Rent_Car_Data("Buttercake with lemon icing","","8977","Orange Dreamsicle"));
        dlist.add(new Rent_Car_Data("Red Velvet Brownies","","3999","Death by Chocolate"));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new Cake_List_Adapter(getActivity(),dlist));


    }

}
