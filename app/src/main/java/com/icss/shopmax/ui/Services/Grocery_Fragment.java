package com.icss.shopmax.ui.Services;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.icss.shopmax.API_Retro.Api_Para;
import com.icss.shopmax.API_Retro.Retrofit_Client;
import com.icss.shopmax.A_Model.Grocery_Model;
import com.icss.shopmax.Adapter.Grocery_Adapter;
import com.icss.shopmax.R;
import com.icss.shopmax.View.Login_Activity;
import com.icss.shopmax.ui.MainActivity;
import com.icss.shopmax.ui.Sub_Category.Cart_Fragment;
import com.icss.shopmax.ui.Sub_Category.Sub_Add_Grocery_Fragment;
import com.icss.shopmax.ui.Sub_Category.Sub_Grocery_Fragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Grocery_Fragment extends Fragment
{
    LinearLayout add_food;
    Toolbar toolbar;
    RecyclerView recyclerView;
    Button ckeckOutBT;
    private Api_Para ApiService;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_grocery_orders,container,false);

        toolbar = view.findViewById(R.id.grocery_toolbar);
        recyclerView = view.findViewById(R.id.grocery_recyclerv);
        ckeckOutBT= view.findViewById(R.id.buttn_viewcart);

        add_food = view.findViewById(R.id.additional_lyt);

        ApiService = Retrofit_Client.getAPIService();

        Click_Listeners();
        Get_category();
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


    private void Click_Listeners(){
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).onBackPressed();
            }
        });

        add_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call_Fragment("S",new Sub_Add_Grocery_Fragment());
            }
        });
    }


    private void Get_category(){

        final ProgressDialog dialog;
        dialog = new ProgressDialog(getActivity());
        dialog.setMessage("Loading...");
        dialog.setCancelable(true);
        dialog.show();

        ApiService.Get_Grocery_Cat().enqueue(new Callback<Grocery_Model>() {
            @Override
            public void onResponse(Call<Grocery_Model> call, Response<Grocery_Model> response) {
                dialog.dismiss();

                Log.e("Get_Grocery_Cat .", "Response " + new Gson().toJson(response.body()));

                if (response.body().getResponse()){
                Grocery_Adapter gadapter = new Grocery_Adapter(getActivity(),response.body().getData());
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setAdapter(gadapter);}
                else{
                    Toast.makeText(getActivity(), "No data found...", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<Grocery_Model> call, Throwable t) {
                dialog.dismiss();

                Log.e("Get_Grocery_Cat Error "," "+t.getMessage());
                Log.e("Get_Grocery_Cat Error "," "+t.getLocalizedMessage());
                Log.e("Get_Grocery_Cat Error "," "+t.getCause());
            }
        });

    }

    private void Call_Fragment(String typ, Fragment fragment){
        Bundle args = new Bundle();
        args.putString("type",typ);
        fragment.setArguments(args);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout,fragment)
                .addToBackStack(fragment.getTag()).commit();
        }

}
