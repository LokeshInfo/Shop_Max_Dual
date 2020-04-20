package com.icss.shopmax.All_Services_Class.Services;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.icss.shopmax.API_Retro.Api_Para;
import com.icss.shopmax.API_Retro.Retrofit_Client;
import com.icss.shopmax.A_Model.WritersResponse;
import com.icss.shopmax.d_Adapter.Professional_Writer_Adapter;
import com.icss.shopmax.Model.Professional_Writer_Data;
import com.icss.shopmax.R;
import com.icss.shopmax.All_Services_Class.MainActivity;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Professional_writer_fragment extends Fragment {
    RecyclerView recyclerView;
    private Api_Para apiPara;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_professional_writer, container, false);
        apiPara = Retrofit_Client.getAPIService();

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).onBackPressed();
            }
        });

        recyclerView = view.findViewById(R.id.writr_recycler_view);

        pre_data();

        return view;
    }

    private void pre_data() {

        apiPara.getAllWriters().enqueue(new Callback<WritersResponse>() {
            @Override
            public void onResponse(Call<WritersResponse> call, Response<WritersResponse> response) {
                if (response.isSuccessful()) {
                    WritersResponse writersResponse = response.body();
                    if (writersResponse.getResponse()) {
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                        recyclerView.setLayoutManager(linearLayoutManager);
                        recyclerView.setAdapter(new Professional_Writer_Adapter(getActivity(), writersResponse.getData()));
                    }
                }
            }

            @Override
            public void onFailure(Call<WritersResponse> call, Throwable t) {

            }
        });

    }


}
