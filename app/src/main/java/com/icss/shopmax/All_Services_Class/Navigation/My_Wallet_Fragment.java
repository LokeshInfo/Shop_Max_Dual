package com.icss.shopmax.All_Services_Class.Navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.icss.shopmax.R;
import com.icss.shopmax.All_Services_Class.MainActivity;

public class My_Wallet_Fragment extends Fragment
{

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_wallet,container,false);

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).onBackPressed();
            }
        });

        return view;
    }
}
