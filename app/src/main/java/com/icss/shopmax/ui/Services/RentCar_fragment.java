package com.icss.shopmax.ui.Services;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.icss.shopmax.d_Adapter.Rent_Car_Adapter;
import com.icss.shopmax.Model.Rent_Car_Data;
import com.icss.shopmax.R;
import com.icss.shopmax.ui.MainActivity;

import java.util.ArrayList;

public class RentCar_fragment extends Fragment
{
    private RecyclerView recyclerView;
    ArrayList<Rent_Car_Data> dlist;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_rentacar,container,false);

        Toolbar toolbar = view.findViewById(R.id.rentcar_toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).onBackPressed();
            }
        });
        recyclerView = (RecyclerView) view.findViewById(R.id.rentcar_recycler_view);

        show_dialog();

        return view;
    }

    private void show_dialog() {
        final Dialog dialogView = new Dialog(getActivity());
        dialogView.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialogView.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogView.setContentView(R.layout.dialog_hospital_service);

        Window window = dialogView.getWindow();
        window.setLayout(WindowManager.LayoutParams.FILL_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        Button buttn = (Button) dialogView.findViewById(R.id.buttn_search);
        buttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pre_data();
                dialogView.dismiss();
            }});
        dialogView.show();
        dialogView.setCanceledOnTouchOutside(true);
    }

    private void pre_data(){

        dlist = new ArrayList<>();

        dlist.add(new Rent_Car_Data("BMW","XS","10000","SUV"));
        dlist.add(new Rent_Car_Data("Mercedes","ML350","30000","SUV"));
        dlist.add(new Rent_Car_Data("Toyota","Corolla","40000","SUV"));
        dlist.add(new Rent_Car_Data("VolksWagen","Polo","13000","SUV"));
        dlist.add(new Rent_Car_Data("Honda","City","18000","SUV"));
        dlist.add(new Rent_Car_Data("Ferrari","FS1000","10400","SUV"));
        dlist.add(new Rent_Car_Data("Skoda","Abc","14800","SUV"));
        dlist.add(new Rent_Car_Data("Nissan","XYZ","14300","SUV"));
        dlist.add(new Rent_Car_Data("Chevrolet","CV992","17600","SUV"));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new Rent_Car_Adapter(getActivity(),dlist));


    }
}
