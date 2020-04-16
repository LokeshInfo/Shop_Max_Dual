package com.icss.shopmax.ui.Services;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.icss.shopmax.d_Adapter.Food_Order_Adapter;
import com.icss.shopmax.R;
import com.icss.shopmax.ui.MainActivity;

import java.util.ArrayList;

public class Food_Order_Fragment extends Fragment
{
    private RecyclerView recyclerView;
    private ArrayList<String> dlist;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_food_order,container,false);

        recyclerView = view.findViewById(R.id.food_order_recyclerview);

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).onBackPressed();
            }
        });

        pre_data();

        return view;
    }

    private void pre_data(){
        dlist = new ArrayList<>();

        dlist.add("Guru Kripa");
        dlist.add("Indian Zayka");
        dlist.add("Chinise Foody");
        dlist.add("North Food");
        dlist.add("South Food");
        dlist.add("Break Foods");
        dlist.add("Fresh Snacks");
        dlist.add("Radisson Blu");
        dlist.add("Sayaji Res");

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2,GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(new Food_Order_Adapter(getActivity(),dlist));
    }
}
