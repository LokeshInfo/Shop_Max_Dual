package com.icss.shopmax.ui.Services;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import nl.dionsegijn.steppertouch.OnStepCallback;
import nl.dionsegijn.steppertouch.StepperTouch;

import com.icss.shopmax.Model.Food_Menu_Model;
import com.icss.shopmax.Model.qty_hotel_data;
import com.icss.shopmax.R;
import com.icss.shopmax.ui.MainActivity;
import com.icss.shopmax.ui.Sub_Category.Sub_Rent_Car;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class Hotel_Fragment extends Fragment
{

    RecyclerView recyclerView;
    Button book;
    EditText edfrom,edto;
    Button buttn_add;
    Activity activity;
    ImageView image, add, remove,add2,remove2,add3,remove3;
    TextView tx_qty,tx_qty3,tx_qty2;
    int counter = 0;
    StepperTouch stepperTouch;

    private DatePickerDialog picker;

    @Nullable
    @Override



    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_hotel, container, false);

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).onBackPressed();
            }
        });

//        StepperTouch stepperTouch =view.findViewById(R.id.stepperTouch);
//        stepperTouch.setMinValue(0);
//        stepperTouch.setMaxValue(100);
//        stepperTouch.setSideTapEnabled(true);
//        stepperTouch.addStepCallback(new OnStepCallback() {
//            @Override
//            public void onStep(int value, boolean positive) {
//                Toast.makeText(getActivity(), value + "", Toast.LENGTH_SHORT).show();
//            }
//        });



        book = view.findViewById(R.id.buttn_search);
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new RentHotel_fragment();
                FragmentManager fragmentmanager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentmanager.beginTransaction();
                fragmentTransaction.addToBackStack(fragment.getTag());
                fragmentTransaction.replace(R.id.fragment_layout, fragment);
                fragmentTransaction.commit();
            }
        });

        edfrom = view.findViewById(R.id.ed_fromdate);
        edto = view.findViewById(R.id.ed_todate);
        buttn_add = view.findViewById(R.id.buttn_calc);

        add = view.findViewById(R.id.fdadd_item);
        remove = view.findViewById(R.id.fdremove_item);
        tx_qty = (TextView)view.findViewById(R.id.fd_qty_item);

        add2 = view.findViewById(R.id.fdadd_item2);
        remove2 = view.findViewById(R.id.fdremove_item2);
        tx_qty2 = (TextView)view.findViewById(R.id.fd_qty_item2);

        add3 = view.findViewById(R.id.fdadd_item3);
        remove3 = view.findViewById(R.id.fdremove_item3);
        tx_qty3 = (TextView)view.findViewById(R.id.fd_qty_item3);




            tx_qty.setText("0");
            tx_qty2.setText("0");
            tx_qty3.setText("0");


        add.setOnClickListener(new View.OnClickListener() {
          @Override
            public void onClick(View v) {

                    counter = counter + 1;
                    tx_qty.setText(String.valueOf(counter));

            }
        });
        remove.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
                if( counter>0){
                    counter = counter - 1;
                    tx_qty.setText(String.valueOf(counter));
                }
            }
        });

        add2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter = counter + 1;
                tx_qty2.setText(String.valueOf(counter));
            }
        });
        remove2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( counter>0) {
                counter = counter - 1;
                tx_qty2.setText(String.valueOf(counter));
            }}
        });

        add3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter = counter + 1;
                tx_qty3.setText(String.valueOf(counter));
            }
        });
        remove3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( counter>0) {
                    counter = counter - 1;
                    tx_qty3.setText(String.valueOf(counter));
                }
            }
        });


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
                buttn_add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String frdate,todate;

                        frdate = edfrom.getText().toString().trim();
                        todate = edto.getText().toString();

                        if (frdate.isEmpty() || todate.isEmpty()){
                            Toast.makeText(activity, "Please enter data correctly...", Toast.LENGTH_SHORT).show();
                        }
                        else if (frdate.isEmpty()){
                            Toast.makeText(activity, "Please enter Date From...", Toast.LENGTH_SHORT).show();
                        }
                        else if (todate.isEmpty()){
                            Toast.makeText(activity, "Please enter Date till...", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Fragment fragment = new Sub_Rent_Car();
                            FragmentManager fragmentmanager =((AppCompatActivity)activity).getSupportFragmentManager();
                            FragmentTransaction fragmentTransaction =fragmentmanager.beginTransaction();
                            fragmentTransaction.addToBackStack(fragment.getTag());
                            fragmentTransaction.replace(R.id.fragment_layout,fragment);
                            fragmentTransaction.commit();

                        }
                    }
                });
            }       });




        return view;


    }




}
