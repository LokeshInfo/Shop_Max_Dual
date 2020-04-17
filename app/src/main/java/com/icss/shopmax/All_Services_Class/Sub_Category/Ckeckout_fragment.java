package com.icss.shopmax.All_Services_Class.Sub_Category;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.icss.shopmax.Model.Food_Menu_Model;
import com.icss.shopmax.R;
import com.icss.shopmax.Sub_Adapter.Sub_Food_Menu_Adapter;
import com.icss.shopmax.All_Services_Class.MainActivity;
import com.icss.shopmax.All_Services_Class.Payment_Fragment;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Ckeckout_fragment extends Fragment {
    Button book;
    private ArrayList<Food_Menu_Model> dlist;
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_checkout,container,false);
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).onBackPressed();
            }
        });
        book = view.findViewById(R.id.chef_book);
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().
                     replace(R.id.fragment_layout,new Payment_Fragment()).addToBackStack(new Payment_Fragment().getTag()).commit();

            }
        });

        recyclerView = view.findViewById(R.id.foodmenu_recyclerview);
        pre_Data();

        return  view;
    }

    private void pre_Data() {
        dlist = new ArrayList<>();
        dlist.add(new Food_Menu_Model("Butter Paneer","200","Chilly gravy with extra butter make it more tasty.",1));
        dlist.add(new Food_Menu_Model("Pav Bhaji","300","Delicious Pav and bhaji",1));
        dlist.add(new Food_Menu_Model("Chhola Bhatura","250","Delicious Chola with extra cheese",1));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new Sub_Food_Menu_Adapter(getActivity(),dlist));


    }
}
