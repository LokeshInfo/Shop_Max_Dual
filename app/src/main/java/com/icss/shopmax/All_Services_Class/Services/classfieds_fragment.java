package com.icss.shopmax.All_Services_Class.Services;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.icss.shopmax.API_Retro.Api_Para;
import com.icss.shopmax.API_Retro.Retrofit_Client;
import com.icss.shopmax.A_Model.ClassifiedResponse;
import com.icss.shopmax.All_Services_Class.MainActivity;
import com.icss.shopmax.R;
import com.icss.shopmax.d_Adapter.classfieds_adapter;
import com.icss.shopmax.d_Adapter.classfieds_quickbrowse;
import com.icss.shopmax.d_Adapter.classfieds_search;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class classfieds_fragment extends Fragment {

    RecyclerView recyclerView;
    ImageView img1, img2;

    private Api_Para apiPara;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_classfieds, container, false);
        apiPara = Retrofit_Client.getAPIService();
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).onBackPressed();
            }
        });

        recyclerView = view.findViewById(R.id.classfieds_recycler_view);
        img1 = view.findViewById(R.id.ed_search);
        img2 = view.findViewById(R.id.ed_search2);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new classfieds_search();
                FragmentManager fragmentmanager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentmanager.beginTransaction();
                fragmentTransaction.addToBackStack(fragment.getTag());
                fragmentTransaction.replace(R.id.fragment_layout, fragment);
                fragmentTransaction.commit();
            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new classfieds_quickbrowse();
                FragmentManager fragmentmanager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentmanager.beginTransaction();
                fragmentTransaction.addToBackStack(fragment.getTag());
                fragmentTransaction.replace(R.id.fragment_layout, fragment);
                fragmentTransaction.commit();
            }
        });

        pre_Data();

        return view;
    }

    private void pre_Data() {
        apiPara.getAllClassified().enqueue(new Callback<ClassifiedResponse>() {
            @Override
            public void onResponse(Call<ClassifiedResponse> call, Response<ClassifiedResponse> response) {
                if (response.isSuccessful()) {
                    ClassifiedResponse classifiedResponse = response.body();
                    if (classifiedResponse.getResponse()) {
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                        recyclerView.setLayoutManager(linearLayoutManager);
                        recyclerView.setAdapter(new classfieds_adapter(getActivity(), classifiedResponse.getData()));
                    }
                }
            }

            @Override
            public void onFailure(Call<ClassifiedResponse> call, Throwable t) {

            }
        });

    }
}
