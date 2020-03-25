package com.icss.shopmax.ui.Sub_Category;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.google.gson.Gson;
import com.icss.shopmax.API_Retro.Retrofit_Client;
import com.icss.shopmax.A_Model.Doc_Book_Model;
import com.icss.shopmax.Apputils.AppPrefrences;
import com.icss.shopmax.Apputils.Utilview;
import com.icss.shopmax.R;
import com.icss.shopmax.View.Login_Activity;
import com.icss.shopmax.ui.MainActivity;
import com.icss.shopmax.ui.Payment_Fragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Patient_Details_Fragment extends Fragment
{
    Button submit;
    Toolbar toolbar;
    RadioGroup radioGroup;
    private EditText edname, edmail, edphone, edrequest, edage;
    private String name, mail, phone, request, age, gender="";
    private String user_id, hospital_id, doctor_id;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_patient_details,container,false);
        toolbar = view.findViewById(R.id.patient_toolbar);
        submit = view.findViewById(R.id.buttn_ptsubmit);
         edname = view.findViewById(R.id.pt_name);
         edphone = view.findViewById(R.id.pt_phone);
         edmail = view.findViewById(R.id.pt_mail);
         edrequest = view.findViewById(R.id.pt_request);
         edage = view.findViewById(R.id.pt_age);
         radioGroup = view.findViewById(R.id.radio_group_agg);

         if (getArguments()!=null){
             hospital_id = getArguments().getString("h_id");
             doctor_id = getArguments().getString("d_id");
         }

         Click_Listeners();

        return view;
    }

    private void Click_Listeners(){

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).onBackPressed();
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_layout,new Payment_Fragment())
                        .addToBackStack(new Payment_Fragment().getTag()).commit();*/

                if (validate()){          book_appt();                }
                else{}

            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rmale){
                    gender="Male";
                }
                else if (checkedId == R.id.rfemale){
                    gender="Female";
                }
                else
                {
                        gender = "";
                }
            }
        });
    }

    private Boolean validate(){

        name = edname.getText().toString();
        phone = edphone.getText().toString();
        mail = edmail.getText().toString();
        request = edrequest.getText().toString();
        age = edage.getText().toString();

        if (name.matches("") && phone.matches("") && mail.matches("") && request.matches("")
                && age.matches("")){
            Toast.makeText(getActivity(), "Please enter all fields correctly...", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (name.matches("")){
            Toast.makeText(getActivity(), "Please enter name...", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (mail.matches("")){
            Toast.makeText(getActivity(), "Please enter email...", Toast.LENGTH_SHORT).show();
            return false;
        }else if (phone.matches("")){
            Toast.makeText(getActivity(), "Please enter phone number...", Toast.LENGTH_SHORT).show();
            return false;
        }else if (age.matches("")){
            Toast.makeText(getActivity(), "Please enter age...", Toast.LENGTH_SHORT).show();
            return false;
        }else if (gender.matches("")){
            Toast.makeText(getActivity(), "Please select gender...", Toast.LENGTH_SHORT).show();
            return false;
        }
        else
        {            return true;        }

    }

    private void book_appt(){


        final ProgressDialog dialog;
        dialog = new ProgressDialog(getActivity());
        dialog.setMessage("Submitting request");
        dialog.setCancelable(true);
        dialog.show();

        user_id = AppPrefrences.getUserid(getActivity());

        Retrofit_Client.getAPIService().Book_Doctor(user_id, hospital_id,doctor_id,name,mail,phone,gender,age,request).enqueue(new Callback<Doc_Book_Model>() {
            @Override
            public void onResponse(Call<Doc_Book_Model> call, Response<Doc_Book_Model> response) {

                dialog.dismiss();
                Log.e("Book_Doctor RESPONSE.", "" + new Gson().toJson(response.body()));

                if (response.body().getResponse()){
                    getActivity().getSupportFragmentManager().popBackStack();
                    Toast.makeText(getActivity(), "Request for Appointment Submitted...", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getActivity(), "Please try again...", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<Doc_Book_Model> call, Throwable t) {

                dialog.dismiss();
                Log.e("Book_Doctor Error "," "+t.getMessage());
                Log.e("Book_Doctor Error "," "+t.getLocalizedMessage());
                Log.e("Book_Doctor Error "," "+t.getCause());
            }
        });

    }

}
