package com.icss.shopmax.ui.Services;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.icss.shopmax.d_Adapter.SliderAdapter;
import com.icss.shopmax.Model.Slider_Data;
import com.icss.shopmax.R;
import com.icss.shopmax.ui.MainActivity;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.IndicatorView.draw.controller.DrawController;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.widget.Toolbar;

public class Travel_Agent_Fragment extends Fragment {
    Toolbar toolbar;

    SliderView sliderView;
    ImageView img1,img2,img3,img4;

    CardView card1,card2,card3,card4;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.travel_homepage,container,false);

        sliderView = view.findViewById(R.id.imageSlider);
        toolbar = view.findViewById(R.id.travel_toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).onBackPressed();
            }
        });

        init_Slider();

        img1=view.findViewById(R.id.img1);
        img2=view.findViewById(R.id.img2);
        img3=view.findViewById(R.id.img3);
        img4=view.findViewById(R.id.img4);

        card1=view.findViewById(R.id.card1);
     card2=view.findViewById(R.id.card2);
     card3=view.findViewById(R.id.card3);
     card4=view.findViewById(R.id.card4);


        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new checkfare_fragment();
                FragmentManager fragmentmanager =getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction =fragmentmanager.beginTransaction();
                fragmentTransaction.addToBackStack(fragment.getTag());
                fragmentTransaction.replace(R.id.fragment_layout,fragment);
                fragmentTransaction.commit();
            }
        });


        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new makebooking_fragment();
                FragmentManager fragmentmanager =getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction =fragmentmanager.beginTransaction();
                fragmentTransaction.addToBackStack(fragment.getTag());
                fragmentTransaction.replace(R.id.fragment_layout,fragment);
                fragmentTransaction.commit();
            }
        });


        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new profile_fragment();
                FragmentManager fragmentmanager =getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction =fragmentmanager.beginTransaction();
                fragmentTransaction.addToBackStack(fragment.getTag());
                fragmentTransaction.replace(R.id.fragment_layout,fragment);
                fragmentTransaction.commit();
            }
        });

        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new checkbooking_fragment();
                FragmentManager fragmentmanager =getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction =fragmentmanager.beginTransaction();
                fragmentTransaction.addToBackStack(fragment.getTag());
                fragmentTransaction.replace(R.id.fragment_layout,fragment);
                fragmentTransaction.commit();
            }
        });
         img1.setImageResource(R.drawable.download);
         img2.setImageResource(R.drawable.booking);
         img3.setImageResource(R.drawable.profile);
         img4.setImageResource(R.drawable.bookingg);

        return view;
    }

    private void init_Slider()
    {
        List<Slider_Data> ddlist = new ArrayList<>();
        ddlist.add(new Slider_Data("","https://images.news18.com/ibnlive/uploads/2017/07/flight_AFP8.jpg",""));
        ddlist.add(new Slider_Data("","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRx6VvDkHS3ZMp06MiRLWntcHArbktMnwFAyxHhJpE7fcnEZiWj&s",""));
        ddlist.add(new Slider_Data("","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQqdlCmWpg1q5QrwBNak586QvCeUQbmU3Z7F6opeVH-MrXy7frl&s",""));
      //  ddlist.add(new Slider_Data("","https://akm-img-a-in.tosshub.com/indiatoday/images/story/201601/indigo-flight-pic_647_011116025213.jpg",""));
        ddlist.add(new Slider_Data("","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQQapJ_HuxLzZUH89gCfY5hSIJz49K7Ff21UyKZWqSAdTPbIovNxw&s",""));
        ddlist.add(new Slider_Data("","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQog-1DuAoJJcWz0Yz5QviwX_IRVi388-T7AcJexdvoLX4MhGob&s",""));
        ddlist.add(new Slider_Data("","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTFiauZfMLeOc9b_NttJXIE29NkShaDDA2EzXLQUAB-tydHjANm&s",""));

        SliderAdapter slide_adapter = new SliderAdapter(getActivity(),ddlist);
        sliderView.isAutoCycle();
        sliderView.setAutoCycle(true);
        sliderView.setScrollTimeInSec(2);
        sliderView.setSliderAdapter(slide_adapter);
        sliderView.setIndicatorAnimation(IndicatorAnimations.SLIDE); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.CUBEINROTATIONTRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.startAutoCycle();

        sliderView.setOnIndicatorClickListener(new DrawController.ClickListener() {
            @Override
            public void onIndicatorClicked(int position) {
                sliderView.setCurrentPagePosition(position);
            }
        });
    }


}
