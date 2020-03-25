package com.icss.shopmax.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.github.chuross.library.ExpandableLayout;
import com.icss.shopmax.R;

public class Profile_fragment extends Fragment {

    private TextView editprofile;
    private ExpandableLayout expandableLayout;
    private ScrollView scrolllyt;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_profile, container, false);

        editprofile = root.findViewById(R.id.editprof_buttn);
        expandableLayout = root.findViewById(R.id.expandableLayout);
        scrolllyt = root.findViewById(R.id.Scrolllyt);

        Toolbar toolbar = root.findViewById(R.id.prof_toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).onBackPressed();
            }
        });


        editprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandableLayout.collapse();
                scrolllyt.setVisibility(View.VISIBLE);
            }
        });
        return root;
    }
}