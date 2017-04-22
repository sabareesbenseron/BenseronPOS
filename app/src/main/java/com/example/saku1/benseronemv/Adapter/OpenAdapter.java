package com.example.saku1.benseronemv.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.saku1.benseronemv.Model.PaymentModel;
import com.example.saku1.benseronemv.R;
import com.example.saku1.benseronemv.Activity.SecondActivity;

import java.util.List;

/**
 * Created by saku1 on 3/11/2017.
 */

public class OpenAdapter extends RecyclerView.Adapter<OpenAdapter.Holder> {

    private Context context;
    private List<PaymentModel> titleList;

    public OpenAdapter(Context context, List<PaymentModel> titleList) {
        this.context = context;
        this.titleList = titleList;
    }

    @Override
    public OpenAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_adapter_open_layout, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(OpenAdapter.Holder holder, int position) {
        final PaymentModel model = titleList.get(position);

        holder.idText.setText(model.getId());
        holder.titleText.setText(model.getTitle());
        holder.descText.setText(model.getDescription());
        holder.openLayoutContainer.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, SecondActivity.class);
                intent.putExtra("payment", model);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return titleList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView idText, titleText, descText;
        LinearLayout openLayoutContainer;

        public Holder(View itemView) {
            super(itemView);

            openLayoutContainer = (LinearLayout) itemView.findViewById(R.id.item_adapter_open_container);
            idText = (TextView) itemView.findViewById(R.id.item_adapter_open_id_view);
            titleText = (TextView) itemView.findViewById(R.id.item_adapter_open_title_view);
            descText = (TextView) itemView.findViewById(R.id.item_adapter_open_description_view);
        }
    }
}
