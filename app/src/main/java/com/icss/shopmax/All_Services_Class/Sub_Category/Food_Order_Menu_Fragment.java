package com.icss.shopmax.All_Services_Class.Sub_Category;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.icss.shopmax.Model.Food_Menu_Model;
import com.icss.shopmax.R;
import com.icss.shopmax.Sub_Adapter.Sub_Food_Menu_Adapter;

import java.util.ArrayList;

public class Food_Order_Menu_Fragment extends Fragment
{
    ArrayList<Food_Menu_Model> datalist;
    private RecyclerView recyclerView;

    public Food_Order_Menu_Fragment(ArrayList<Food_Menu_Model> dlist){
        this.datalist=dlist;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fargment_food_menu,container,false);
        recyclerView = view.findViewById(R.id.foodmenu_recyclerview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new Sub_Food_Menu_Adapter(getActivity(),datalist));

        return view;
    }
}
