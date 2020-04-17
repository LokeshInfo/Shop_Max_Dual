package com.icss.shopmax.All_Services_Class.Sub_Category;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.icss.shopmax.Model.Food_Menu_Model;
import com.icss.shopmax.R;
import com.icss.shopmax.All_Services_Class.MainActivity;

import java.util.ArrayList;
import java.util.List;


public class Tab_Food_Order_Fragment extends Fragment {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Toolbar toolbar;
    private Button checkout;
    private ArrayList<Food_Menu_Model> dlist;
    private ArrayList<Food_Menu_Model> dlist1;
    private ArrayList<Food_Menu_Model> dlist2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_sub_food_order,container,false);

        viewPager = view.findViewById(R.id.viewpager);
        tabLayout = view.findViewById(R.id.tabs);
        toolbar = view.findViewById(R.id.sub_foododr_toolbar);
        checkout = view.findViewById(R.id.fd_chkout);

        String name = getArguments().getString("rname");
        toolbar.setTitle(name);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).onBackPressed();          }     });

        pre_data();
        setUpViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);

        LinearLayout linearLayout = (LinearLayout)tabLayout.getChildAt(0);
        linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        GradientDrawable drawable = new GradientDrawable();
        drawable.setColor(Color.WHITE);
        drawable.setSize(1, 1);
        linearLayout.setDividerPadding(10);
        linearLayout.setDividerDrawable(drawable);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                viewPager.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activ = (AppCompatActivity) v.getContext();
                Fragment fragment = new Ckeckout_fragment();
                FragmentManager fragmentmanager =activ.getSupportFragmentManager();
                FragmentTransaction fragmentTransaction =fragmentmanager.beginTransaction();
                fragmentTransaction.addToBackStack(fragment.getTag());
                fragmentTransaction.replace(R.id.fragment_layout,fragment);
                fragmentTransaction.commit();

              //  getActivity().getSupportFragmentManager().beginTransaction().
                //                //        replace(R.id.fragment_layout,new Payment_Fragment()).addToBackStack(new Payment_Fragment().getTag()).commit();
            }
        });

        return view;
    }

    private void setUpViewPager(ViewPager viewPager) {
        aAdapter adapter = new aAdapter(getChildFragmentManager());
        adapter.addFragment(new Food_Order_Menu_Fragment(dlist), "Veg");
        adapter.addFragment(new Food_Order_Menu_Fragment(dlist1), "Non Veg");
        adapter.addFragment(new Food_Order_Menu_Fragment(dlist2), "Snacks");
        viewPager.setAdapter(adapter);
    }

    private void pre_data(){
        dlist = new ArrayList<>();
        dlist1 = new ArrayList<>();
        dlist2 = new ArrayList<>();

        dlist.add(new Food_Menu_Model("Butter Paneer","200","Chilly gravy with extra butter make it more tasty.",1));
        dlist.add(new Food_Menu_Model("Pav Bhaji","300","Delicious Pav and bhaji",1));
        dlist.add(new Food_Menu_Model("Chhola Bhatura","250","Delicious Chola with extra cheese",1));
        dlist.add(new Food_Menu_Model("Fried Rice","130","Rice with lemon flavour tasty and delicious...",1));
        dlist.add(new Food_Menu_Model("Bread Pakora","160","Tasty and Delicious",1));
        dlist.add(new Food_Menu_Model("Vada Pav","120","Tasty and Delicious",1));
        dlist.add(new Food_Menu_Model("Veg Maggie","100","Tasty and Delicious",1));
        dlist.add(new Food_Menu_Model("Hakka Noodles","170","Tasty and Delicious",1));
        dlist.add(new Food_Menu_Model("Alu Cheese Paratha","90","Tasty and Delicious",1));


        dlist1.add(new Food_Menu_Model("Chicken Soup","100","Tasty and Delicious",1));
        dlist1.add(new Food_Menu_Model("Chicken Lollipop","450","Tasty and Delicious",1));
        dlist1.add(new Food_Menu_Model("Chicken Fried Price","300","Tasty and Delicious",1));
        dlist1.add(new Food_Menu_Model("Chicken 65","250","Tasty and Delicious",1));
        dlist1.add(new Food_Menu_Model("Fish Fry 65","150","Tasty and Delicious",1));
        dlist1.add(new Food_Menu_Model("Steam Rice","90","Tasty and Delicious",1));
        dlist1.add(new Food_Menu_Model("Boiled Egg","200","Tasty and Delicious",1));

        dlist2.add(new Food_Menu_Model("Burger","100","Tasty and Delicious",1));
        dlist2.add(new Food_Menu_Model("Cheese Sandwhich","222","Tasty and Delicious",1));
        dlist2.add(new Food_Menu_Model("Donuts","340","Tasty and Delicious",1));
        dlist2.add(new Food_Menu_Model("Finger Chips","250","Tasty and Delicious",1));
        dlist2.add(new Food_Menu_Model("French Fries","350","Tasty and Delicious",1));
        dlist2.add(new Food_Menu_Model("Pizza","120","Tasty and Delicious",1));
        dlist2.add(new Food_Menu_Model("Hot Dog","110","Tasty and Delicious",1));
        dlist2.add(new Food_Menu_Model("PopCorn","200","Tasty and Delicious",1));
    }

    public class aAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public aAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getItemPosition(@NonNull Object object) {
            return POSITION_NONE;
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
            ///
        }
    }


}
