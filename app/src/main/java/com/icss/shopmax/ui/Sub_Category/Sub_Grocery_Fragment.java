package com.icss.shopmax.ui.Sub_Category;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.icss.shopmax.Model.Grocery_data;
import com.icss.shopmax.R;
import com.icss.shopmax.Sub_Adapter.Sub_Grocery_Adapter;
import com.icss.shopmax.ui.DatabaseHandler;
import com.icss.shopmax.ui.MainActivity;
import com.icss.shopmax.ui.Payment_Fragment;
import com.icss.shopmax.ui.Services.Cleaning_Services;

import java.util.ArrayList;

public class Sub_Grocery_Fragment extends Fragment
{

    private ArrayList<Grocery_data>arrayList;
    Toolbar toolbar;
    String typ;
    private RecyclerView recyclerView;
    Button ckeckOutBT;
    private DatabaseHandler db;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_sub_grocery,container,false);

        toolbar = view.findViewById(R.id.grocery1_toolbar);
        recyclerView = view.findViewById(R.id.recycler_grocery);
        ckeckOutBT= view.findViewById(R.id.buttn_viewcart);
        Click_Listeners();

        typ = getArguments().getString("type","A");
        if (typ.equals("A")){
        pre_data();}
        else{
            pre_data1();
        }
        ckeckOutBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Fragment fragment = new Cart_Fragment();
                FragmentManager fragmentmanager =getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction =fragmentmanager.beginTransaction();
                fragmentTransaction.addToBackStack(fragment.getTag());
                fragmentTransaction.replace(R.id.fragment_layout,fragment);
                fragmentTransaction.commit();
            }
        });
        return view;
    }

    private void pre_data(){
        arrayList = new ArrayList<>();

        arrayList.add(new Grocery_data("Tomato","1 Kg","Rs. 100",1));
        arrayList.add(new Grocery_data("Potato","1 Kg","Rs. 300",1));
        arrayList.add(new Grocery_data("Chana","500 gm","Rs. 50",1));
        arrayList.add(new Grocery_data("Sauce","500 gm","Rs. 90",1));
        arrayList.add(new Grocery_data("Rice","1 Kg","Rs. 200",1));
        arrayList.add(new Grocery_data("Wheat / Flour","1 Kg","Rs. 20",1));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new Sub_Grocery_Adapter(getActivity(),arrayList));
    }

    private void pre_data1(){
        arrayList = new ArrayList<>();

        arrayList.add(new Grocery_data("Tooth Paste","1 Pkt","Rs. 100",1));
        arrayList.add(new Grocery_data("Pen","1 Pkt","Rs. 300",1));
        arrayList.add(new Grocery_data("Wash Liquid","1 Kg","Rs. 50",1));
        arrayList.add(new Grocery_data("Soap","1 Kg","Rs. 90",1));
        arrayList.add(new Grocery_data("Room Freshner","1 Kg","Rs. 200",1));
        arrayList.add(new Grocery_data("Dish Wash","1 Kg","Rs. 20",1));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new Sub_Grocery_Adapter(getActivity(),arrayList));
    }

    private void Click_Listeners(){
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).onBackPressed();
            }
        });
    }
}
