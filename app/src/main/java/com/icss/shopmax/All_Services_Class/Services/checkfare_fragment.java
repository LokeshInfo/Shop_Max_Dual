package com.icss.shopmax.All_Services_Class.Services;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.icss.shopmax.R;
import com.icss.shopmax.All_Services_Class.MainActivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

public class checkfare_fragment extends Fragment {
    Toolbar toolbar;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.checkfare,container,false);
        toolbar = view.findViewById(R.id.fare_toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).onBackPressed();
            }
        });


        return view;
    }
}
