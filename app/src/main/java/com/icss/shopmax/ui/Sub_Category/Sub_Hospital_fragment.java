package com.icss.shopmax.ui.Sub_Category;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.icss.shopmax.API_Retro.Api_Para;
import com.icss.shopmax.API_Retro.Retrofit_Client;
import com.icss.shopmax.A_Model.Doctor_Model;
import com.icss.shopmax.Model.Hospital_Data;
import com.icss.shopmax.R;
import com.icss.shopmax.Sub_Adapter.Sub_Hospital_Adapter;
import com.icss.shopmax.ui.MainActivity;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Sub_Hospital_fragment extends Fragment
{
    private RecyclerView recyclerView;
    private ArrayList<Hospital_Data> datalist;
    private String hospital_id;
    private Api_Para ApiService;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_hospital,container,false);
        recyclerView = view.findViewById(R.id.hospital_recycler_view);
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).onBackPressed();    }
        });

        ApiService = Retrofit_Client.getAPIService();

        if (getArguments()!=null){
            hospital_id = getArguments().getString("hospital_id");   }
        get_doctors();
       // pre_data();
        return view;
    }

    private void get_doctors(){
        final ProgressDialog dialog;
        dialog = new ProgressDialog(getActivity());
        dialog.setMessage("Loading Doctors...");
        dialog.setCancelable(true);
        dialog.show();
        ApiService.Get_Doctors(hospital_id).enqueue(new Callback<Doctor_Model>() {
            @Override
            public void onResponse(Call<Doctor_Model> call, Response<Doctor_Model> response) {
                dialog.dismiss();
                Log.e("Get_Doctors RESPONSE.", "" + new Gson().toJson(response.body()));

                if (response.body().getResponse()){
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setAdapter(new Sub_Hospital_Adapter(getActivity(),response.body().getData()));
                }
                else{
                    getActivity().getSupportFragmentManager().popBackStack();
                    Toast.makeText(getActivity(), "No Doctors Available...", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Doctor_Model> call, Throwable t) {
                dialog.dismiss();
                Log.e("Get_Doctors Error "," "+t.getMessage());
                Log.e("Get_Doctors Error "," "+t.getLocalizedMessage());
                Log.e("Get_Doctors Error "," "+t.getCause());
            }
        });

    }

    private void pre_data(){

        datalist = new ArrayList<>();

        datalist.add(new Hospital_Data("Dr. AK Verma","", "10000","General Medecine"));
        datalist.add(new Hospital_Data("Dr. Shah","", "2000","Ayurvedic"));
        datalist.add(new Hospital_Data("Dr. Shukla","", "6700","General Medecine"));
        datalist.add(new Hospital_Data("Dr. Chopra","", "3000","Ortho "));
        datalist.add(new Hospital_Data("Dr. Singh","", "1000","Pediatric"));

    }
}
