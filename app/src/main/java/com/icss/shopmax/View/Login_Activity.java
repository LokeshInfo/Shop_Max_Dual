package com.icss.shopmax.View;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.icss.shopmax.API_Retro.Api_Para;
import com.icss.shopmax.API_Retro.Retrofit_Client;
import com.icss.shopmax.A_Model.Login_Model;
import com.icss.shopmax.A_Model.Login_mmodel;
import com.icss.shopmax.Apputils.AppPrefrences;
import com.icss.shopmax.R;
import com.icss.shopmax.ui.MainActivity;
import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.viewpump.ViewPump;
import io.github.inflationx.viewpump.ViewPumpContextWrapper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login_Activity extends AppCompatActivity
{
    Button login;
    TextView txforgotpass, register;
    private EditText ed_email, ed_password;
    private Api_Para ApiService;
    private Activity activity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = (Button) findViewById(R.id.button_login);
        register = (TextView) findViewById(R.id.tx_signup);
        txforgotpass = (TextView) findViewById(R.id.tx_forgetpass);
        ed_email = findViewById(R.id.ed_email);
        ed_password = findViewById(R.id.ed_password);
        activity = Login_Activity.this;
        ApiService = Retrofit_Client.getAPIService();

        Click_Listeners();
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


    private void Click_Listeners(){
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()){
                    CALL_API();
                }
                else{
                }
               /* Intent in = new Intent(Login_Activity.this, MainActivity.class);
                startActivity(in);
                finish();*/
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Login_Activity.this, Register_Activity.class);
                startActivity(in);
            }
        });
        txforgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Login_Activity.this, Forget_Activity.class);
                startActivity(in);
            }
        });
    }

    private Boolean validate(){
        String usernm = ed_email.getText().toString();
        String password = ed_password.getText().toString();

        if (usernm.matches("") && password.matches("")){
            ed_email.setError("Required field");
            ed_password.setError("Required field");
            Toast.makeText(this, "Please enter all fields correctly...", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (usernm.matches("")){
            ed_email.setError("Required field");
            return false;
        }
        else if (password.matches("")){
            ed_password.setError("Required field");
            return false;
        }
        else
        {            return true;        }

    }

    private void CALL_API(){
        String usernm = ed_email.getText().toString().trim();
        String pass = ed_password.getText().toString().trim();

        final ProgressDialog dialog;
        dialog = new ProgressDialog(Login_Activity.this);
        dialog.setMessage(" Login User ");
        dialog.setCancelable(true);
        dialog.show();

        ApiService.CALL_LOGIN(usernm,pass).enqueue(new Callback<Login_mmodel>() {
            @Override
            public void onResponse(Call<Login_mmodel> call, Response<Login_mmodel> response) {
                dialog.dismiss();
                Log.e("Call_Login RESPONSE.", "" + new Gson().toJson(response.body()));

                if (response.body().getResponse().equals("true")){

                    AppPrefrences.setLogin_status(activity,true);
                    AppPrefrences.setUserid(activity,response.body().getUser_id());
                    AppPrefrences.setName(activity,response.body().getUsername());
                    AppPrefrences.setMail(activity,response.body().getEmail());;
                    AppPrefrences.setMobile(activity,response.body().getPhone());

                    Intent in = new Intent(Login_Activity.this, MainActivity.class);
                    startActivity(in);
                    finish();
                }
                else if (!response.body().getResponse().equals("true")){
                    Toast.makeText(Login_Activity.this, ""+response.body().getError_msg(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Login_mmodel> call, Throwable t) {

                dialog.dismiss();
                Log.e("CALL_LOGIN Error "," "+t.getMessage());
                Log.e("CALL_LOGIN Error "," "+t.getLocalizedMessage());
                Log.e("CALL_LOGIN Error "," "+t.getCause());
            }
        });


    }

}
