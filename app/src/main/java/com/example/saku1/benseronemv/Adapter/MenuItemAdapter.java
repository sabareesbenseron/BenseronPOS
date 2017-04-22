package com.example.saku1.benseronemv.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.saku1.benseronemv.Model.MenuItemModel;
import com.example.saku1.benseronemv.R;

import java.util.List;

/**
 * Created by saku1 on 4/2/2017.
 */

public class MenuItemAdapter extends RecyclerView.Adapter<MenuItemAdapter.Holder> {

    private Context context;
    private List<MenuItemModel> menuItemModelList;
    private OnItemClickListner onItemClickListner;

    public MenuItemAdapter(Context context, List<MenuItemModel> menuItemModelList) {
        this.context = context;
        this.menuItemModelList = menuItemModelList;
    }

    public void setOnItemClickListner(OnItemClickListner listner){
        this.onItemClickListner=listner;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_adapter_menuitem_screen_layout, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(MenuItemAdapter.Holder holder, final int position) {

        MenuItemModel menuItemModel = menuItemModelList.get(position);
        holder.menuItemButton.setText(menuItemModel.getMenuitemname());

        holder.menuItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListner!=null){
                    onItemClickListner.onItemClick(v,position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return menuItemModelList.size();
    }

    public class Holder extends RecyclerView.ViewHolder{

        TextView menuItemButton;

        public Holder(View itemView) {
            super(itemView);

            menuItemButton = (Button) itemView.findViewById(R.id.item_adapter_menuitem_button);

        }
    }

    public interface OnItemClickListner{
        void onItemClick(View v,int position);
    }
}
