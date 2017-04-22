package com.example.saku1.benseronemv.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.saku1.benseronemv.R;

/**
 * Created by saku1 on 3/11/2017.
 */

public class CloseAdapter extends RecyclerView.Adapter<CloseAdapter.Holder> {

    private Context context;
    public CloseAdapter(Context context){
        this.context = context;
    }

    @Override
    public CloseAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_adapter_close_layout, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(CloseAdapter.Holder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class Holder  extends RecyclerView.ViewHolder {
        TextView titleText,descText;
        public Holder(View itemView) {
            super(itemView);

            titleText = (TextView) itemView.findViewById(R.id.item_adapter_close_title_view);
            descText = (TextView) itemView.findViewById(R.id.item_adapter_close_description_view);
        }
    }
}
