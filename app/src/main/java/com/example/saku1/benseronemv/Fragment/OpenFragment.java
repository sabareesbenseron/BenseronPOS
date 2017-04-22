package com.example.saku1.benseronemv.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.saku1.benseronemv.Adapter.OpenAdapter;
import com.example.saku1.benseronemv.ApiHolder.PaymentHolder;
import com.example.saku1.benseronemv.Listener.OnHttpListener;
import com.example.saku1.benseronemv.Model.PaymentModel;
import com.example.saku1.benseronemv.R;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;

/**
 * A simple {@link Fragment} subclass.
 */
public class OpenFragment extends Fragment {

    RecyclerView openRecycleView;
    OpenAdapter openAdapter;

    List<PaymentModel> openModelList;


    public OpenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_open, container, false);

        openModelList = new ArrayList<>();

        openRecycleView = (RecyclerView) v.findViewById(R.id.OpenTab);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false);
        openRecycleView.setLayoutManager(layoutManager);

        openAdapter = new OpenAdapter(getContext(), openModelList);
        openRecycleView.setAdapter(openAdapter);

        //updateAdapter();
        callApi();
        return v;
    }

    private void callApi() {
        PaymentHolder holder = new PaymentHolder(new OnHttpListener<List<PaymentModel>>() {
            @Override
            public void onComplete(List<PaymentModel> model, boolean isValid) {
                if (model != null) {
                    openModelList.clear();
                    openModelList.addAll(model);
                    openAdapter.notifyDataSetChanged();
                }
            }
        });
        holder.execute();
    }

    private void updateAdapter() {
        openModelList.add(new PaymentModel("1", "t1", "desc"));
        openModelList.add(new PaymentModel("1", "t1", "desc"));
        openModelList.add(new PaymentModel("1", "t1", "desc"));
        openModelList.add(new PaymentModel("1", "t1", "desc"));
        openModelList.add(new PaymentModel("1", "t1", "desc"));
        openModelList.add(new PaymentModel("1", "t1", "desc"));
        openModelList.add(new PaymentModel("1", "t1", "desc"));
        openModelList.add(new PaymentModel("1", "t1", "desc"));
        openModelList.add(new PaymentModel("1", "t1", "desc"));
        openModelList.add(new PaymentModel("1", "t1", "desc"));
        openModelList.add(new PaymentModel("1", "t1", "desc"));
        openModelList.add(new PaymentModel("1", "t1", "desc"));
        openModelList.add(new PaymentModel("1", "t1", "desc"));
        openModelList.add(new PaymentModel("1", "t1", "desc"));
        openModelList.add(new PaymentModel("1", "t1", "desc"));
        openModelList.add(new PaymentModel("1", "t1", "desc"));
        openModelList.add(new PaymentModel("1", "t1", "desc"));
        openModelList.add(new PaymentModel("1", "t1", "desc"));
        openModelList.add(new PaymentModel("1", "t1", "desc"));
        openModelList.add(new PaymentModel("1", "t1", "desc"));
        openModelList.add(new PaymentModel("1", "t1", "desc"));
        openModelList.add(new PaymentModel("1", "t1", "desc"));
        openModelList.add(new PaymentModel("1", "t1", "desc"));
        openModelList.add(new PaymentModel("1", "t1", "desc"));
        openModelList.add(new PaymentModel("1", "t1", "desc"));
        openAdapter.notifyDataSetChanged();
    }

}
