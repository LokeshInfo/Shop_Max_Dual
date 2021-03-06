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
import com.icss.shopmax.All_Services_Class.Payment_Fragment;

public class Sub_Rent_Car extends Fragment
{
    private Button bookcar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_book_rent_car,container,false);

        Toolbar toolbar = view.findViewById(R.id.car_book_toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).onBackPressed();
            }        });
        bookcar = view.findViewById(R.id.buttn_crbook);


        bookcar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_layout,new Payment_Fragment())
                        .addToBackStack(new Payment_Fragment().getTag()).commit();
            }
        });


        return view;
    }
}
