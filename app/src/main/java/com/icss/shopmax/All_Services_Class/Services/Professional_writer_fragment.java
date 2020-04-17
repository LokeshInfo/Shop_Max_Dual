package com.icss.shopmax.All_Services_Class.Services;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.icss.shopmax.d_Adapter.Professional_Writer_Adapter;
import com.icss.shopmax.Model.Professional_Writer_Data;
import com.icss.shopmax.R;
import com.icss.shopmax.All_Services_Class.MainActivity;

import java.util.ArrayList;

public class Professional_writer_fragment extends Fragment
{
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_professional_writer,container,false);

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).onBackPressed();}
        });

        recyclerView = view.findViewById(R.id.writr_recycler_view);

        pre_data();

        return view;
    }

    private void pre_data(){

        String[] a1 ={       "https://previews.123rf.com/images/aerial3/aerial31508/aerial3150800015/43672762-resume-and-cover-letter-or-cv-template-flat-and-material-design-styled-curriculum-vitae-mail-phone-p.jpg",
                "https://c7.uihere.com/files/398/299/807/curriculum-vitae-template.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ1HJvSvRWkv2JCDJKFCksp4p1-M4VUdx9ZlhsDrMdOnl3IwJet&s",
                "https://i0.wp.com/graphicyard.com/wp-content/uploads/2019/08/Modern-CV-Design-Templates-2.jpg?fit=1800%2C1200&ssl=1",
                    };

        String[] a2= {"https://s3.amazonaws.com/thumbnails.venngage.com/template/358bde60-de34-435f-8acd-2d1afd8171a4.png",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTGD3jDjh02Xv_Wv9hwFnbXNzzyREop9Bv6afJ8kMQMtpOjmyKEkA&s",
                "https://i.pinimg.com/originals/e4/11/44/e411444ebba55ea81e90cf48cd08a550.jpg",
                "https://resumegenius.com/wp-content/uploads/2018/12/Executive-Assistant-Cover-Letter-Example-Template.png"
                };

        String[] a4 ={  "https://cmkt-image-prd.freetls.fastly.net/0.1.0/ps/3709143/600/400/m2/fpnw/wm0/01_corporate-clean-and-creative-business-project-proposal-design-template-free-download-.jpg?1512827082&s=b2c48ea98268c89722d88368d0a9853a",
                "https://i.pinimg.com/474x/92/aa/9b/92aa9b42d61d03e8e1883d72b2fe1fea.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS1_IOpab_e5K5T35SePl2Q_xv-9gu7bPZg9f6MqHKRJ7d2RS-TRA&s",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSoby27rel3gtrrYrmbp2BTxnmsiLpefFvGMHT3LODwtjr_mbjI&s",
                "https://wpamelia.com/wp-content/uploads/2019/10/Screenshot_3.jpg"
        };

        String[] a3 = { "https://cdn3.f-cdn.com/contestentries/1406119/28817279/5b8bc2b076558_thumb900.jpg",
                "https://blog.hubspot.com/hs-fs/hubfs/Business%20Plan%20Template%20for%20Sales%20Reps.jpg?width=425&name=Business%20Plan%20Template%20for%20Sales%20Reps.jpg",
                "https://www.usaid.gov/sites/default/files/DCA_one_pager_10_18cover_0.jpg",
                "http://freresoeur.co/wp-content/uploads/2019/03/it-department-strategic-plan-template-university-legal-academic-st-finance-volunteer-fire-large.jpg"
        };

        String[] a5 = {"https://thumbor.forbes.com/thumbor/960x0/https%3A%2F%2Fblogs-images.forbes.com%2Falejandrocremades%2Ffiles%2F2018%2F12%2Fbusiness-3605367_1920-1200x741.jpg",
                "https://betterproposals.io/img/quote-templates/sales/02.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS5IhgEydw9v6xm3DYMKFMYGRO0yY0YRYIPYUZvt8haFpF6m6OG&s",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR0WAca7HZe6m6FyvMKoa7-VNnOz7h7GaAz8HtIiJM0_a0Vf9Ky&s",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ7qLzAquGuBRcxAuF9iVtw_oDtsxgz42dU-QyByeIKUp8gkRHo&s",
                "https://betterproposals.io/img/quote-templates/lawn-care/02.jpg",
        };

        ArrayList<Professional_Writer_Data> dlist = new ArrayList<>();
        dlist.add(new Professional_Writer_Data("1","CV Designing",a1));
        dlist.add(new Professional_Writer_Data("2","Covering Letter",a2));
        dlist.add(new Professional_Writer_Data("3","Business Plan",a3));
        dlist.add(new Professional_Writer_Data("4","General Letter",a2));
        dlist.add(new Professional_Writer_Data("5","Business Proposals",a4));
        dlist.add(new Professional_Writer_Data("6","Quotations",a5));
        dlist.add(new Professional_Writer_Data("7","Others",a3));


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new Professional_Writer_Adapter(getActivity(),dlist));

    }


}
