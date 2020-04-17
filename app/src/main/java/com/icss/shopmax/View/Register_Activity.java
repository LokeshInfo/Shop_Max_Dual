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
import com.icss.shopmax.API_Retro.Retrofit_Client;
import com.icss.shopmax.A_Model.Login_mmodel;
import com.icss.shopmax.Apputils.AppPrefrences;
import com.icss.shopmax.Apputils.Utilview;
import com.icss.shopmax.R;
import com.icss.shopmax.All_Services_Class.MainActivity;

import cn.pedant.SweetAlert.SweetAlertDialog;
import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.viewpump.ViewPump;
import io.github.inflationx.viewpump.ViewPumpContextWrapper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register_Activity extends AppCompatActivity
{
    private Button signup;
    private EditText ed_name, ed_surname , ed_mail, ed_phone, ed_confirm_password, ed_password;
    private TextView tv_signin;
    private Activity activity = Register_Activity.this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        signup = findViewById(R.id.SignUp);
        ed_name = findViewById(R.id.ed_name);
        ed_surname = findViewById(R.id.ed_surname);
        ed_password = findViewById(R.id.ed_password);
        ed_confirm_password = findViewById(R.id.ed_confirm_password);
        ed_mail = findViewById(R.id.ed_email);
        ed_phone = findViewById(R.id.ed_phonenum);
        tv_signin = findViewById(R.id.tv_signin);

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
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()){
                  CALL_API();
                }
                else{

                }
            }
        });

        tv_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             finish();
            }});
    }

    private Boolean validate(){

        String usernm = ed_name.getText().toString();
        String srname = ed_surname.getText().toString();
        String phone = ed_phone.getText().toString();
        String mail = ed_mail.getText().toString();
        String password = ed_password.getText().toString();
        String conf_pass = ed_confirm_password.getText().toString();

        if (usernm.matches("") && password.matches("") && phone.matches("") && mail.matches("")
                && conf_pass.matches("") && srname.matches("")){
            ed_name.setError("Required field");
            ed_phone.setError("Required field");
            ed_mail.setError("Required field");
            ed_password.setError("Required field");
            ed_confirm_password.setError("Required field");
            ed_surname.setError("Required field");
            Toast.makeText(this, "Please enter all fields correctly...", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (usernm.matches("")){
            ed_name.setError("Required field");
            return false;
        }
        else if (srname.matches("")){
            ed_surname.setError("Required field");
            return false;
        }
        else if (mail.matches("")){
            ed_mail.setError("Required field");
            return false;
        }
        else if (!Utilview.isEmail(mail)){
            ed_mail.setError("Enter valid mail id");
            return false;
        }

        else if (phone.matches("")){
            ed_phone.setError("Required field");
            return false;
        }
        else if (!Utilview.validCellPhone(phone)){
            ed_phone.setError("Enter valid phone");
            return false;
        }
        else if (password.matches("")){
            ed_password.setError("Required field");
            return false;
        }
        else if (!password.equals(conf_pass)){
            ed_confirm_password.setError("Password Not Match");
            return false;
        }
        else
        {            return true;        }
    }

    private void CALL_API(){

        final ProgressDialog dialog;
        dialog = new ProgressDialog(Register_Activity.this);
        dialog.setMessage("Processing");
        dialog.setCancelable(true);
        dialog.show();

        String usernm = ed_name.getText().toString();
        String surnm = ed_surname.getText().toString();
        String phone = ed_phone.getText().toString();
        String mail = ed_mail.getText().toString();
        String password = ed_password.getText().toString();
        String t_code = "";

        Retrofit_Client.getAPIService().CALL_REGISTER(usernm,surnm,mail,phone,password,password).enqueue(new Callback<Login_mmodel>() {
            @Override
            public void onResponse(Call<Login_mmodel> call, Response<Login_mmodel> response) {
                dialog.dismiss();
                Log.e("CALL_REGISTER RESPONSE.", "" + new Gson().toJson(response.body()));

                if (response.body().getResponse().equals("true")){

                    AppPrefrences.setLogin_status(activity,true);
                    AppPrefrences.setUserid(activity,response.body().getUser_id());
                    AppPrefrences.setName(activity,response.body().getUsername());
                    AppPrefrences.setMail(activity,response.body().getEmail());;
                    AppPrefrences.setMobile(activity,response.body().getPhone());

                    Intent in = new Intent(activity, MainActivity.class);
                    startActivity(in);
                    finish();
                }
                else if (!response.body().getResponse().equals("true")){
                    Toast.makeText(activity, ""+response.body().getError_msg(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Login_mmodel> call, Throwable t) {
                dialog.dismiss();
                Log.e("CALL_REGISTER Error "," "+t.getLocalizedMessage());
            }
        });
    }


    private void Login_Dialog(){
        final SweetAlertDialog pDialog = new SweetAlertDialog(Register_Activity.this, SweetAlertDialog.SUCCESS_TYPE);
        pDialog.setTitleText("Registered Successfully");
        pDialog.setContentText("Please Sign In Now");
        pDialog.setConfirmButton("Sign In", new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sweetAlertDialog) {
                pDialog.dismiss();
                finish();
            }
        });
        pDialog.show();
    }


}
