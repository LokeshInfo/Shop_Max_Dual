package com.icss.shopmax.All_Services_Class.Sub_Category;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.icss.shopmax.API_Retro.Retrofit_Client;
import com.icss.shopmax.A_Model.Sale_Sub_Model;
import com.icss.shopmax.Model.Sale_Data;
import com.icss.shopmax.R;
import com.icss.shopmax.Sub_Adapter.Sub_Sale_Adapter;
import com.icss.shopmax.All_Services_Class.MainActivity;
import com.icss.shopmax.All_Services_Class.Payment_Fragment;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Sub_Sale_fragment  extends Fragment
{
    private RecyclerView recyclerView;
    private ArrayList<Sale_Data> datalist;
    Button proceed;
    private String cat_id, cat_name;
    Toolbar toolbar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_sub_sale,container,false);

        recyclerView = view.findViewById(R.id.subsale_recycler_view);
        proceed = view.findViewById(R.id.ssle_proceed);
        toolbar = view.findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).onBackPressed();
            }
        });
        cat_name = getArguments().getString("cat_name");
        cat_id = getArguments().getString("cat_id");
        toolbar.setTitle(""+cat_name);
        Call_API();

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().
                        replace(R.id.fragment_layout,new Payment_Fragment()).addToBackStack(new Payment_Fragment().getTag()).commit();
            }
        });

        return view;
    }

    private void Call_API(){

        final ProgressDialog dialog;
        dialog = new ProgressDialog(getActivity());
        dialog.setMessage("Processing");
        dialog.setCancelable(true);
        dialog.show();

        Retrofit_Client.getAPIService().CALL_SUB_SALE(cat_id).enqueue(new Callback<Sale_Sub_Model>() {
            @Override
            public void onResponse(Call<Sale_Sub_Model> call, Response<Sale_Sub_Model> response) {
                dialog.dismiss();
                Log.e("CALL_SALE RESPONSE.", "" + new Gson().toJson(response.body()));
                if (response.body().getResponce()){
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setAdapter(new Sub_Sale_Adapter(getActivity(),response.body().getData()));
                }
            }

            @Override
            public void onFailure(Call<Sale_Sub_Model> call, Throwable t) {
                dialog.dismiss();
                Log.e("Sub Sale Error ",""+t.getLocalizedMessage());
            }
        });

    }
}
