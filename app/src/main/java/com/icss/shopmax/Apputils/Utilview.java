package com.icss.shopmax.Apputils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.icss.shopmax.R;


public class Utilview
{
    static int v_session = 0;
    static int v_status = 0;
    static int v_type = 0;

    public static void fontEdittext(final EditText editTxt, Activity activity)
    {
        /*Typeface type = Typeface.createFromAsset(activity.getAssets(),"fonts/Roboto-Regular.ttf");
        editTxt.setTypeface(type);*/
//        final EditText edtx = editTxt;

        final Typeface type = Typeface.createFromAsset(activity.getAssets(),"fonts/Roboto-Regular.ttf");
        final Typeface type_hin = Typeface.createFromAsset(activity.getAssets(),"fonts/Roboto-Thin.ttf");

        editTxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length()==0)
                {  editTxt.setTypeface(type_hin);     }
                else
                {editTxt.setTypeface(type);     }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


    public static void hidekeyboard(Activity activity)
    {
        InputMethodManager inputManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);

        View currentFocusedView = activity.getCurrentFocus();
        if (currentFocusedView !=null)
        {
            inputManager.hideSoftInputFromWindow(currentFocusedView.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    public static ArrayAdapter<String> setupAdapter(Activity activity, Spinner spinner, String[] stringArray, String spinner_title) {

        spinner.setPadding(0,0,0,0);
        String[] adapter_array = new String[0];
        if (stringArray.length > 0) {
            adapter_array = new String[stringArray.length + 1];
            adapter_array[0] = spinner_title;
            for (int i = 0; i < stringArray.length; i++) {
                adapter_array[i + 1] = stringArray[i];
            }
        }
        if (stringArray.length <= 0) {
            adapter_array = new String[1];
            adapter_array[0] = spinner_title;
        }
        // Initializing an ArrayAdapter
        final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(activity, R.layout.spinner_text_item, adapter_array) {
            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);

                TextView tv = (TextView) view.findViewById(R.id.textView1);
                if (position == 0) {
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };
        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_text_item);
        spinner.setAdapter(spinnerArrayAdapter);

        return spinnerArrayAdapter;
    }

    public static boolean isEmail(String email){
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email.trim()).matches();
    }

    public static boolean validCellPhone(String number)
    {
        return  !TextUtils.isEmpty(number) && (number.length()==10) && android.util.Patterns.PHONE.matcher(number).matches();
    }

    public static int val_session(int val)
    {
        v_session = val;
        return v_session;
    }

    public static int get_session()
    {
        return v_session;
    }

    public static int val_status(int val)
    {
        v_status = val;
        return v_status;
    }

    public static int get_status()
    {
        return v_status;
    }

    public static int val_type(int val)
    {
        v_type = val;
        return v_type;
    }

    public static int get_type()
    {
        return v_type;
    }

}
