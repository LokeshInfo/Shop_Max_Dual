package com.icss.shopmax.All_Services_Class.Sub_Category;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.icss.shopmax.R;
import com.icss.shopmax.All_Services_Class.MainActivity;
import com.icss.shopmax.All_Services_Class.Services.Fragment_Bill;

public class Sub_Professional_Writer extends Fragment
{
    Toolbar toolbar;
    Button button;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_sub_writer,container,false);
        toolbar = view.findViewById(R.id.wwr_toolbar);
        button = view.findViewById(R.id.buttn_wwr);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).onBackPressed();
            }        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_layout,new Fragment_Bill())
                        .addToBackStack(new Fragment_Bill().getTag()).commit();
            }
        });

        return  view;
    }
}
