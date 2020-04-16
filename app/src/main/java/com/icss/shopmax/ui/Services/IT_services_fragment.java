package com.icss.shopmax.ui.Services;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.icss.shopmax.d_Adapter.It_service_Adapter;
import com.icss.shopmax.R;
import com.icss.shopmax.ui.MainActivity;

import java.util.ArrayList;

public class IT_services_fragment extends Fragment
{
    RecyclerView recyclerView;
    ArrayList<String> dlist;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fagment_itservice,container,false);

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).onBackPressed();
            }
        });

        recyclerView = view.findViewById(R.id.itservice_recycler_view);

        dlist = new ArrayList<>();
        dlist.add("Android App");
        dlist.add("IOS App");
        dlist.add("WEB App");
        dlist.add("Hybrid App");
        dlist.add("Software");
        dlist.add("Operating System");
        dlist.add("Cloud Service");
        dlist.add("Others");

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2 , GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(new It_service_Adapter(getActivity(),dlist));

        return view;
    }
}
