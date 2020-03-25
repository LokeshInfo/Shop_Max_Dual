package com.icss.shopmax.ui.Services;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.icss.shopmax.R;
import com.icss.shopmax.ui.MainActivity;
import com.icss.shopmax.ui.Sub_Category.Cake_List;
import com.icss.shopmax.ui.Sub_Category.Sub_Professional_Writer;
import com.icss.shopmax.ui.Sub_Category.Sub_Rent_Car;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class Cake_Order_Fragment extends Fragment
{
    RecyclerView recyclerView;
    ImageView g1,g2,g3, f1,f2,f3;
    LinearLayout cakelyt, homelyt,otherslyt;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cake_order,container,false);

        Toolbar toolbar = view.findViewById(R.id.cake_toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).onBackPressed();}
        });

        cakelyt = view.findViewById(R.id.cakelyt);
        homelyt = view.findViewById(R.id.homelyt);
        otherslyt = view.findViewById(R.id.otherslyt);
        g1 = view.findViewById(R.id.gi1);
        g2 = view.findViewById(R.id.gi2);
        g3 = view.findViewById(R.id.gi3);
        f1 = view.findViewById(R.id.gi11);
        f2 = view.findViewById(R.id.gi22);
        f3 = view.findViewById(R.id.gi33);

        pre_data();

        return view;
    }

    private void pre_data(){

        String c1="https://img.floweraura.com/sites/default/files/styles/mobile_product_image_450_450/public/2-tier-blackforest-A_0.jpg";
        String c2="https://img.taste.com.au/FBczi1cs/w1200-h630-cfill/taste/2018/08/smarties-chocolate-cake-139872-2.jpg";
        String c3="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR4uh2PLmVe4Zb3lBt7sC_fAXAqY1v8i0Jr91baHAfnb9Q4TgQw&s";
        String c4="https://res.cloudinary.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_508,h_320,c_fill/luuhipeie7ztari5db93";
        String c5="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQiEqaXZTUlF7Zza2imzYL3CE4gP9fQU8AQDtFWEGQ20NUz63D4&s";
        String c6="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQrKtBGme6QrFKji50_6X-tavxcWWG39TZHa33vWFBtlczznu9w&s";

        Glide.with(getActivity()).load(c1).into(g1);
        Glide.with(getActivity()).load(c2).into(g2);
        Glide.with(getActivity()).load(c3).into(g3);
        Glide.with(getActivity()).load(c4).into(f1);
        Glide.with(getActivity()).load(c6).into(f2);
        Glide.with(getActivity()).load(c5).into(f3);

        homelyt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_dilog();
            }        });

        otherslyt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_dilog();
            } });

        cakelyt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call_Fragment(new Cake_List());
            } });
    }

    private void show_dilog()
    {
        final Dialog dialogView = new Dialog(getActivity());
        dialogView.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialogView.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogView.setContentView(R.layout.dialog_enter_requirement);

        Window window = dialogView.getWindow();
        window.setLayout(WindowManager.LayoutParams.FILL_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        Button buttnorder = (Button) dialogView.findViewById(R.id.buttn_order);

        buttnorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Call_Fragment(new Sub_Professional_Writer());
                    dialogView.dismiss();

            }
        });
        dialogView.show();
        dialogView.setCanceledOnTouchOutside(true);
    }

    private void Call_Fragment(Fragment frag){
        Fragment fragment = frag;
        FragmentManager fragmentmanager =((AppCompatActivity)getActivity()).getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =fragmentmanager.beginTransaction();
        fragmentTransaction.addToBackStack(fragment.getTag());
        fragmentTransaction.replace(R.id.fragment_layout,fragment);
        fragmentTransaction.commit();
    }

}
