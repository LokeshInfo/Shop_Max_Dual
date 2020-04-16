package com.icss.shopmax.d_Adapter;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.icss.shopmax.Model.flight_data;
import com.icss.shopmax.R;
import com.icss.shopmax.ui.Sub_Category.Sub_It_Service;
import com.icss.shopmax.ui.Sub_Category.Sub_Rent_Car;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;


public class flight_booking_Adapter extends RecyclerView.Adapter<flight_booking_Adapter.ViewHolder> {

    ArrayList<flight_data> dlist;
    Activity activity;
    private DatePickerDialog picker;
    public flight_booking_Adapter(Activity activity, ArrayList<flight_data> dlist) {
        this.activity = activity;
        this.dlist = dlist;
        setHasStableIds(true);
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public flight_booking_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_book_flight, parent, false);
        return new flight_booking_Adapter.ViewHolder(v);
    }

    public void onBindViewHolder(@NonNull flight_booking_Adapter.ViewHolder holder, final int i) {

        if (holder != null) {

            holder.name.setText(dlist.get(i).getName());
            holder.price.setText(dlist.get(i).getPrice() + " /-");
            holder.type.setText(dlist.get(i).getType());
            holder.edfrom1.setText(dlist.get(i).getDate());
            holder.deptime.setText(dlist.get(i).getDeptime());
            holder.arrtime.setText(dlist.get(i).getArrtime());

            holder.book.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AppCompatActivity activ = (AppCompatActivity) v.getContext();
                    Fragment fragment = new Sub_It_Service();
                    FragmentManager fragmentmanager = activ.getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentmanager.beginTransaction();
                    fragmentTransaction.addToBackStack(fragment.getTag());
                    fragmentTransaction.replace(R.id.fragment_layout, fragment);
                    fragmentTransaction.commit();

                }
            });

//            String i1="data:image/jpeg;base64,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";
//            String i2="data:image/jpeg;base64,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";
//            String i3="data:image/jpeg;base64,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";
//            String i4="data:image/jpeg;base64,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";
//            String i5="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRiBq91N8UcxAKYvv4iyS8llr51GEJYS7FXHul0mI3nECg6-933cA&s";
//            String i6="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSuMLp8rADH3pwNXWq5Y_6cv8wANYbkjxUsYL3nDXLb541Za8wEeg&s";
//            String i7="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSuMLp8rADH3pwNXWq5Y_6cv8wANYbkjxUsYL3nDXLb541Za8wEeg&s";
//            String i8="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSTEru0S_24cCpTwZsPyhv8iwM1_hVYO63WJjknV7mbc78JB4U&s";
//            String i9="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSTEru0S_24cCpTwZsPyhv8iwM1_hVYO63WJjknV7mbc78JB4U&s";
//            String i10="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSTEru0S_24cCpTwZsPyhv8iwM1_hVYO63WJjknV7mbc78JB4U&s";
//            String i11="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSuMLp8rADH3pwNXWq5Y_6cv8wANYbkjxUsYL3nDXLb541Za8wEeg&s";
//
//            String i12 = "" + i6;
//            String u1 = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSTEru0S_24cCpTwZsPyhv8iwM1_hVYO63WJjknV7mbc78JB4U&s";
//            String u2 = "" + i2;
//            String u3 = "" + i3;
//
//            String u4 = "https://q-cf.bstatic.com/images/hotel/max1024x768/208/208119939.jpg";
//            String u5 = "" + u2;
//            String u6 = "" + i11;
//
//            if (i == 0) {
//                Glide.with(activity).load(i1).into(holder.img1);
//                Glide.with(activity).load(i2).into(holder.img3);
//                Glide.with(activity).load(i3).into(holder.img2);
//            }
//
//            if (i == 1) {
//                Glide.with(activity).load(i4).into(holder.img1);
//                Glide.with(activity).load(i5).into(holder.img3);
//                Glide.with(activity).load(i6).into(holder.img2);
//            } else if (i == 2) {
//                Glide.with(activity).load(i7).into(holder.img1);
//                Glide.with(activity).load(i8).into(holder.img2);
//                Glide.with(activity).load(i9).into(holder.img3);
//            } else if (i == 3) {
//                Glide.with(activity).load(i10).into(holder.img1);
//                Glide.with(activity).load(i11).into(holder.img2);
//                Glide.with(activity).load(i12).into(holder.img3);
//            } else if (i == 4) {
//                Glide.with(activity).load(u1).into(holder.img1);
//                Glide.with(activity).load(u2).into(holder.img2);
//                Glide.with(activity).load(u3).into(holder.img3);
//            } else if (i == 5) {
//                Glide.with(activity).load(u4).into(holder.img1);
//                Glide.with(activity).load(u5).into(holder.img2);
//                Glide.with(activity).load(u6).into(holder.img3);
//            } else {
//                Glide.with(activity).load(i7).into(holder.img1);
//                Glide.with(activity).load(i8).into(holder.img2);
//                Glide.with(activity).load(i9).into(holder.img3);
//            }
//
    }

    }

    public int getItemCount() {
        return dlist.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView name, price, type,edfrom1,deptime,arrtime;
        ImageView img1, img2, img3;
        Button book;

        public ViewHolder(View itemview){
            super(itemview);
            name = itemview.findViewById(R.id.tx_carname);
          price = itemview.findViewById(R.id.tx_carprice);
//            img1 = itemview.findViewById(R.id.img1);
//            img2 = itemview.findViewById(R.id.img2);
//            img3 = itemview.findViewById(R.id.img3);
            book = itemview.findViewById(R.id.buttn_book);
            type=itemview.findViewById(R.id.tx_cartype);
            edfrom1=itemview.findViewById(R.id.ed_fromdate);
            deptime =itemview.findViewById(R.id.tx_deptime);
            arrtime =itemview.findViewById(R.id.tx_arrtime);
        }
    }

    private void show_dilog()
    {
        final Dialog dialogView = new Dialog(activity);
        dialogView.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialogView.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogView.setContentView(R.layout.dialog_rent_hotel);

        Window window = dialogView.getWindow();
        window.setLayout(WindowManager.LayoutParams.FILL_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        final EditText edfrom = (EditText) dialogView.findViewById(R.id.ed_fromdate);
        final EditText edto = (EditText) dialogView.findViewById(R.id.ed_todate);
        Button buttn_add = (Button) dialogView.findViewById(R.id.buttn_bookcard);


        edfrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(activity,
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
                picker = new DatePickerDialog(activity,
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
                picker.show();           }       });


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
                    dialogView.dismiss();
                }
            }
        });
        dialogView.show();
        dialogView.setCanceledOnTouchOutside(true);
    }

}