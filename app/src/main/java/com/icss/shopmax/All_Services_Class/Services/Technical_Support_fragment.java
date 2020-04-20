package com.icss.shopmax.All_Services_Class.Services;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.icss.shopmax.API_Retro.Api_Para;
import com.icss.shopmax.API_Retro.Retrofit_Client;
import com.icss.shopmax.A_Model.TechnicalSupport;
import com.icss.shopmax.A_Model.TechnicalSupportResponse;
import com.icss.shopmax.All_Services_Class.MainActivity;
import com.icss.shopmax.All_Services_Class.Sub_Category.Technical_Sub_Fragment;
import com.icss.shopmax.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Technical_Support_fragment extends Fragment {
    Button book;
    RecyclerView recyclerView;
    List<TechnicalSupport> technicalSupportList;
    private DatePickerDialog picker;
    private Api_Para apiPara;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_technical_support, container, false);
        apiPara = Retrofit_Client.getAPIService();
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).onBackPressed();
            }
        });
        recyclerView = view.findViewById(R.id.tech_recycler);


        book = view.findViewById(R.id.buttn_book_serv);

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_layout, new Technical_Sub_Fragment())
                        .addToBackStack(new Technical_Sub_Fragment().getTag()).commit();
            }
        });
        pre_data();

        return view;
    }

    void pre_data() {

        apiPara.getAllTechnicalSupport().enqueue(new Callback<TechnicalSupportResponse>() {
            @Override
            public void onResponse(Call<TechnicalSupportResponse> call, Response<TechnicalSupportResponse> response) {
                if (response.isSuccessful()) {
                    TechnicalSupportResponse technicalSupportResponse = response.body();
                    if (technicalSupportResponse.getResponse()) {
                        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false);
                        recyclerView.setLayoutManager(gridLayoutManager);
                        recyclerView.setAdapter(new Technical_Adapter(getActivity(), technicalSupportResponse.getData()));
                    }

                }
            }

            @Override
            public void onFailure(Call<TechnicalSupportResponse> call, Throwable t) {

            }
        });

    }

}
