package com.icss.shopmax.ui.Sub_Category;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.icss.shopmax.Model.Grocery_data;
import com.icss.shopmax.R;
import com.icss.shopmax.Sub_Adapter.Sub_Grocery_Adapter;
import com.icss.shopmax.ui.MainActivity;
import com.icss.shopmax.ui.Payment_Fragment;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Cart_Fragment extends Fragment {
    private ArrayList<Grocery_data> arrayList;
    Toolbar toolbar;
    String typ;
    private RecyclerView recyclerView;
    Button book;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart, container, false);
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).onBackPressed();
            }
        });
        recyclerView = view.findViewById(R.id.recycler_grocery);
        book = view.findViewById(R.id.chef_book);
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().
                        replace(R.id.fragment_layout,new Payment_Fragment()).addToBackStack(new Payment_Fragment().getTag()).commit();

            }
        });


pre_data();
        return view;
    }
    private void pre_data(){
        arrayList = new ArrayList<>();

        arrayList.add(new Grocery_data("Tomato","1 Kg","Rs. 100",1));
        arrayList.add(new Grocery_data("Potato","1 Kg","Rs. 300",1));
        arrayList.add(new Grocery_data("Chana","500 gm","Rs. 50",1));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new Sub_Grocery_Adapter(getActivity(),arrayList));
    }
}
