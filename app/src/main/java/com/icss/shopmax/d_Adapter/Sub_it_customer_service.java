package com.icss.shopmax.d_Adapter;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.icss.shopmax.API_Retro.Api_Para;
import com.icss.shopmax.API_Retro.Retrofit_Client;
import com.icss.shopmax.A_Model.AddBookingIT;
import com.icss.shopmax.All_Services_Class.MainActivity;
import com.icss.shopmax.All_Services_Class.Sub_Category.Technical_Sub_Fragment;
import com.icss.shopmax.Apputils.AppPrefrences;
import com.icss.shopmax.R;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Sub_it_customer_service extends Fragment {
    private DatePickerDialog picker;
    Toolbar toolbar;
    private EditText etitname, etitmdlname, etitlast, etitmobile, etitemail, etitaddress, etitdistrict, etitcity, etitdate;
    private Button btnitsubmit;
    private Api_Para apiPara;
    private String sub_service_id, serviceType;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_it_customer, container, false);
        apiPara = Retrofit_Client.getAPIService();
        toolbar = view.findViewById(R.id.its_toolbar);
        etitname = view.findViewById(R.id.etit_Fisrtname);
        etitmdlname = view.findViewById(R.id.etit_mdlName);
        etitlast = view.findViewById(R.id.etit_last_name);
        etitmobile = view.findViewById(R.id.etit_phone);
        etitemail = view.findViewById(R.id.etit_email);
        etitaddress = view.findViewById(R.id.etit_address);
        etitdistrict = view.findViewById(R.id.etit_district);
        etitcity = view.findViewById(R.id.etit_city);
        etitdate = view.findViewById(R.id.etit_date);
        btnitsubmit = view.findViewById(R.id.btn_itsubmit);
        Bundle bundle = this.getArguments();

        if (bundle != null) {
            // handle your code here.
            sub_service_id = bundle.getString("sub_service_id");
            serviceType = bundle.getString("TYPE");
        }

        etitdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(getActivity(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                if (dayOfMonth < 10) {
                                    etitdate.setText("0" + dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                                } else {
                                    etitdate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                                }
                            }
                        }, year, month, day);
                Log.d("mill sec is", "" + System.currentTimeMillis());
                picker.getDatePicker().setMinDate((System.currentTimeMillis() + TimeUnit.DAYS.toMillis(1)));
                // picker.getDatePicker().setMinDate( (System.currentTimeMillis() -10000000) );
//                    picker.getDatePicker().getCalendarView().setMinDate();
                picker.show();
            }
        });


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).onBackPressed();
            }
        });

        btnitsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (etitname.getText().toString().length() != 0) {
                    if (etitlast.getText().toString().length() != 0) {
                        if (etitmobile.getText().toString().length() == 10) {
                            if (Pattern.matches("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$", etitemail.getText().toString())) {
                                if (etitaddress.getText().toString().length() != 0) {
                                    if (etitdistrict.getText().toString().length() != 0) {
                                        if (etitcity.getText().toString().length() != 0) {
                                            if (etitdate.getText().toString().length() != 0) {
                                                String fName = etitname.getText().toString().trim();
                                                String mName = etitmdlname.getText().toString().trim();
                                                String lName = etitlast.getText().toString().trim();
                                                String mobile = etitmobile.getText().toString().trim();
                                                String email = etitemail.getText().toString().trim();
                                                String address = etitaddress.getText().toString().trim();
                                                String district = etitdistrict.getText().toString().trim();
                                                String city = etitcity.getText().toString().trim();
                                                String date = etitdate.getText().toString().trim();
                                                if (serviceType.equals("IT_SERVICE")) {
                                                    addITBooking1(fName, mName, lName, mobile, email, address, district, city, date);
                                                } else if (serviceType.equals("TECHNICAL_SERVICE")) {
                                                    addTechnicalBooking(fName, mName, lName, mobile, email, address, district, city, date);
                                                }

                                            } else {
                                                etitdate.setError("required field");
                                                etitdate.requestFocus();
                                            }
                                        } else {
                                            etitcity.setError("required field");
                                            etitcity.requestFocus();
                                        }
                                    } else {
                                        etitdistrict.setError("required field");
                                        etitdistrict.requestFocus();
                                    }
                                } else {
                                    etitaddress.setError("required field");
                                    etitaddress.requestFocus();

                                }
                            } else {
                                etitemail.setError("required field");
                                etitemail.requestFocus();

                            }
                        } else {
                            etitmobile.setError("required field");
                            etitmobile.requestFocus();

                        }
                    } else {
                        etitlast.setError("required field");
                        etitlast.requestFocus();

                    }
                } else {
                    etitname.setError("required field");
                    etitname.requestFocus();
                }

            }
        });


        return view;
    }

    private void addTechnicalBooking(String fName, String mName, String lName, String mobile, String email, String address, String district, String city, String date) {
        String user_id = AppPrefrences.getUserid(getActivity());
        Retrofit_Client.getAPIService().addTechnicalBooking(user_id.trim(), sub_service_id.trim(), fName, mName, lName, email, mobile, address, district, city, date).enqueue(new Callback<AddBookingIT>() {
            @Override
            public void onResponse(Call<AddBookingIT> call, Response<AddBookingIT> response) {
                if (response.isSuccessful()) {
                    if (response.body().getResponse()) {
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragment_layout, new Technical_Sub_Fragment())
                                .addToBackStack(new Technical_Sub_Fragment().getTag()).commit();
                    }
                }
            }

            @Override
            public void onFailure(Call<AddBookingIT> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addITBooking1(String fName, String mName, String lName, String mobile, String email, String address, String district, String city, String date) {
        String user_id = AppPrefrences.getUserid(getActivity());
        Retrofit_Client.getAPIService().addITBooking(user_id.trim(), sub_service_id.trim(), fName, mName, lName, email, mobile, address, district, city, date).enqueue(new Callback<AddBookingIT>() {
            @Override
            public void onResponse(Call<AddBookingIT> call, Response<AddBookingIT> response) {
                if (response.isSuccessful()) {
                    if (response.body().getResponse()) {
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragment_layout, new Technical_Sub_Fragment())
                                .addToBackStack(new Technical_Sub_Fragment().getTag()).commit();
                    }
                }
            }

            @Override
            public void onFailure(Call<AddBookingIT> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
