package com.icss.shopmax.All_Services_Class;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.icss.shopmax.API_Retro.Retrofit_Client;
import com.icss.shopmax.A_Model.Services_Model;
import com.icss.shopmax.d_Adapter.Home_adapter;
import com.icss.shopmax.Model.data_model;
import com.icss.shopmax.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private RecyclerView recycler1;
    private ArrayList<data_model> list1;

    private Home_adapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        Toolbar toolbar = root.findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).openDrawer();
            }
        });

        recycler1 = (RecyclerView) root.findViewById(R.id.recycler1);

        Call_Api();

        return root;
    }

    private void Call_Api(){

        final ProgressDialog dialog;
        dialog = new ProgressDialog(getActivity());
        dialog.setMessage(" Loading Services... ");
        dialog.setCancelable(true);
        dialog.show();

        Retrofit_Client.getAPIService().Get_Services().enqueue(new Callback<Services_Model>() {
            @Override
            public void onResponse(Call<Services_Model> call, Response<Services_Model> response) {
                dialog.dismiss();
                Log.e("Get Services RESPONSE.", "" + new Gson().toJson(response.body()));

                if (response.body().getResponse()){

                    GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3 , GridLayoutManager.VERTICAL, false);

                    adapter = new Home_adapter(getActivity() , response.body().getData());
                    recycler1.setLayoutManager(gridLayoutManager);
                    recycler1.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<Services_Model> call, Throwable t) {
                dialog.dismiss();
                Log.e("Get_Services Error "," "+t.getMessage());
                Log.e("Get_Services Error "," "+t.getLocalizedMessage());
                Log.e("Get_Services Error "," "+t.getCause());
            }
        });

    }

/*
    private void prepare_data(){
        list1 = new ArrayList<>();

        list1.add(new data_model(R.drawable.sale, "SALE"));
        list1.add(new data_model(R.drawable.doc_appoint, "Doctors \n Appointment"));
        list1.add(new data_model(R.drawable.grocery, "Grocery Orders\n & delivery"));
        list1.add(new data_model(R.drawable.food, "Food Orders\n & delivery"));
        list1.add(new data_model(R.drawable.classified, "Classfieds"));
        list1.add(new data_model(R.drawable.hotel, "Hotel Booking"));
        list1.add(new data_model(R.drawable.travel_agent, "Travel Agent"));
        list1.add(new data_model(R.drawable.rent_car, "Rent A Car"));
        list1.add(new data_model(R.drawable.photographer, "Photographer"));
        list1.add(new data_model(R.drawable.technical_support, "Technical Support"));
        list1.add(new data_model(R.drawable.it_services, "IT Services"));
        list1.add(new data_model(R.drawable.prof_cv_writers, "Professional\n CV writers"));
        list1.add(new data_model(R.drawable.cake, "Cake Order &\n Homely Food"));
        list1.add(new data_model(R.drawable.pest_control, "Pest \n Control"));
        list1.add(new data_model(R.drawable.chef_athome, "Chef at\n Home"));
        list1.add(new data_model(R.drawable.gas_cyliner, "Gas Cylinder\n Delivery"));
        list1.add(new data_model(R.drawable.cleaning_services, "Cleaning Services"));
        list1.add(new data_model(R.drawable.other_services, "Other Services"));
    }*/
}