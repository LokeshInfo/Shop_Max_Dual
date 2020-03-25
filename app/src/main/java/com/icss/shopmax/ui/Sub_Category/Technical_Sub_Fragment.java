package com.icss.shopmax.ui.Sub_Category;

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

public class Technical_Sub_Fragment extends Fragment
{
    Button book;
    Toolbar toolbar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_sub_technical,container,false);
        toolbar = view.findViewById(R.id.tcsubtoolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).onBackPressed();
            }});
        book = view.findViewById(R.id.buttn_booktsup);

        book.setOnClickListener(new View.OnClickListener() {
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
