package com.example.saku1.benseronemv.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.saku1.benseronemv.Adapter.CloseAdapter;
import com.example.saku1.benseronemv.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CloseFragment extends Fragment {

    RecyclerView closeRecycleView;
    CloseAdapter closeAdapter;


    public CloseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_close, container, false);

        closeRecycleView = (RecyclerView) v.findViewById(R.id.CloseTab);

        LinearLayoutManager layoutManager =new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL,false);
        closeRecycleView.setLayoutManager(layoutManager);

        closeAdapter = new CloseAdapter(getContext());
        closeRecycleView.setAdapter(closeAdapter);

        return v;
    }

}
