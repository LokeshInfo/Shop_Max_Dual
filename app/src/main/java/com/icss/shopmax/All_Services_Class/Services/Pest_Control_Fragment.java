package com.icss.shopmax.All_Services_Class.Services;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.icss.shopmax.R;
import com.icss.shopmax.All_Services_Class.MainActivity;
import com.icss.shopmax.All_Services_Class.Sub_Category.Sub_Other_Services;

public class Pest_Control_Fragment extends Fragment
{
    Button book;
    CheckBox ch1, ch2, ch3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_pest_control,container,false);
        Toolbar toolbar = view.findViewById(R.id.pest_toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).onBackPressed();
            }      });


        book = view.findViewById(R.id.pest_book);
        ch1 = view.findViewById(R.id.ch1);
        ch2 = view.findViewById(R.id.ch2);
        ch3 = view.findViewById(R.id.ch3);
        Click_Listeners();

        return view;
    }

    private void Click_Listeners(){
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new Sub_Other_Services();
                FragmentManager fragmentmanager =getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction =fragmentmanager.beginTransaction();
                fragmentTransaction.addToBackStack(fragment.getTag());
                fragmentTransaction.replace(R.id.fragment_layout,fragment);
                fragmentTransaction.commit();
            }
        });

        ch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    ch2.setChecked(false);
                    ch3.setChecked(false);
                }
            }
        });

        ch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    ch1.setChecked(false);
                    ch3.setChecked(false);
                }
            }
        });

        ch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    ch2.setChecked(false);
                    ch1.setChecked(false);
                }
            }
        });
    }


}
