package com.icss.shopmax.All_Services_Class.Services;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.icss.shopmax.API_Retro.Api_Para;
import com.icss.shopmax.API_Retro.Retrofit_Client;
import com.icss.shopmax.A_Model.Hospital_Model;
import com.icss.shopmax.d_Adapter.Hospital_Adapter;
import com.icss.shopmax.R;
import com.icss.shopmax.All_Services_Class.MainActivity;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Hospital_fragment extends Fragment
{
    private RecyclerView recyclerView;
    private ArrayList<String>datalist;
    ImageView img1;
    Activity activity;
    Api_Para ApiService;
    Hospital_Adapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_hospital,container,false);


        recyclerView = view.findViewById(R.id.hospital_recycler_view);
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).onBackPressed();
            }
        });
        ApiService = Retrofit_Client.getAPIService();
//        img1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Fragment fragment = new classfieds_search();
//                FragmentManager fragmentmanager = getActivity().getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentmanager.beginTransaction();
//                fragmentTransaction.addToBackStack(fragment.getTag());
//                fragmentTransaction.replace(R.id.fragment_layout, fragment);
//                fragmentTransaction.commit();
//            }
//        });

        //show_dialog();
        get_hospitals();
        return view;
    }

    private void show_dialog() {
        final Dialog dialogView = new Dialog(getActivity());
        dialogView.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialogView.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogView.setContentView(R.layout.dialog_hospital_service);

        Window window = dialogView.getWindow();
        window.setLayout(WindowManager.LayoutParams.FILL_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        Button buttn = (Button) dialogView.findViewById(R.id.buttn_search);
        buttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // pre_data();

            dialogView.dismiss();
            }});
        dialogView.show();
        dialogView.setCanceledOnTouchOutside(true);

    }


  /*  private void pre_data(){
        datalist = new ArrayList<>();
        datalist.add("Apolo Hospital");
        datalist.add("Rajshree Hospital");
        datalist.add("Life-Line Hospital");
        datalist.add("Live Care Hospital");
        datalist.add("Care Hospital");
        datalist.add("Health Care Hospital");
        datalist.add("World Hospital");
        datalist.add("Vijay Hospital");
        datalist.add("Live Hospital");

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2 , GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(new Hospital_Adapter(getActivity(),datalist));
    }*/

    private void get_hospitals(){

        final ProgressDialog dialog;
        dialog = new ProgressDialog(getActivity());
        dialog.setMessage(" Loading Hospitals... ");
        dialog.setCancelable(true);
        dialog.show();

        ApiService.Get_Hospitals().enqueue(new Callback<Hospital_Model>() {
            @Override
            public void onResponse(Call<Hospital_Model> call, Response<Hospital_Model> response) {
                dialog.dismiss();
                Log.e("Get_Hospitals RESPONSE.", "" + new Gson().toJson(response.body()));
                if (response.body().getResponse()){

                    GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2 , GridLayoutManager.VERTICAL, false);
                    recyclerView.setLayoutManager(gridLayoutManager);
                    adapter = new Hospital_Adapter(getActivity(),response.body().getData());
                    recyclerView.setAdapter(adapter);
                }
                else{

                }
            }

            @Override
            public void onFailure(Call<Hospital_Model> call, Throwable t) {
                dialog.dismiss();
                Log.e("Get_Hospitals Error "," "+t.getLocalizedMessage());
                Log.e("Get_Hospitals Error "," "+t.getMessage());
                Log.e("Get_Hospitals Error "," "+t.getCause());
                Log.e("Get_Hospitals Error "," "+t.getStackTrace());
            }
        });

    }

}
