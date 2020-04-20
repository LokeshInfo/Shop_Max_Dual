package com.icss.shopmax.All_Services_Class.Services;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.icss.shopmax.API_Retro.Api_Para;
import com.icss.shopmax.API_Retro.Retrofit_Client;
import com.icss.shopmax.A_Model.RestaurantResponse;
import com.icss.shopmax.All_Services_Class.MainActivity;
import com.icss.shopmax.R;
import com.icss.shopmax.d_Adapter.Food_Order_Adapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Food_Order_Fragment extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<String> dlist;
    private Api_Para apiPara;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_food_order, container, false);
        apiPara = Retrofit_Client.getAPIService();
        recyclerView = view.findViewById(R.id.food_order_recyclerview);

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).onBackPressed();
            }
        });

        pre_data();

        return view;
    }

    private void pre_data() {
        apiPara.getAllRestaurant().enqueue(new Callback<RestaurantResponse>() {
            @Override
            public void onResponse(Call<RestaurantResponse> call, Response<RestaurantResponse> response) {
                if (response.isSuccessful()) {
                    RestaurantResponse restaurantResponse = response.body();
                    if (restaurantResponse.getResponse()) {
                        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false);
                        recyclerView.setLayoutManager(gridLayoutManager);
                        recyclerView.setAdapter(new Food_Order_Adapter(getActivity(), restaurantResponse.getData()));
                    }

                }
            }

            @Override
            public void onFailure(Call<RestaurantResponse> call, Throwable t) {

            }
        });

    }
}
