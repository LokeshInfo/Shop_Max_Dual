package com.icss.shopmax.All_Services_Class.Services;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.icss.shopmax.API_Retro.Api_Para;
import com.icss.shopmax.API_Retro.Retrofit_Client;
import com.icss.shopmax.A_Model.Chef;
import com.icss.shopmax.A_Model.ChefResponse;
import com.icss.shopmax.All_Services_Class.MainActivity;
import com.icss.shopmax.R;
import com.icss.shopmax.d_Adapter.Chef_Adapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Chef_fragment extends Fragment {
    RecyclerView recyclerView;
    Button book;
    List<Chef> cflist;
    private Api_Para api_para;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_chef, container, false);
        api_para = Retrofit_Client.getAPIService();
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).onBackPressed();
            }
        });

        book = view.findViewById(R.id.chef_book);
        recyclerView = view.findViewById(R.id.cf_reccylerview);

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new Fragment_Bill();
                FragmentManager fragmentmanager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentmanager.beginTransaction();
                fragmentTransaction.addToBackStack(fragment.getTag());
                fragmentTransaction.replace(R.id.fragment_layout, fragment);
                fragmentTransaction.commit();
            }
        });
        pre_data();

        return view;
    }

    void pre_data() {
        api_para.getAllChefHome().enqueue(new Callback<ChefResponse>() {
            @Override
            public void onResponse(Call<ChefResponse> call, Response<ChefResponse> response) {
                if (response.isSuccessful()) {
                    ChefResponse chefResponse = response.body();
                    if (chefResponse.getResponse()) {
                        GridLayoutManager gd = new GridLayoutManager(getActivity(), 2);
                        recyclerView.setLayoutManager(gd);
                        recyclerView.setAdapter(new Chef_Adapter(getActivity(), chefResponse.getChefList()));
                    }
                }
            }

            @Override
            public void onFailure(Call<ChefResponse> call, Throwable t) {

            }
        });


    }
}
