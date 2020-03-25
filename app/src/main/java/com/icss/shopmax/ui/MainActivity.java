package com.icss.shopmax.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;


import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.ui.AppBarConfiguration;

import com.google.android.material.navigation.NavigationView;
import com.icss.shopmax.Apputils.AppPrefrences;
import com.icss.shopmax.Apputils.Utilview;
import com.icss.shopmax.R;
import com.icss.shopmax.View.Login_Activity;
import com.icss.shopmax.ui.Navigation.About_us_fragment;
import com.icss.shopmax.ui.Navigation.Contact_us_fragment;
import com.icss.shopmax.ui.Navigation.My_Wallet_Fragment;
import com.icss.shopmax.ui.Navigation.My_offers_fragment;
import com.icss.shopmax.ui.Navigation.Pay_option_fragment;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.viewpump.ViewPump;
import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    NavigationView navigationView;
    DrawerLayout drawer;

    private FragmentManager fragmentmanager;
    private FragmentTransaction fragmentTransaction;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        fragment = new HomeFragment();
        fragmentmanager = getSupportFragmentManager();
        fragmentTransaction =fragmentmanager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_layout,fragment);
        fragmentTransaction.commit();
        setUpNavigationView();
         ViewPump.init(ViewPump.builder()
                .addInterceptor(new CalligraphyInterceptor(
                        new CalligraphyConfig.Builder()
                                .setDefaultFontPath("fonts/Roboto-Regular.ttf")
                                .setFontAttrId(R.attr.fontPath)
                                .build())).build());
    }

     @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        closeDrawer();
    }

    public void openDrawer() {
        Utilview.hidekeyboard(MainActivity.this);
        drawer.openDrawer(GravityCompat.START);    }

    public void closeDrawer() {
        drawer.closeDrawers();
    }

    public void lockDrawer(){  drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);  }

    public void unlockDrawer(){ drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED); }

    private void setUpNavigationView()
    {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
            {
             @Override
             public boolean onNavigationItemSelected(@NonNull MenuItem item) {
             switch (item.getItemId())
             {
                 case R.id.nav_home:
                     fragment = new HomeFragment();
                     fragmentmanager = getSupportFragmentManager();
                     fragmentTransaction = fragmentmanager.beginTransaction();
                     fragmentTransaction.replace(R.id.fragment_layout,fragment);
                     fragmentTransaction.commit();
                     closeDrawer();
                     break;

                 case R.id.nav_profile:
                     fragment = new Profile_fragment();
                     fragmentmanager = getSupportFragmentManager();
                     fragmentTransaction = fragmentmanager.beginTransaction();
                     fragmentTransaction.replace(R.id.fragment_layout,fragment);
                     fragmentTransaction.addToBackStack(fragment.getTag());
                     fragmentTransaction.commit();
                     closeDrawer();
                     break;

                 case R.id.nav_aboutus:
                     fragment = new About_us_fragment();
                     fragmentmanager = getSupportFragmentManager();
                     fragmentTransaction = fragmentmanager.beginTransaction();
                     fragmentTransaction.replace(R.id.fragment_layout,fragment);
                     fragmentTransaction.addToBackStack(fragment.getTag());
                     fragmentTransaction.commit();
                     closeDrawer();
                     break;

                 case R.id.nav_contactus:
                     fragment = new Contact_us_fragment();
                     fragmentmanager = getSupportFragmentManager();
                     fragmentTransaction = fragmentmanager.beginTransaction();
                     fragmentTransaction.replace(R.id.fragment_layout,fragment);
                     fragmentTransaction.addToBackStack(fragment.getTag());
                     fragmentTransaction.commit();
                     closeDrawer();
                     break;

                 case R.id.nav_wallet:
                     fragment = new My_Wallet_Fragment();
                     fragmentmanager = getSupportFragmentManager();
                     fragmentTransaction = fragmentmanager.beginTransaction();
                     fragmentTransaction.replace(R.id.fragment_layout,fragment);
                     fragmentTransaction.addToBackStack(fragment.getTag());
                     fragmentTransaction.commit();
                     closeDrawer();
                     break;

                 case R.id.nav_services: closeDrawer();

                 case R.id.nav_offer:
                     fragment = new My_offers_fragment();
                     fragmentmanager = getSupportFragmentManager();
                     fragmentTransaction = fragmentmanager.beginTransaction();
                     fragmentTransaction.replace(R.id.fragment_layout,fragment);
                     fragmentTransaction.addToBackStack(fragment.getTag());
                     fragmentTransaction.commit();
                     closeDrawer();
                     break;

                 case R.id.nav_pay:
                     fragment = new Pay_option_fragment();
                     fragmentmanager = getSupportFragmentManager();
                     fragmentTransaction = fragmentmanager.beginTransaction();
                     fragmentTransaction.replace(R.id.fragment_layout,fragment);
                     fragmentTransaction.addToBackStack(fragment.getTag());
                     fragmentTransaction.commit();
                     closeDrawer();
                     break;

                 case R.id.nav_logout:
                     AppPrefrences.setLogin_status(MainActivity.this, false);
                     Intent in = new Intent(MainActivity.this, Login_Activity.class);
                     startActivity(in);
                     finish();
                     break;

             }
                 return true;
             }
            }
        );
    }


}
