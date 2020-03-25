package com.icss.shopmax.ui.Sub_Category;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.icss.shopmax.R;
import com.icss.shopmax.ui.MainActivity;
import com.icss.shopmax.ui.Payment_Fragment;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class Sub_It_Service extends Fragment
{
    Button submit;
    private DatePickerDialog picker;
    Toolbar toolbar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_sub_itservice,container,false);
        toolbar = view.findViewById(R.id.its_toolbar);
        submit = view.findViewById(R.id.buttn_itsubmit);
        final EditText edfrom = (EditText)view.findViewById(R.id.ed_fromdate);
        final EditText edto = (EditText) view.findViewById(R.id.ed_todate);
        Click_Listeners();

        edfrom.setOnClickListener(new View.OnClickListener() {
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
                                if (dayOfMonth<10)
                                {
                                    edfrom.setText("0"+dayOfMonth + "-" + (monthOfYear + 1) + "-" + year); }
                                else
                                {
                                    edfrom.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                                }
                            }
                        }, year, month, day);
                Log.d("mill sec is",""+System.currentTimeMillis());
                picker.getDatePicker().setMinDate( (System.currentTimeMillis() + TimeUnit.DAYS.toMillis(1)));
                // picker.getDatePicker().setMinDate( (System.currentTimeMillis() -10000000) );
//                    picker.getDatePicker().getCalendarView().setMinDate();
                picker.show();           }       });

        edto.setOnClickListener(new View.OnClickListener() {
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
                                if (dayOfMonth<10)
                                {
                                    edto.setText("0"+dayOfMonth + "-" + (monthOfYear + 1) + "-" + year); }
                                else
                                {
                                    edto.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                                }
                            }
                        }, year, month, day);
                Log.d("mill sec is",""+System.currentTimeMillis());
                picker.getDatePicker().setMinDate( (System.currentTimeMillis() + TimeUnit.DAYS.toMillis(1)));
                // picker.getDatePicker().setMinDate( (System.currentTimeMillis() -10000000) );
//                    picker.getDatePicker().getCalendarView().setMinDate();
                picker.show();
                // buttn_add.setOnClickListener(new View.OnClickListener() {
                //    @Override
                //  public void onClick(View view) {
                //    String frdate,todate;

                //  frdate = edfrom.getText().toString().trim();
                //todate = edto.getText().toString();
//
                //                      if (frdate.isEmpty() || todate.isEmpty()){
                //                        Toast.makeText(activity, "Please enter data correctly...", Toast.LENGTH_SHORT).show();
                //                  }
                //                else if (frdate.isEmpty()){
                //                  Toast.makeText(activity, "Please enter Date From...", Toast.LENGTH_SHORT).show();
                //            }
                //          else if (todate.isEmpty()){
                //            Toast.makeText(activity, "Please enter Date till...", Toast.LENGTH_SHORT).show();
                //      }
                //    else{
                //     Fragment fragment = new Sub_Rent_Car();
                //   FragmentManager fragmentmanager =((AppCompatActivity)activity).getSupportFragmentManager();
                // FragmentTransaction fragmentTransaction =fragmentmanager.beginTransaction();
                // fragmentTransaction.addToBackStack(fragment.getTag());
                // fragmentTransaction.replace(R.id.fragment_layout,fragment);
                //fragmentTransaction.commit();

                //  }
                // }
                //   });
            }       });


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
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_layout,new Payment_Fragment())
                        .addToBackStack(new Payment_Fragment().getTag()).commit();
            }
        });
    }

}
