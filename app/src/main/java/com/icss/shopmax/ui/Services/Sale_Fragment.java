package com.icss.shopmax.ui.Services;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.icss.shopmax.API_Retro.Api_Para;
import com.icss.shopmax.API_Retro.Retrofit_Client;
import com.icss.shopmax.A_Model.Sale_Model;
import com.icss.shopmax.Adapter.Sale_Adapter;
import com.icss.shopmax.Model.Sale_Data;
import com.icss.shopmax.R;
import com.icss.shopmax.View.Register_Activity;
import com.icss.shopmax.ui.MainActivity;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Sale_Fragment extends Fragment
{
    private RecyclerView recyclerView;
    private Api_Para ApiService;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_sale,container,false);

        ApiService = Retrofit_Client.getAPIService();
        recyclerView = view.findViewById(R.id.sale_recycler_view);
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).onBackPressed();
            }
        });
        CALL_API();
        return view;
    }

    private void CALL_API(){

        final ProgressDialog dialog;
        dialog = new ProgressDialog(getActivity());
        dialog.setMessage("Processing");
        dialog.setCancelable(true);
        dialog.show();

        ApiService.CALL_SALE().enqueue(new Callback<Sale_Model>() {
            @Override
            public void onResponse(Call<Sale_Model> call, Response<Sale_Model> response) {
                dialog.dismiss();
                Log.e("CALL_SALE RESPONSE.", "" + new Gson().toJson(response.body()));
                if(response.body().getResponce()) {
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setAdapter(new Sale_Adapter(getActivity(), response.body().getData()));
                }
            }

            @Override
            public void onFailure(Call<Sale_Model> call, Throwable t) {
                dialog.dismiss();
                Log.e("Sale Error ",""+t.getLocalizedMessage());
            }});



    }
}
