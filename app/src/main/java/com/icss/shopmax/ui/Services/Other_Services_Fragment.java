package com.icss.shopmax.ui.Services;

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
import com.icss.shopmax.ui.MainActivity;
import com.icss.shopmax.ui.Payment_Fragment;
import com.icss.shopmax.ui.Sub_Category.Sub_Other_Services;

public class Other_Services_Fragment extends Fragment
{
    Toolbar toolbar;
    Button submit;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_other_services,container,false);
        toolbar = view.findViewById(R.id.ot_toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).onBackPressed();        }    });

        submit = view.findViewById(R.id.other_submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_layout,new Sub_Other_Services())
                        .addToBackStack(new Sub_Other_Services().getTag()).commit();
            }
        });


        return view;
    }
}
