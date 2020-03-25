package com.icss.shopmax.Adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.icss.shopmax.Model.classfieds_Data;
import com.icss.shopmax.R;
import com.icss.shopmax.ui.MainActivity;

import java.util.ArrayList;

public class classfieds_quickbrowse extends Fragment {
    Toolbar toolbar;
    RecyclerView recyclerView1;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quickbrowse,container,false);
        androidx.appcompat.widget.Toolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).onBackPressed();
            }
        });
        recyclerView1 = view.findViewById(R.id.classfieds_recycler_view1);
        pre_Data();
        return  view;

    }

    private void pre_Data() {

        ArrayList<classfieds_Data> dlist = new ArrayList();
        dlist.add(new classfieds_Data("Vehicles",""));
        dlist.add(new classfieds_Data("Properties",""));
        dlist.add(new classfieds_Data("Commercial Properties",""));
        dlist.add(new classfieds_Data("Items",""));
        dlist.add(new classfieds_Data("Mobile Devices",""));
        dlist.add(new classfieds_Data("Jobs",""));


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView1.setLayoutManager(linearLayoutManager);
        recyclerView1.setAdapter(new classfieds_browse_adapter(getActivity(),dlist));
    }
}
