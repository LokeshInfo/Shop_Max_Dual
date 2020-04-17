package com.icss.shopmax.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.icss.shopmax.Apputils.AppPrefrences;
import com.icss.shopmax.R;
import com.icss.shopmax.All_Services_Class.MainActivity;

import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.viewpump.ViewPump;
import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class Splash_Activity extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        Thread backgound = new Thread(){
            public void run()
            { try{
                sleep(2 * 1000);
                go_next();

            }      catch(Exception e)
            {      e.printStackTrace();            } }
        };

        backgound.start();
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

    private void go_next(){

        if(AppPrefrences.getLogin_status(Splash_Activity.this)) {
            Intent in = new Intent(Splash_Activity.this, MainActivity.class);
            startActivity(in);
            finish();
        }
        else{
            Intent in = new Intent(Splash_Activity.this, Login_Activity.class);
            startActivity(in);
            finish();
        }
    }

}
