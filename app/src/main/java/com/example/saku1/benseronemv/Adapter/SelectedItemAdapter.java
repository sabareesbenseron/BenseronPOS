package com.example.saku1.benseronemv.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.saku1.benseronemv.Listener.OnItemClickListener;
import com.example.saku1.benseronemv.Model.MenuItemModel;
import com.example.saku1.benseronemv.R;

import java.util.List;

/**
 * Created by saku1 on 4/2/2017.
 */

public class SelectedItemAdapter extends RecyclerView.Adapter<SelectedItemAdapter.Holder> {

    private Context context;
    private List<MenuItemModel> selectedItemModelList;
    private OnItemClickListener listener;

    public SelectedItemAdapter(Context context, List<MenuItemModel> selectedItemModelList) {
        this.context = context;
        this.selectedItemModelList = selectedItemModelList;
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener= listener;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_adapter_selecteditem_screen_layout, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, final int position) {

        MenuItemModel selectedItemModel = selectedItemModelList.get(position);
        holder.selectedItemView.setText(selectedItemModel.getMenuitemname());
        holder.selectedItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener!=null){
                    listener.onItenClcik(v,position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return selectedItemModelList.size();
    }

    public class Holder extends RecyclerView.ViewHolder{

        TextView selectedItemView;

        public Holder(View itemView) {
            super(itemView);

            selectedItemView = (TextView) itemView.findViewById(R.id.item_adapter_selecteditem_view);
        }
    }

}
