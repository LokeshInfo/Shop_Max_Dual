package com.icss.shopmax.All_Services_Class.Sub_Category;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.icss.shopmax.API_Retro.Api_Para;
import com.icss.shopmax.API_Retro.Retrofit_Client;
import com.icss.shopmax.A_Model.Grocery_Product_Model;
import com.icss.shopmax.Model.Grocery_data;
import com.icss.shopmax.R;
import com.icss.shopmax.Sub_Adapter.Sub_Grocery_Adapter;
import com.icss.shopmax.All_Services_Class.DatabaseHandler;
import com.icss.shopmax.All_Services_Class.MainActivity;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Sub_Grocery_Fragment extends Fragment
{

    private ArrayList<Grocery_data>arrayList;
    Toolbar toolbar;
    TextView tv_name;
    String cat_id,catnm;
    private RecyclerView recyclerView;
    Button ckeckOutBT;
    private DatabaseHandler db;
    Api_Para ApiService;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_sub_grocery,container,false);

        toolbar = view.findViewById(R.id.grocery1_toolbar);
        recyclerView = view.findViewById(R.id.recycler_grocery);
        ckeckOutBT= view.findViewById(R.id.buttn_viewcart);
        tv_name = view.findViewById(R.id.tvname);
        ApiService = Retrofit_Client.getAPIService();
        Click_Listeners();

        if (getArguments()!=null) {
            cat_id = getArguments().getString("cat_id");
            catnm = getArguments().getString("cat_name");
            tv_name.setText(catnm);
            get_product(cat_id);
        }

        ckeckOutBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Fragment fragment = new Cart_Fragment();
                FragmentManager fragmentmanager =getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction =fragmentmanager.beginTransaction();
                fragmentTransaction.addToBackStack(fragment.getTag());
                fragmentTransaction.replace(R.id.fragment_layout,fragment);
                fragmentTransaction.commit();
            }
        });
        return view;
    }

    private void get_product(String id){

        final ProgressDialog dialog;
        dialog = new ProgressDialog(getActivity());
        dialog.setMessage("Loading...");
        dialog.setCancelable(true);
        dialog.show();

        ApiService.Get_Grocery_Product(id).enqueue(new Callback<Grocery_Product_Model>() {
            @Override
            public void onResponse(Call<Grocery_Product_Model> call, Response<Grocery_Product_Model> response) {
                dialog.dismiss();
                Log.e("Get_Grocery_Prod .", "Response " + new Gson().toJson(response.body()));

                if (response.body().getResponse()){
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setAdapter(new Sub_Grocery_Adapter(getActivity(),response.body().getData()));
                }
                else{
                    Toast.makeText(getActivity(), "No data found...", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Grocery_Product_Model> call, Throwable t) {
                dialog.dismiss();

                Log.e("Get_Grocery_Prod Error "," "+t.getMessage());
                Log.e("Get_Grocery_Prod Error "," "+t.getLocalizedMessage());
                Log.e("Get_Grocery_Prod Error "," "+t.getCause());
            }
        });

    }


    private void Click_Listeners(){
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).onBackPressed();
            }
        });
    }
}
