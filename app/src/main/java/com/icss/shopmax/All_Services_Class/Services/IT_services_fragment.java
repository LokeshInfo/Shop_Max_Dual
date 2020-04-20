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
import com.icss.shopmax.A_Model.ITResponse;
import com.icss.shopmax.A_Model.ITSupport;
import com.icss.shopmax.All_Services_Class.MainActivity;
import com.icss.shopmax.R;
import com.icss.shopmax.d_Adapter.It_service_Adapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IT_services_fragment extends Fragment {
    RecyclerView recyclerView;
    List<ITSupport> dlist;
    private Api_Para apiPara;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fagment_itservice, container, false);
        apiPara = Retrofit_Client.getAPIService();
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).onBackPressed();
            }
        });

        recyclerView = view.findViewById(R.id.itservice_recycler_view);

        getData();

        return view;
    }

    private void getData() {
        apiPara.getAllITSupport().enqueue(new Callback<ITResponse>() {
            @Override
            public void onResponse(Call<ITResponse> call, Response<ITResponse> response) {
                if (response.isSuccessful()) {
                    ITResponse itResponse = response.body();
                    if (itResponse.getResponse()) {
                        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false);
                        recyclerView.setLayoutManager(gridLayoutManager);
                        recyclerView.setAdapter(new It_service_Adapter(getActivity(), itResponse.getData()));
                    }

                }
            }

            @Override
            public void onFailure(Call<ITResponse> call, Throwable t) {

            }
        });
    }
}
