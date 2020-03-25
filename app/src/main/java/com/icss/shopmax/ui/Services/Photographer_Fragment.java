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
import com.icss.shopmax.ui.Sub_Category.Book_Photographer_Fragment;

public class Photographer_Fragment extends Fragment
{
    Toolbar toolbar;
    Button book;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_photographer,container,false);
        toolbar = view.findViewById(R.id.ph_toolbar);
        book = view.findViewById(R.id.buttn_bookph);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).onBackPressed();            }        });


        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_layout,new Book_Photographer_Fragment())
                        .addToBackStack(new Book_Photographer_Fragment().getTag()).commit();
            }
        });


        return view;
    }
}
