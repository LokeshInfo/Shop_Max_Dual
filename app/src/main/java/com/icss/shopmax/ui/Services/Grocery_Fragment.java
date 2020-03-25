package com.icss.shopmax.ui.Services;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.icss.shopmax.R;
import com.icss.shopmax.ui.MainActivity;
import com.icss.shopmax.ui.Sub_Category.Cart_Fragment;
import com.icss.shopmax.ui.Sub_Category.Sub_Add_Grocery_Fragment;
import com.icss.shopmax.ui.Sub_Category.Sub_Grocery_Fragment;

public class Grocery_Fragment extends Fragment
{
    LinearLayout food, non_food, add_food;
    ImageView img1, img2, img3, img4,img5,img6;
    Toolbar toolbar;
    RecyclerView recyclerView;
    Button ckeckOutBT;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_grocery_orders,container,false);

        toolbar = view.findViewById(R.id.grocery_toolbar);
        recyclerView = view.findViewById(R.id.recycler_grocery);
        ckeckOutBT= view.findViewById(R.id.buttn_viewcart);

        food = view.findViewById(R.id.foodlyt);
        non_food = view.findViewById(R.id.non_foodlyt);
        add_food = view.findViewById(R.id.additional_lyt);
        img1 = view.findViewById(R.id.gi1);
        img2 = view.findViewById(R.id.gi2);
        img3 = view.findViewById(R.id.gi3);
        img4 = view.findViewById(R.id.gi11);
        img5 = view.findViewById(R.id.gi22);
        img6 = view.findViewById(R.id.gi33);

        Click_Listeners();
        img_load();
        ckeckOutBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new Cart_Fragment();
                FragmentManager fragmentmanager =getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction =fragmentmanager.beginTransaction();
                fragmentTransaction.addToBackStack(fragment.getTag());
                fragmentTransaction.replace(R.id.fragment_layout,fragment);
                fragmentTransaction.commit();
            }
        });

        return view;
    }


    private void Click_Listeners(){
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).onBackPressed();
            }
        });

        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call_Fragment("A", new Sub_Grocery_Fragment());
            }
        });

        non_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call_Fragment("v", new Sub_Grocery_Fragment());
            }
        });

        add_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call_Fragment("S",new Sub_Add_Grocery_Fragment());
            }
        });
    }

    private void img_load()
    {
        String g1 = "https://hellenicgrocery.co.uk/wp-content/uploads/2019/04/85.jpg" ;     // rice
        String g2 = "https://5.imimg.com/data5/IQ/ST/MY-55300537/wheat-flour-500x500.jpg" ; // wheat
        String g3 = "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/shopping-bag-full-of-fresh-vegetables-and-fruits-royalty-free-image-1128687123-1564523576.jpg?crop=0.669xw:1.00xh;0.300xw,0&resize=640:*" ;  // vegetables
        String g4 = "https://thumbs.dreamstime.com/t/composition-colgate-products-poznan-poland-may-brand-oral-hygiene-such-as-toothpastes-toothbrushes-mouthwashes-92146435.jpg" ;  // colgate // dish wash // pen
        String g5 = "https://img3.exportersindia.com/product_images/bc-full/dir_169/5055867/dish-wash-liquid-1529043953-3965227.jpg" ;
        String g6 = "https://images.unsplash.com/photo-1523292643061-ed55f8c45178?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80" ;


        Glide.with(getActivity()).load(g1).into(img1);
        Glide.with(getActivity()).load(g3).into(img2);
        Glide.with(getActivity()).load(g2).into(img3);
        Glide.with(getActivity()).load(g4).into(img4);
        Glide.with(getActivity()).load(g5).into(img5);
        Glide.with(getActivity()).load(g6).into(img6);
    }

    private void Call_Fragment(String typ, Fragment fragment){
        Bundle args = new Bundle();
        args.putString("type",typ);
        fragment.setArguments(args);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout,fragment)
                .addToBackStack(fragment.getTag()).commit();
        }

}
