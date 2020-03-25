package com.icss.shopmax.ui;

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

public class Payment_Fragment extends Fragment
{
    Button pay;
    Toolbar toolbar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_payment,container,false);
        pay = view.findViewById(R.id.payout);
        toolbar = view.findViewById(R.id.payment_toolbar);

        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {                ((MainActivity)getActivity()).onBackPressed();            }        });

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().
                        replace(R.id.fragment_layout,new Fragment_Track_Order()).addToBackStack(new Fragment_Track_Order().getTag()).commit();

            }
        });

        return  view;
    }
}
