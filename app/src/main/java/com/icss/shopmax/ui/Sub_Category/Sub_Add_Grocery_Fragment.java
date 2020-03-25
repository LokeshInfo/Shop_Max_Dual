package com.icss.shopmax.ui.Sub_Category;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.icss.shopmax.R;
import com.icss.shopmax.Sub_Adapter.Sub_Add_Grocery_Adapter;
import com.icss.shopmax.ui.MainActivity;

import java.util.ArrayList;

public class Sub_Add_Grocery_Fragment extends Fragment
{
    Toolbar toolbar;
    RecyclerView recyclerView;
    ArrayList<String> datalist;
    Button addpd;
    Sub_Add_Grocery_Adapter adapter;
    EditText ed1, ed2, ed3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_add_grocery,container,false);

        toolbar = view.findViewById(R.id.adgrtoolbar);
        recyclerView = view.findViewById(R.id.adgr_recycler);
        addpd = view.findViewById(R.id.buttn_add_pd);
        ed1 = view.findViewById(R.id.pd_nm);
        ed2 = view.findViewById(R.id.pd_unt);
        ed3 = view.findViewById(R.id.pd_qty);

        Click_Listeners();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new Sub_Add_Grocery_Adapter(getActivity(),datalist);
        recyclerView.setAdapter(adapter);

        return view;
    }
    private void Click_Listeners(){

        datalist = new ArrayList<>();
        datalist.add("Tomato - 2Kg - 1 qty");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).onBackPressed();
            }
        });

        addpd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String a1 = ed1.getText().toString();
                String a2 = ed2.getText().toString();
                String a3 = ed3.getText().toString()+" qty";

                String aditem = a1+"   --   "+a2+"   --   "+a3;

                adapter.add_item(aditem);
                Toast.makeText(getActivity(), "Item Added to List...", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
